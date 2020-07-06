package cn.hzby.lhj.api;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.aliyun.hitsdb.client.value.response.QueryResult;

import cn.hzby.lhj.util.RedisUtil;
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

    @Resource
    private RedisUtil redisUtil;

	/**
	* @version: V1.0
	* @author:  LHJ
	* @methodsName: getHoursAgo
	* @description: 获取 5分钟/n小时 数据点
	* @param: String getJSON
	* @return: Map<String, Object>
	* @throws: 
	*/
	@SuppressWarnings("finally")
	@RequestMapping(value = "/getHoursAgo", method = RequestMethod.POST)
	public Map<String,Object> getHoursAgo(@RequestBody String getJson) throws Exception{
		TSDBUtils tsdbUtils = new TSDBUtils();
		Map<String, String> JsonMap = JSON.parseObject(getJson, new TypeReference<Map<String, String>>(){});
        String metricsListStr = JsonMap.get("metrics");
		List<String> metricsList = JSONObject.parseArray(metricsListStr,String.class);
		List<QueryResult> qs = tsdbUtils.get5MinAvg(Integer.valueOf(JsonMap.get("hour")), metricsList);
		Set<Entry<Long, Object>> entrys = qs.get(0).getDps().entrySet();
		Map<Long, Object> airDatas = new HashMap<Long,Object>(16);
		airDatas = qs.get(0).getDps();
		List<HomeCardVo> hcVoList = new ArrayList<HomeCardVo>();
		DecimalFormat df = new DecimalFormat("#.00");
		DecimalFormat df2 = new DecimalFormat("#.0000");
		for(Entry<Long, Object> entry : entrys) {
			HomeCardVo hdVO = new HomeCardVo();
			Long key = entry.getKey();
			double ele = ((BigDecimal) entry.getValue()).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue(); // BigDecimal转小数点后两位Double 
			try {
				double air = ((BigDecimal) airDatas.get(key)).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
				hdVO.setTimestamp(key);
				hdVO.setElectricity(Double.valueOf(df.format(ele/100)));
				hdVO.setAir(Double.valueOf(df.format(air/60)));
				hdVO.setUnitCost(Double.valueOf(df2.format(ele/100/air)));
				hcVoList.add(hdVO);
			} catch (Exception e) {
				throw e;
			}finally {
				continue;
			}
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

	/**
	* @version: V1.0
	* @author:  LHJ
	* @methodsName: getMonthsData
	* @description: 从redis获取年数据
	* @param: JSONObject jsonObj
	* @return: String
	* @throws: 
	*/
	@RequestMapping(value = "/getMonthsData", method = RequestMethod.POST)
	public String getMonthsData(@RequestBody JSONObject jsonObj)throws Exception{
		String project = (String)((Map<?, ?>)jsonObj.get("project")).get("projectNameEn");
		return redisUtil.hmget(project).get("MonthsData").toString();
	}

	/**
	* @version: V1.0
	* @author:  LHJ
	* @methodsName: getDaysData
	* @description: 从redis获取月数据
	* @param: JSONObject jsonObj
	* @return: String
	* @throws: 
	*/
	@RequestMapping(value = "/getDaysData", method = RequestMethod.POST)
	public String getDaysData(@RequestBody JSONObject jsonObj)throws Exception{
		String project = (String)((Map<?, ?>)jsonObj.get("project")).get("projectNameEn");
		return redisUtil.hmget(project).get("DaysData").toString();
	}

	/**
	* @version: V1.0
	* @author:  LHJ
	* @methodsName: getHoursData
	* @description: 从redis获取日数据
	* @param: JSONObject jsonObj
	* @return: String
	* @throws: 
	*/
	@RequestMapping(value = "/getHoursData", method = RequestMethod.POST)
	public String getHoursData(@RequestBody JSONObject jsonObj)throws Exception{
		String project = (String)((Map<?, ?>)jsonObj.get("project")).get("projectNameEn");
		return redisUtil.hmget(project).get("HoursData").toString();
	}

	/**
	* @version: V1.0
	* @author:  LHJ
	* @methodsName: getSummaryData
	* @description: 从redis获取概览数据
	* @param: JSONObject jsonObj
	* @return: String
	* @throws: 
	*/
	@RequestMapping(value = "/getSummaryData", method = RequestMethod.POST)
	public String getSummary(@RequestBody JSONObject jsonObj)throws Exception{
		String project = (String)((Map<?, ?>)jsonObj.get("project")).get("projectNameEn");
		return redisUtil.hmget(project).get("summary").toString();
	}
	
	
	/**
	* @version: V1.0
	* @author:  LHJ
	* @methodsName: getSummaryData
	* @description: 从TSDB首页主表格数据（已废弃）
	* @param: Long timestamp,String downsample,String porject,List<String> metrics 
	* @return: List<HomeCardVo>
	* @throws: 
	*/
    @SuppressWarnings("finally")
	public static List<HomeCardVo> getMainChartData(Long timestamp,String downsample,String porject,List<String> metrics )throws Exception{
		TSDBUtils tsdbUtils = new TSDBUtils();
		List<QueryResult> qs = tsdbUtils.getByTimeAndDownSample(timestamp,downsample,porject,metrics);
		Set<Entry<Long, Object>> entrys = qs.get(0).getDps().entrySet();
		Map<Long, Object> airDatas = new HashMap<Long,Object>(16);
		airDatas = qs.get(1).getDps();
		List<HomeCardVo> hcVoList = new ArrayList<>();
		DecimalFormat df = new DecimalFormat("#");
		DecimalFormat df2 = new DecimalFormat("#.0000");
		for(Entry<Long, Object> entry : entrys) {
			HomeCardVo hdVO = new HomeCardVo();
			Long key = entry.getKey();
			double ele = ((BigDecimal) entry.getValue()).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue(); // BigDecimal转小数点后两位Double 
			try {
				double air = ((BigDecimal) airDatas.get(key)).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
				hdVO.setTimestamp(key);
				hdVO.setElectricity(Double.valueOf(df.format(ele)));
				hdVO.setAir(Double.valueOf(df.format(air)));
				hdVO.setUnitCost(Double.valueOf(df2.format(ele/(air*60))));
				hcVoList.add(hdVO);
			} catch (Exception e) {
				throw e;
			}finally {
				continue;
			}
		}
		return hcVoList;
	}
	
}
