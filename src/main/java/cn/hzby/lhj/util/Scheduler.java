package cn.hzby.lhj.util;





import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

import cn.hzby.lhj.api.HomeAPI;
import cn.hzby.lhj.po.ProjectMainHistory;
import cn.hzby.lhj.po.ProjectMainSummary;
import cn.hzby.lhj.service.MachineAttributeService;
import cn.hzby.lhj.service.ProjectMainHistoryService;
import cn.hzby.lhj.service.ProjectMainSummaryService;
import cn.hzby.lhj.service.ProjectRealtimeMachineService;

@Component
public class Scheduler {

    @Resource
    private RedisUtil redisUtil;

    @Resource
    private ProjectMainSummaryService projectMainSummaryService;

    @Resource
    private ProjectMainHistoryService projectMainHistoryService;
    
    @Resource
    private ProjectRealtimeMachineService projectRealtimeMachineService;
    
    @Resource
    private MachineAttributeService machineAttributeService;
    
	@SuppressWarnings("serial")
	@Scheduled(fixedRate=10000)
	public void testTasks1() throws Exception {
		List<ProjectMainSummary> summaryList = projectMainSummaryService.listAll();
		Map<String, Map<String, Double>> result =  TSDBUtils.getMainSummary(summaryList);
//		System.out.println(Thread.currentThread().getName());
		result.keySet().forEach( e -> {
			if(result.get(e).get("flowrate")>0 && result.get(e).get("P")>0) {
				redisUtil.hmset(e, new HashMap<String,Object>() {{
					put("summary",JSON.toJSONString(new HashMap<String,Double>(){{
						put("气",Double.parseDouble(String.format("%.2f",result.get(e).get("flowrate"))));
						put("电",Double.parseDouble(String.format("%.2f",result.get(e).get("P"))));
						put("单耗",Double.parseDouble(String.format("%.2f",result.get(e).get("P")/(result.get(e).get("flowrate")*60))));
					}}));
				}});
			}
		});
		List<ProjectMainHistory> historyList = projectMainHistoryService.listAll();
		Map<String, List<ProjectMainHistory>> projectMap = historyList.stream().collect(Collectors.groupingBy(ProjectMainHistory::getProjectNameEn));
		projectMap.keySet().forEach( e-> {
			projectMap.get(e).stream().forEach( f -> {
				try {
					redisUtil.hmset(e, new HashMap<String, Object>() {{
						put("DaysData",JSON.toJSONString(HomeAPI.getMainChartData(System.currentTimeMillis()/1000 - 86400 *30, "1dc",e, JSON.parseArray(f.getAttribute(),String.class))));
						put("HoursData",JSON.toJSONString(HomeAPI.getMainChartData(System.currentTimeMillis()/1000 - 86400 *2, "1hc",e, JSON.parseArray(f.getAttribute(),String.class))));
						put("MonthsData", JSON.toJSONString(HomeAPI.getMainChartData(System.currentTimeMillis()/1000 - 86400 *30 * 24, "1nc", e,JSON.parseArray(f.getAttribute(),String.class))));
					}});
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			});
		});
//		redisUtil.set("DaysData", JSON.toJSONString(HomeAPI.getMainChartData(System.currentTimeMillis()/1000 - 86400 *30, "1dc","张家港", "active_power", "flowrate")));
	}
	
//	@Scheduled(fixedRate=10000)
//	public void testTasks2() throws Exception {
//		Map<String, List<ProjectRealtimeMachine>> projectMap = projectRealtimeMachineService.listAll().stream().collect(Collectors.groupingBy(ProjectRealtimeMachine::getProjectNameEn));
//		projectMap.keySet().forEach( e -> {
//			System.out.println(JSON.toJSONString(projectMap.get(e)));
//			projectMap.get(e).stream().forEach( f -> {
//				List<Integer> ids = new ArrayList<>();
//				JSON.parseArray(f.getAttributeList(), String.class).stream().forEach( g -> ids.add(Integer.valueOf(g)));
//				try {
//					System.out.println(JSON.toJSONString(machineAttributeService.listByIds(ids)));
//					System.out.println(f.getMachineNameEn());
//				} catch (Exception e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			});
//		});
//	}
//	
//	@Scheduled(fixedRate=10000)
//	public void testTasks3() throws Exception {
//		redisUtil.set("MonthsData", JSON.toJSONString(HomeAPI.getMainChartData(System.currentTimeMillis()/1000 - 86400 *30 * 24, "1nc", "张家港","active_power", "flowrate")));
//	}
}