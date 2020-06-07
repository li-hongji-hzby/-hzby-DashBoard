package cn.hzby.lhj.api;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.hitsdb.client.value.response.LastDataValue;

import cn.hzby.lhj.po.MachineStatus;
import cn.hzby.lhj.po.Project;
import cn.hzby.lhj.po.ProjectRealtimeMachineKey;
import cn.hzby.lhj.po.ProjectRealtimeSummaryWithBLOBs;
import cn.hzby.lhj.service.MachineStatusService;
import cn.hzby.lhj.service.ProjectRealtimeMachineService;
import cn.hzby.lhj.service.ProjectRealtimeSummaryService;
import cn.hzby.lhj.util.TSDBUtils;

@CrossOrigin
@RestController
@RequestMapping("/RealTime")
public class RealTimeAPI {


	@Autowired
	private MachineStatusService machineStatusService;
	@Autowired
	private ProjectRealtimeMachineService projectRealtimeMachineService;
	@Autowired
	private ProjectRealtimeSummaryService projectRealtimeSummaryService;
	
	
//	@RequestMapping("/listRealTimeDatas")
//	public Map<String, Object> listRealTimeDatas() throws Exception{
//		TSDBUtils tsdbUtils  = new TSDBUtils();
//		Map<String, Object> realTimeDatas = new HashMap<String, Object>(); 
//		long time = (long)System.currentTimeMillis()/1000;
//		realTimeDatas.put("空压机", realtimeAirCompressorService.listAll());
//		realTimeDatas.put("干燥机", realtimeDryerService.listAll());
//		realTimeDatas.put("流量计", realtimeFlowMeterService.listAll());
//		Map<String, Object> result = new HashMap<String, Object>(); 
//		result.put("realTimeDatas", realTimeDatas);
//		result.put("change", false);
//		DecimalFormat df = new DecimalFormat("#.00");
//		DecimalFormat df2 = new DecimalFormat("#.0000");
//		List<LastDataValue> getFlowrate = tsdbUtils.getLastOne(time, "flowrate");
//		double flowrate = ((BigDecimal) getFlowrate.get(0).getValue()).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue()
//				+((BigDecimal) getFlowrate.get(1).getValue()).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue()
//				+((BigDecimal) getFlowrate.get(2).getValue()).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
//		double ele = ((BigDecimal) tsdbUtils.getLastOne(time, "active_power").get(0).getValue()).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
//		JSONObject obj = new JSONObject();
//		if(flowrate >0) {
//			obj.put("流量",Double.valueOf(df.format(flowrate/60)));
//			obj.put("功率",Double.valueOf(df.format(ele/100)));
//			obj.put("压力",6.3);
//			obj.put("单耗",Double.valueOf(df2.format(ele/100/flowrate)));
//			result.put("change", true);
//		}
////		realtimeOverview.add();
//		result.put("realtimeOverview", obj);
//		return result;
//	}
	

	@RequestMapping(value = "/listRealTimeDatas",method = RequestMethod.POST)
	public Map<String, Object> listRealTimeDatas(@RequestBody JSONObject jsonObj) throws Exception{
		Map<?, ?> tableMsgMap = JSON.parseObject(JSON.toJSONString(jsonObj.get("tableMsg")),Map.class);
		String project = (String)((Map<?, ?>)jsonObj.get("project")).get("projectNameEn");
		Map<String,Object> resultMap = new LinkedHashMap<String, Object>(16);
		// 根据机器类型取出数据
		for (Entry<?, ?> tableMsgEntry : tableMsgMap.entrySet()) {
			// 取出属性存为List
			List<String> attrList = new ArrayList<String>();
			Map<?, ?> attrsMap = (JSONObject)(((JSONObject)tableMsgEntry.getValue()).get("attributes"));
			for (Entry<?, ?> attrEntry : attrsMap.entrySet()) {
				attrList.add((String)attrEntry.getValue());
			}
			Map<String, Object> machineMap = (JSONObject)(((JSONObject)tableMsgEntry.getValue()).get("machines"));
			List<Object> resList =new ArrayList<Object>();
			for (Entry<?, ?> machineEntry : machineMap.entrySet()) {
				TSDBUtils tsdbUtils  = new TSDBUtils();
				List<LastDataValue> queryList = tsdbUtils.getLastMulti(attrList,(String)machineEntry.getValue(),project);
				Map<String,Object> mechine = new LinkedHashMap<String, Object>(16);
				mechine.put("machine", machineEntry.getKey());
//				mechine.put("status", ((BigDecimal)queryList.stream().filter(g -> g.getMetric().equals("P")).findFirst().get().getValue()).doubleValue()>1?true : false);
//				System.out.println(tsdbUtils.getLastOne("P","energy_meter_1:ZJG"));
				mechine.put("status",true);
				ProjectRealtimeMachineKey key = new ProjectRealtimeMachineKey();
				key.setMachineNameEn((String)machineEntry.getValue());
				key.setProjectNameEn(project);
				MachineStatus machineStatus = machineStatusService.getById(Integer.valueOf(projectRealtimeMachineService.getById(key).getMachinePower()));
				LastDataValue pwoer = tsdbUtils.getLastOne(machineStatus.getAttrribute(), machineStatus.getMachineName()).get(0);
				mechine.put("status", ((BigDecimal)pwoer.getValue()).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue()>machineStatus.getMin()?true : false);
				queryList.stream().forEach( f -> mechine.put(f.getMetric(), ((BigDecimal) f.getValue()).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue()));
				resList.add(mechine);
			}
			resultMap.put((String)tableMsgEntry.getKey(), resList);
		}
		return resultMap;
	}
	
	@SuppressWarnings("serial")
	@RequestMapping(value = "/getRealtimeSummary",method = RequestMethod.POST)
	public Map<String, Double> getRealtimeSummary(@RequestBody JSONObject jsonObj) throws Exception{
		Project project = JSON.parseObject(JSON.toJSONString(jsonObj.get("project")), Project.class);
		List<Map<String, String>> queryMapList = new ArrayList<Map<String,String>>();
		List<ProjectRealtimeSummaryWithBLOBs> summaryList = projectRealtimeSummaryService.getByProject((String) ((Map<?, ?>)jsonObj.get("project")).get("projectNameEn"));
		summaryList.parallelStream().forEach( e -> {
			JSON.parseArray(e.getMachineList(), String.class).parallelStream().forEach( f -> {
				queryMapList.add(new HashMap<String, String>(){{
				      put("metric",e.getAttribute());  
				      put("device",f);
				}});
			}); 
		});
		TSDBUtils tsdbUtils  = new TSDBUtils();
		Map<String, List<LastDataValue>> a = (tsdbUtils.getRealtimeSummary(queryMapList,project.getProjectNameEn()).stream().collect(Collectors.groupingBy(LastDataValue::getMetric)));
		Map<String,Double> sumMap = new HashMap<String, Double>();
		a.keySet().forEach( e-> sumMap.put(e, a.get(e).stream().mapToDouble(p -> (Double.valueOf(new DecimalFormat("#.00").format(p.getValue()))))
		         .sum()));
		Map<String,Double> resultMap = new HashMap<String, Double>();
		summaryList.parallelStream().forEach(e -> resultMap.put(e.getDataName(), sumMap.get(e.getAttribute())));
		resultMap.put("单耗", Double.valueOf(new DecimalFormat("#.00").format(resultMap.get("功率")/resultMap.get("流量"))));
		return resultMap;
	}
}
