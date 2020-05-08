package cn.hzby.lhj.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.aliyun.hitsdb.client.TSDB;
import com.aliyun.hitsdb.client.TSDBClientFactory;
import com.aliyun.hitsdb.client.TSDBConfig;
import com.aliyun.hitsdb.client.value.request.Query;
import com.aliyun.hitsdb.client.value.request.SubQuery;
import com.aliyun.hitsdb.client.value.response.QueryResult;
import com.aliyun.hitsdb.client.value.type.Aggregator;

public class TSDBUtils {

	private static String address = "ts-uf69c6a82riq43l53.hitsdb.rds.aliyuncs.com";
	private static int port = 3242;
	
	public List<QueryResult> getData(Long startTime, Long endTime,String device, String downsample,List<String> metrics) throws IOException {  //  ,String machine
        // 创建 TSDB 对象
        TSDBConfig config = TSDBConfig.address(address, port).config();
        TSDB tsdb = TSDBClientFactory.connect(config);
        // 构造查询条件并查询数据。
        // long now = System.currentTimeMillis();
        // 查询一小时的数据
        Query query = new Query();
        System.out.println(downsample);
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
        System.out.println(query.toJSON());
        System.out.println(query.toString());
        /*Query query = Query.timeRange(endTime, startTime)
                .sub(SubQuery.metric("cumulative_flow_rate_higher")
                .aggregator(Aggregator.NONE).downsample(downsample)
                .tag("device","yuanyang_flowmeter_02")
                .build())
                .sub(SubQuery.metric("cumulative_flow_rate_lower")
                .aggregator(Aggregator.NONE).downsample(downsample)
                .tag("device","yuanyang_flowmeter_02")
                .build())
                .sub(SubQuery.metric("flowrate")
                .aggregator(Aggregator.NONE).downsample(downsample)
                .tag("device","yuanyang_flowmeter_02")
                .build())
                .build(); //.downsample("10m-avg")*/
        
        
        // 查询数据
        List<QueryResult> result = tsdb.query(query);
        // 打印输出
        // System.out.println(result);
        // 安全关闭客户端，以防数据丢失。
        tsdb.close();
        return result;
    }
	
	public List<QueryResult> test() throws IOException {  //  ,String machine
        // 创建 TSDB 对象
        TSDBConfig config = TSDBConfig.address(address, port).config();
        TSDB tsdb = TSDBClientFactory.connect(config);
        // 构造查询条件并查询数据。
        // long now = System.currentTimeMillis();
        // 查询一小时的数据
//        Query query = new Query();
//    	List<SubQuery> SubQuerys = new ArrayList<SubQuery>();
//        for(String metric: metrics) {
//        	SubQuerys.add(SubQuery.metric(metric)
//                    .aggregator(Aggregator.NONE).downsample(downsample)
//                    .tag("device",device)
//                    .build()); 
//        }
//        query = Query.timeRange(startTime, endTime)
//              .sub(SubQuerys)
//              .build();
        Query query = Query.timeRange(1588246772, 1588248772)
                .sub(SubQuery.metric("cumulative_flow_rate_higher")
                .aggregator(Aggregator.NONE).downsample("10m-avg")
                .tag("device","yuanyang_flowmeter_02")
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
