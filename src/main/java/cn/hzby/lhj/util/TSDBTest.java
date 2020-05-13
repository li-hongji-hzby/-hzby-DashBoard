package cn.hzby.lhj.util;
import java.io.IOException;
import java.util.List;
import com.aliyun.hitsdb.client.TSDB;
import com.aliyun.hitsdb.client.TSDBClientFactory;
import com.aliyun.hitsdb.client.TSDBConfig;
import com.aliyun.hitsdb.client.value.request.Query;
import com.aliyun.hitsdb.client.value.request.SubQuery;
import com.aliyun.hitsdb.client.value.response.QueryResult;
import com.aliyun.hitsdb.client.value.type.Aggregator;
public class TSDBTest {

	public static void main(String[] args) throws IOException {
        // 创建 TSDB 对象
        TSDBConfig config = TSDBConfig.address("ts-uf69c6a82riq43l53.hitsdb.rds.aliyuncs.com", 3242).config();
        TSDB tsdb = TSDBClientFactory.connect(config);
        // 构造查询条件并查询数据。
        long now = System.currentTimeMillis();
        // 查询一小时的数据
        Query query = Query.timeRange(now - 360000 * 1000, now)
                .sub(SubQuery.metric("output_pressure").aggregator(Aggregator.NONE).build()).build();
        // 查询数据
        List<QueryResult> result = tsdb.query(query);
        // 打印输出
        System.out.println(result);
        // 安全关闭客户端，以防数据丢失。
        tsdb.close();
    }
}