package cn.hzby.lhj.mapper.extend;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import cn.hzby.lhj.mapper.SummaryDayMapper;
import cn.hzby.lhj.po.SummaryDay;
public interface SummaryDayMapperExtend extends SummaryDayMapper {

	@Select("<script>select * from (select * from summary_day order by `timestamp` desc limit #{limit}) a order by timestamp</script>")
    List<SummaryDay> getNewestLimit(Integer limit);
}
