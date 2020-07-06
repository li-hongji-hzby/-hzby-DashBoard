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

import javax.annotation.Resource;

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
import cn.hzby.lhj.util.RedisUtil;
import cn.hzby.lhj.util.TSDBUtils;

/**
 * @version: V1.0
 * @author: LHJ
 * @className: RealTime
 * @packageName: api
 * @description: 实时数据API
 * @data: 2020-07-06 09:56
 **/
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

    @Resource
    private RedisUtil redisUtil;

	// 获取实时数据页机器数据
	@RequestMapping(value = "/listRealTimeDatas",method = RequestMethod.POST)
	public Map<String, Object> listRealTimeDatas(@RequestBody JSONObject jsonObj) throws Exception{
		Map<?, ?> tableMsgMap = JSON.parseObject(JSON.toJSONString(jsonObj.get("tableMsg")),Map.class);
		String project = (String)((Map<?, ?>)jsonObj.get("project")).get("projectNameEn");
		Map<String,Object> resultMap = new LinkedHashMap<String, Object>(16);
		long start = System.currentTimeMillis();
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
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		return resultMap;
	}
	
	// 获取实时数据页数据总和
	@SuppressWarnings("serial")
	@RequestMapping(value = "/getRealtimeSummary",method = RequestMethod.POST)
	public Map<String, Double> getRealtimeSummary(@RequestBody JSONObject jsonObj) throws Exception{
		System.out.println(jsonObj);
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


	// 从缓存中获取实时数据页机器数据
	@SuppressWarnings("serial")
	@RequestMapping(value = "/listRealTimeDatasCache",method = RequestMethod.POST)
	public Map<String, Object> listRealTimeDatasCache(@RequestBody JSONObject jsonObj) throws Exception{
		Map<?, ?> tableMsgMap = JSON.parseObject(JSON.toJSONString(jsonObj.get("tableMsg")),Map.class);
		String project = (String)((Map<?, ?>)jsonObj.get("project")).get("projectNameEn");
		Map<String,Object> resultMap = new LinkedHashMap<String, Object>(16);
		long start = System.currentTimeMillis();
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
				List<Object> machineAttrList =new ArrayList<Object>();
				machineAttrList.add(machineEntry.getKey());
				ProjectRealtimeMachineKey key = new ProjectRealtimeMachineKey();
				key.setMachineNameEn((String)machineEntry.getValue());
				key.setProjectNameEn(project);
				MachineStatus machineStatus = machineStatusService.getById(Integer.valueOf(projectRealtimeMachineService.getById(key).getMachinePower()));
//				System.out.println(Double.valueOf(String.format("%f",redisUtil.hget(machineStatus.getMachineName(), machineStatus.getAttrribute()))));
				machineAttrList.add(Double.valueOf(String.format("%.2f",Double.valueOf(redisUtil.hget(machineStatus.getMachineName(), machineStatus.getAttrribute()).toString())))> Double.valueOf(machineStatus.getMin()) ? true : false);
				for(String str : attrList) {
					machineAttrList.add(redisUtil.hget((String) machineEntry.getValue(), str));
				}
				resList.add(machineAttrList);
			}
			resultMap.put((String)tableMsgEntry.getKey(), resList);
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);
//		System.out.println(resultMap);
		return resultMap;
	}
}
