package cn.hzby.lhj.api;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import cn.hzby.lhj.service.RealtimeAirCompressorService;
import cn.hzby.lhj.service.RealtimeDryerService;
import cn.hzby.lhj.service.RealtimeFlowMeterService;
import cn.hzby.lhj.service.RealtimeOverviewService;
import cn.hzby.lhj.util.TSDBUtils;

@CrossOrigin
@RestController
@RequestMapping("/RealTime")
public class RealTimeAPI {

	@Autowired
	private RealtimeAirCompressorService realtimeAirCompressorService;
	
	@Autowired
	private RealtimeDryerService realtimeDryerService;
	
	@Autowired
	private RealtimeFlowMeterService realtimeFlowMeterService;
	
	@Autowired
	private RealtimeOverviewService realtimeOverviewService;
	
	@RequestMapping("/listRealTimeDatas")
	public Map<String, Object> listRealTimeDatas() throws Exception{
		TSDBUtils tsdbUtils  = new TSDBUtils();
		Map<String, Object> realTimeDatas = new HashMap<String, Object>(); 
		long time = (long)System.currentTimeMillis()/1000;
		realTimeDatas.put("空压机", realtimeDryerService.listAll());
		realTimeDatas.put("干燥机", realtimeDryerService.listAll());
		realTimeDatas.put("流量计", realtimeFlowMeterService.listAll());
		Map<String, Object> result = new HashMap<String, Object>(); 
		result.put("realTimeDatas", realTimeDatas);
		result.put("change", false);
		List<Map<String,Double>> realtimeOverview = new ArrayList<Map<String,Double>>();
		DecimalFormat df = new DecimalFormat("#.00");
		DecimalFormat df2 = new DecimalFormat("#.0000");
		System.out.println(tsdbUtils.getLastOne(time, "flowrate"));
		double flowrate = ((BigDecimal) tsdbUtils.getLastOne(time, "flowrate").get(0).getValue()).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue()
				+((BigDecimal) tsdbUtils.getLastOne(time, "flowrate").get(1).getValue()).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue()
				+((BigDecimal) tsdbUtils.getLastOne(time, "flowrate").get(2).getValue()).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
		double ele = ((BigDecimal) tsdbUtils.getLastOne(time, "active_power").get(0).getValue()).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
		JSONObject obj = new JSONObject();
		if(flowrate >0) {
			obj.put("流量",Double.valueOf(df.format(flowrate/60)));
			obj.put("功率",Double.valueOf(df.format(ele/100)));
			obj.put("压力",6.3);
			obj.put("单耗",Double.valueOf(df2.format(ele/100/flowrate)));
			result.put("change", true);
		}
		System.out.println(obj);
//		realtimeOverview.add();
		result.put("realtimeOverview", obj);
		return result;
	}
	
}
