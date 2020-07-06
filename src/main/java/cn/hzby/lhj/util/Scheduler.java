package cn.hzby.lhj.util;





import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

import cn.hzby.lhj.api.HomeApi;
import cn.hzby.lhj.po.ProjectMainHistory;
import cn.hzby.lhj.po.ProjectMainSummary;
import cn.hzby.lhj.service.ProjectMainHistoryService;
import cn.hzby.lhj.service.ProjectMainSummaryService;

@Component
/**
 * @version: V1.0
 * @author: LHJ
 * @className: Scheduler
 * @packageName: util
 * @description: 后台数据存入缓存
 * @data: 2020-05-13 11:20
 **/
public class Scheduler {

    @Resource
    private RedisUtil redisUtil;

    @Resource
    private ProjectMainSummaryService projectMainSummaryService;

    @Resource
    private ProjectMainHistoryService projectMainHistoryService;

	@SuppressWarnings("serial")
	@Scheduled(fixedRate=10000)
	public void testTasks1() throws Exception {
		List<ProjectMainSummary> summaryList = projectMainSummaryService.listAll();
		Map<String, Map<String, Double>> result =  TsdbUtils.getMainSummary(summaryList);
		result.keySet().forEach( e -> {
			if(result.get(e).get("flowrate")>0 && result.get(e).get("P")>0) {
				redisUtil.hmset(e, new HashMap<String,Object>(16) {{
					put("summary",JSON.toJSONString(new HashMap<String,Double>(16){{
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
					redisUtil.hmset(e, new HashMap<String, Object>(16) {{
						put("DaysData",JSON.toJSONString(HomeApi.getMainChartData(System.currentTimeMillis()/1000 - 86400 *30, "1dc",e, JSON.parseArray(f.getAttribute(),String.class))));
						put("HoursData",JSON.toJSONString(HomeApi.getMainChartData(System.currentTimeMillis()/1000 - 86400 *2, "1hc",e, JSON.parseArray(f.getAttribute(),String.class))));
						put("MonthsData", JSON.toJSONString(HomeApi.getMainChartData(System.currentTimeMillis()/1000 - 86400 *30 * 24, "1nc", e,JSON.parseArray(f.getAttribute(),String.class))));
					}});
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			});
		});
	}

}