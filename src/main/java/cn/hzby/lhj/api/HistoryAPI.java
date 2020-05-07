package cn.hzby.lhj.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.aliyun.hitsdb.client.value.response.QueryResult;

import cn.hzby.lhj.util.TSDBUtils;

@RequestMapping("/History")
@RestController
@CrossOrigin
public class HistoryAPI {
	
	@RequestMapping(value="/getHistory",method =RequestMethod.POST)
	public Map<String, Object> getHistory(@RequestBody String getJSON) throws Exception{
		TSDBUtils tsdbUtils = new TSDBUtils();
		// now, now - 36000 *1000,"yuanyang_flowmeter_02", "10m-avg","cumulative_flow_rate_higher","cumulative_flow_rate_lower"
		Map<String, String> JSONMap = JSON.parseObject(getJSON, new TypeReference<Map<String, String>>(){});
//        System.out.println(JSONMap);
        String metricsListStr = (String) JSONMap.get("metrics");
		List<String> metricsList = JSONObject.parseArray(metricsListStr,String.class);
		List<QueryResult> queryResult = tsdbUtils.getData(Long.valueOf(JSONMap.get("startTime")), Long.valueOf(JSONMap.get("endTime")), JSONMap.get("device"), JSONMap.get("downsample"), metricsList);
//		System.out.println(queryResult);
		Map<String, Object> result = new HashMap<String, Object>();
		for(QueryResult qs:queryResult) {
//			System.out.println(qs.getDps());
			Set<Entry<Long, Object>> entries = qs.getDps().entrySet();
			List<String> times= new ArrayList<>();
			List<Double> datas= new ArrayList<>();
			for(Entry<Long, Object> entry : entries) {
				times.add(entry.getKey().toString());
				datas.add(Double.valueOf(entry.getValue().toString()));
			}
			List<Object> arrList = new ArrayList<>();
			arrList.add(times);
			arrList.add(datas);
			result.put(qs.getMetric(), arrList);
		}
		return result;
	}
	
	@RequestMapping(value="/test",method =RequestMethod.GET)
	public List<QueryResult> test() throws Exception{
		TSDBUtils tsdbUtils = new TSDBUtils();
		return tsdbUtils.test();
	}
}
