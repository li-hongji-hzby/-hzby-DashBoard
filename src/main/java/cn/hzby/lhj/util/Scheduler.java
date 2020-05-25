package cn.hzby.lhj.util;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

import cn.hzby.lhj.api.HomeAPI;

@Component
public class Scheduler {

    @Resource
    private RedisUtil redisUtil;
    
	@Scheduled(fixedRate=10000)
	public void testTasks1() throws Exception { 
		redisUtil.set("DaysData", JSON.toJSONString(HomeAPI.getMainChartData(System.currentTimeMillis()/1000 - 86400 *30, "1dc", "active_power", "flowrate")));
	}
	
	@Scheduled(fixedRate=10000)
	public void testTasks2() throws Exception {    
		redisUtil.set("HoursData", JSON.toJSONString(HomeAPI.getMainChartData(System.currentTimeMillis()/1000 - 86400 *2, "1hc", "active_power", "flowrate")));
	}
	
	@Scheduled(fixedRate=10000)
	public void testTasks3() throws Exception {    
		redisUtil.set("MonthsData", JSON.toJSONString(HomeAPI.getMainChartData(System.currentTimeMillis()/1000 - 86400 *30 * 24, "1nc", "active_power", "flowrate")));
	}
}