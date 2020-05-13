package cn.hzby.lhj.api;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Stream;

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
		Map<String, String> JSONMap = JSON.parseObject(getJSON, new TypeReference<Map<String, String>>(){});
        String metricsListStr = (String) JSONMap.get("metrics");
		List<String> metricsList = JSONObject.parseArray(metricsListStr,String.class);
		// 调用方法从TSDB获取数据
		List<QueryResult> queryResult = tsdbUtils.getData(Long.valueOf(JSONMap.get("startTime")), Long.valueOf(JSONMap.get("endTime")), JSONMap.get("device"), JSONMap.get("downsample"), metricsList);
		Map<String, Object> result = new HashMap<String, Object>(16);
		// 转换数据格式并重新封装
		// 使用并发流处理数据，约提升50%效率
		Stream<QueryResult> qsStream = queryResult.parallelStream();
		qsStream.forEach( e -> {
			// 日期格式化 
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
			List<String> times= new ArrayList<>();
			List<Integer> datas= new ArrayList<>();
			Set<Entry<Long, Object>> entries = e.getDps().entrySet();
			for(Entry<Long, Object> entry : entries) {
				times.add(sdf.format(Long.valueOf(entry.getKey().toString())*1000));
				datas.add((Double.valueOf(entry.getValue().toString())).intValue());
			}
			List<Object> arrList = new ArrayList<>();
			arrList.add(times);
			arrList.add(datas);
			result.put(e.getMetric(), arrList);
		});
		return result;
	}
	
}
