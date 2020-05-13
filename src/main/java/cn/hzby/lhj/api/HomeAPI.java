package cn.hzby.lhj.api;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
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
import cn.hzby.lhj.vo.HomeCardVo;

/**
 * @version: V1.0
 * @author: LHJ
 * @className: HomeAPI
 * @packageName: api
 * @description: 首页数据API
 * @data: 2020-05-13 11:20
 **/
@CrossOrigin
@RestController
@RequestMapping("/Home")
public class HomeAPI {

	// 获取 5分钟/n小时 数据点
	@RequestMapping(value = "/getHoursAgo", method = RequestMethod.POST)
	public Map<String,Object> getHoursAgo(@RequestBody String getJSON) throws Exception{
		TSDBUtils tsdbUtils = new TSDBUtils();
		Map<String, String> JSONMap = JSON.parseObject(getJSON, new TypeReference<Map<String, String>>(){});
        String metricsListStr = (String) JSONMap.get("metrics");
		List<String> metricsList = JSONObject.parseArray(metricsListStr,String.class);
		List<QueryResult> qs = tsdbUtils.get5MinAvg(Integer.valueOf(JSONMap.get("hour")), metricsList);
		Set<Entry<Long, Object>> entrys = qs.get(0).getDps().entrySet();
		Map<Long, Object> airDatas = new HashMap<Long,Object>(16);
		airDatas = qs.get(1).getDps();
		List<HomeCardVo> hcVoList = new ArrayList<HomeCardVo>();
		DecimalFormat df = new DecimalFormat("#.00");
		DecimalFormat df2 = new DecimalFormat("#.0000");
		for(Entry<Long, Object> entry : entrys) {
			HomeCardVo hdVO = new HomeCardVo();
			Long key = entry.getKey();
			double ele = ((BigDecimal) entry.getValue()).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue(); // BigDecimal转小数点后两位Double 
			double air = ((BigDecimal) airDatas.get(key)).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
			hdVO.setTimestamp(key);
			hdVO.setElectricity(Double.valueOf(df.format(ele/100)));
			hdVO.setAir(Double.valueOf(df.format(air/60)));
			hdVO.setUnitCost(Double.valueOf(df2.format(ele/100/air)));
			hcVoList.add(hdVO);
		}
		HomeCardVo avgHcVo = new HomeCardVo();
		// 流式编程取平均值
		avgHcVo.setElectricity(Double.valueOf(df.format(hcVoList.stream().mapToDouble(HomeCardVo::getElectricity).average().getAsDouble())));
		avgHcVo.setAir(Double.valueOf(new DecimalFormat("#.00").format(hcVoList.stream().mapToDouble(HomeCardVo::getAir).average().getAsDouble())));
		avgHcVo.setUnitCost(Double.valueOf(df2.format(hcVoList.stream().mapToDouble(HomeCardVo::getUnitCost).average().getAsDouble())));
		Map<String,Object> result = new HashMap<String, Object>(16);
		result.put("datas", hcVoList);
		result.put("avgData", avgHcVo);
		return result;
	}

	// 根据传入 metric 以及 downsample 获取数据
	@RequestMapping(value = "/getMainChartData", method = RequestMethod.POST)
	public List<HomeCardVo> getMainChartData(@RequestBody String getJSON)throws Exception{
		TSDBUtils tsdbUtils = new TSDBUtils();
		Map<String, String> JSONMap = JSON.parseObject(getJSON, new TypeReference<Map<String, String>>(){});
        String metricsListStr = (String) JSONMap.get("metrics");
		List<String> metrics =  JSONObject.parseArray(metricsListStr,String.class);
		List<QueryResult> qs = tsdbUtils.getByTimeAndDownSample(Long.valueOf(JSONMap.get("timestamp")), metrics,JSONMap.get("downsample"));
		Set<Entry<Long, Object>> entrys = qs.get(0).getDps().entrySet();
		Map<Long, Object> airDatas = new HashMap<Long,Object>(16);
		airDatas = qs.get(1).getDps();
		List<HomeCardVo> hcVoList = new ArrayList<HomeCardVo>();
		DecimalFormat df = new DecimalFormat("#.00");
		DecimalFormat df2 = new DecimalFormat("#.0000");
		for(Entry<Long, Object> entry : entrys) {
			HomeCardVo hdVO = new HomeCardVo();
			Long key = entry.getKey();
			double ele = ((BigDecimal) entry.getValue()).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue(); // BigDecimal转小数点后两位Double
			double air = 0.0;
			try {
				air = ((BigDecimal) airDatas.get(key)).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
			} catch (Exception e) {
				continue;
			}
			hdVO.setTimestamp(key);
			hdVO.setElectricity(Double.valueOf(df.format(ele/100)));
			hdVO.setAir(Double.valueOf(df.format(air/60)));
			hdVO.setUnitCost(Double.valueOf(df2.format(ele/100/air)));
			hcVoList.add(hdVO);
		}
		return hcVoList;
	}
}
