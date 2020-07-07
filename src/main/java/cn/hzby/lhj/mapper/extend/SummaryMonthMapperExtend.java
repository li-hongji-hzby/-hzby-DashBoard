package cn.hzby.lhj.mapper.extend;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import cn.hzby.lhj.mapper.SummaryMonthMapper;
import cn.hzby.lhj.po.SummaryMonth;

/**
 * @author lhj
 */
public interface SummaryMonthMapperExtend extends SummaryMonthMapper {

    /**
     * 获取最新n条数据并根据时间排序
     * @param limit
     * @return List<T>
     * @throws
     */
	@Select("<script>select * from (select * from summary_month order by `timestamp` desc limit #{limit}) a order by timestamp</script>")
    List<SummaryMonth> getNewestLimit(Integer limit);
}
