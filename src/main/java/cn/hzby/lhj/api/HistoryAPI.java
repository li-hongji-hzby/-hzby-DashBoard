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

import com.alibaba.fastjson.JSONObject;
import com.aliyun.hitsdb.client.value.response.QueryResult;

import cn.hzby.lhj.util.TSDBUtils;

@RequestMapping("/History")
@RestController
@CrossOrigin
public class HistoryAPI {
	

	/**
	* @version: V2.0
	* @author:  LHJ
	* @methodsName: getHistory
	* @description: 获取历史数据页数据
	* @param: JSONObject jsonObj
	* @return: Map<String, Object>
	* @throws: 
	*/
	@RequestMapping(value="/getHistory",method =RequestMethod.POST)
	public Map<String, Object> test(@RequestBody JSONObject jsonObj) throws Exception{
		TSDBUtils tsdbUtils = new TSDBUtils();
		List<String> metricsList = new ArrayList<String>();
		@SuppressWarnings("unchecked")
		Map<String, Object> metricMap = (Map<String, Object>) jsonObj.get("metrics");
		for (Entry<?, ?> metricEntry : metricMap.entrySet()) {
			metricsList.add((String)metricEntry.getKey());
		}
		// 调用方法从TSDB获取数据
		List<QueryResult> queryResult = tsdbUtils.getData(Long.valueOf((Integer)jsonObj.get("startTime"))
				, Long.valueOf((Integer) jsonObj.get("endTime"))
				, (String) jsonObj.get("device")
				, (String)jsonObj.get("downsample")
				, metricsList);
		Map<String, Object> result = new HashMap<String, Object>(16);
		Stream<QueryResult> qsStream = queryResult.parallelStream();
		// 转换数据格式并重新封装
		// 使用并发流处理数据，约提升50%效率
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
			result.put((String) metricMap.get(e.getMetric()), arrList);
		});
		System.out.println(result);
		return result;
	}
}
