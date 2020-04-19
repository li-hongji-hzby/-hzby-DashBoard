package cn.hzby.lhj.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.hzby.lhj.service.RealtimeAirCompressorService;
import cn.hzby.lhj.service.RealtimeDryerService;
import cn.hzby.lhj.service.RealtimeFlowMeterService;

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
	
	@RequestMapping("/listRealTimeDatas")
	public Map<String, Object> listRealTimeDatas() throws Exception{
		Map<String, Object> realTimeDatas = new HashMap<String, Object>(); 
		realTimeDatas.put("空压机", realtimeAirCompressorService.listAll());
		realTimeDatas.put("干燥机", realtimeDryerService.listAll());
		realTimeDatas.put("流量计", realtimeFlowMeterService.listAll());
		return realTimeDatas;
	}
	
}
