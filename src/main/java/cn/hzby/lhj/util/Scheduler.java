package cn.hzby.lhj.util;





import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import cn.hzby.lhj.po.Project;
import cn.hzby.lhj.po.ProjectRealtimeSummaryWithBLOBs;
import cn.hzby.lhj.service.ProjectRealtimeSummaryService;
import cn.hzby.lhj.service.ProjectService;
import com.aliyun.hitsdb.client.value.response.LastDataValue;
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

	@Resource
	private ProjectRealtimeSummaryService projectRealtimeSummaryService;

	@Resource
	private ProjectService projectService;

	private static final String FLOWRATE = "flowrate";
	private static final String P = "P";

	@Scheduled(fixedRate=1000*10)
	public void testTasks1() throws Exception {
		preCacheMainSummary();
		preCacheMainData();
		preCacheRealtimeSummary();
	}

	@SuppressWarnings("serial")
	public void preCacheMainSummary() throws Exception{
		List<ProjectMainSummary> summaryList = projectMainSummaryService.listAll();
		Map<String, Map<String, Double>> result =  TsdbUtils.getMainSummary(summaryList);
		result.keySet().forEach( e -> {
			if(result.get(e).get(FLOWRATE)>0 && result.get(e).get(P)>0) {
				redisUtil.hmset(e, new HashMap<String,Object>(16) {{
					put("summary",JSON.toJSONString(new HashMap<String,Double>(16){{
						put("气",Double.parseDouble(String.format("%.0f",result.get(e).get(FLOWRATE)*60)));
						put("电",Double.parseDouble(String.format("%.0f",result.get(e).get(P))));
						put("单耗",Double.parseDouble(String.format("%.3f",result.get(e).get(P)/(result.get(e).get(FLOWRATE)*60))));
					}}));
				}});
			}
		});
	}

	@SuppressWarnings("serial")
	public void preCacheMainData() throws Exception{
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

	@SuppressWarnings("serial")
	public void preCacheRealtimeSummary() throws Exception{
		// 查询所有项目并去重
		List<Project> projectList = projectService.listAll().stream()
				.collect(Collectors.collectingAndThen(Collectors.toCollection(()->new TreeSet<>(Comparator.comparing(Project::getProjectNameEn))), ArrayList::new));
		List<Map<String, String>> queryMapList = new ArrayList<Map<String,String>>();
		projectList.parallelStream().forEach( project -> {
			try {
				List<ProjectRealtimeSummaryWithBLOBs> realTimeSummaryList = projectRealtimeSummaryService.getByProject(project.getProjectNameEn());
				realTimeSummaryList.stream().forEach(e -> {
					JSON.parseArray(e.getMachineList(), String.class).parallelStream().forEach( f -> {
						queryMapList.add(new HashMap<String, String>(16){{
							put("metric",e.getAttribute());
							put("device",f);
						}});
					});
				});
				TsdbUtils tsdbUtils  = new TsdbUtils();
				Map<String, List<LastDataValue>> a = tsdbUtils.getRealtimeSummary(queryMapList,project.getProjectNameEn()).stream().collect(Collectors.groupingBy(LastDataValue::getMetric));
				Map<String,Double> sumMap = new HashMap<String, Double>(16);
				a.keySet().forEach( e -> sumMap.put(e, a.get(e).stream().mapToDouble(p -> (Double.valueOf(new DecimalFormat("#.00").format(p.getValue()))))
							.sum()));
				Map<String,Double> resultMap = new HashMap<String, Double>(16);
				realTimeSummaryList.parallelStream().forEach(e -> resultMap.put(e.getDataName(), sumMap.get(e.getAttribute())));
				resultMap.put("单耗", Double.valueOf(new DecimalFormat("#.000").format(resultMap.get("功率")/(resultMap.get("流量")*60))));
				redisUtil.hmset(project.getProjectNameEn(), new HashMap<String, Object>(16) {{
					put("RealTimeSummary",JSON.toJSONString(resultMap));
				}});
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
}