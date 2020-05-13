package cn.hzby.lhj.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.aliyun.hitsdb.client.TSDB;
import com.aliyun.hitsdb.client.TSDBClientFactory;
import com.aliyun.hitsdb.client.TSDBConfig;
import com.aliyun.hitsdb.client.value.request.LastPointQuery;
import com.aliyun.hitsdb.client.value.request.LastPointSubQuery;
import com.aliyun.hitsdb.client.value.request.Query;
import com.aliyun.hitsdb.client.value.request.SubQuery;
import com.aliyun.hitsdb.client.value.response.LastDataValue;
import com.aliyun.hitsdb.client.value.response.QueryResult;
import com.aliyun.hitsdb.client.value.type.Aggregator;

public class TSDBUtils {

	private static String address = "ts-uf69c6a82riq43l53.hitsdb.rds.aliyuncs.com";
	private static int port = 3242;
	
	/**
	* @author:  LHJ
	* @methodsName: getData
	* @description: 根据开始、结束时间批量获取数据
	* @param: Long startTime, Long endTime,String device, String downsample,List<String> metrics
	* @return: List<QueryResult>
	* @throws: 
	*/
	public List<QueryResult> getData(Long startTime, Long endTime,String device, String downsample,List<String> metrics) throws IOException {  //  ,String machine
        // 创建 TSDB 对象
        TSDBConfig config = TSDBConfig.address(address, port).config();
        TSDB tsdb = TSDBClientFactory.connect(config);
        // 构造查询条件并查询数据。
        // 查询一小时的数据
        Query query = new Query();
    	List<SubQuery> SubQuerys = new ArrayList<SubQuery>();
        for(String metric: metrics) {
        	SubQuerys.add(SubQuery.metric(metric)
                    .aggregator(Aggregator.NONE)
                    .downsample(downsample)
                    .tag("device",device)
                    .build()); 
        }
        query = Query.timeRange(startTime, endTime)
              .sub(SubQuerys)
              .build();
        // 查询数据
        List<QueryResult> result = tsdb.query(query);
        // 安全关闭客户端，以防数据丢失。
        tsdb.close();
        return result;
    }
	

	/**
	* @author:  LHJ
	* @methodsName: get5MinAvg
	* @description: 获取 5分钟/n小时 数据点
	* @param:  int hour,String metric
	* @return: List<QueryResult>
	* @throws: 
	*/
	public List<QueryResult> get5MinAvg(Integer hour,List<String> metrics) throws IOException {  //  ,String machine
        // 创建 TSDB 对象
        TSDBConfig config = TSDBConfig.address(address, port).config();
        TSDB tsdb = TSDBClientFactory.connect(config);
        // 构造查询条件并查询数据。
        long time = 60*60*1000; //一小时
        Query query =new Query();
    	List<SubQuery> SubQuerys = new ArrayList<SubQuery>();
        for(String metric: metrics) {
        	SubQuerys.add(SubQuery.metric(metric)
                    .aggregator(Aggregator.SUM)
                    .downsample("5m-avg")
                    .build()); 
        }
        query = Query.start(System.currentTimeMillis()- (hour*time))
	        .sub(SubQuerys)
	        .build();
	    // 查询数据
        List<QueryResult> result = tsdb.query(query);
        // 安全关闭客户端，以防数据丢失。
        tsdb.close();
        return result;
    }
	
	
	public List<QueryResult> getByTimeAndDownSample(Long timestamp,List<String> metrics,String downsample) throws IOException {
        // 创建 TSDB 对象
        TSDBConfig config = TSDBConfig.address(address, port).config();
        TSDB tsdb = TSDBClientFactory.connect(config);
    	List<SubQuery> SubQuerys = new ArrayList<SubQuery>();
        for(String metric: metrics) {
        	SubQuerys.add(SubQuery.metric(metric)
                    .aggregator(Aggregator.SUM)
                    .downsample(downsample + "-avg")
                    .build()); 
        }
        // 构造查询条件并查询数据。
        Query query = Query.start(timestamp)
                .sub(SubQuerys)
                .build(); //.downsample("10m-avg")
        // 查询数据
        List<QueryResult> result = tsdb.query(query);
        // 打印输出
        // System.out.println(result);
        // 安全关闭客户端，以防数据丢失。
        tsdb.close();
        return result;
	}
	
	public List<LastDataValue> getLastOne(Long timestamp,String metric) throws IOException {
        // 创建 TSDB 对象
        TSDBConfig config = TSDBConfig.address(address, port).config();
        TSDB tsdb = TSDBClientFactory.connect(config);
        LastPointQuery query = LastPointQuery.builder()
                // 指定时间戳
                .timestamp(timestamp)
                // 以指定时间戳向前推进几个小时，默认为0，即指定时间戳所在的小时时间;
                // -1 表示向前推进直到找到数据为止
                .backScan(-1)
                // 是否使用毫秒时间戳查询
                .msResolution(false)
                // 构建最新点子查询，用于查询指定时间线下的最新数据点，
                // 可以同时指定多个子查询
                .sub(LastPointSubQuery.builder(metric)
                        .build())
                .build();
        // 时间线最新点查询结果，每条时间线对应一个LastDataValue
        List<LastDataValue> lastDataValues = tsdb.queryLast(query);
        tsdb.close();
        return lastDataValues;
	}
	
	public List<QueryResult> test(int hour,String metric) throws IOException {  //  ,String machine
        // 创建 TSDB 对象
        TSDBConfig config = TSDBConfig.address(address, port).config();
        TSDB tsdb = TSDBClientFactory.connect(config);
        // 构造查询条件并查询数据。
        long time = 60*60*1000; //一小时
        Query query = Query.start(System.currentTimeMillis()- (hour*time))
                .sub(SubQuery.metric(metric)
                .aggregator(Aggregator.SUM).downsample("5m-avg")
                .build())
                .build(); //.downsample("10m-avg")
        
        
        // 查询数据
        List<QueryResult> result = tsdb.query(query);
        // 打印输出
        // System.out.println(result);
        // 安全关闭客户端，以防数据丢失。
        tsdb.close();
        return result;
    }
}
