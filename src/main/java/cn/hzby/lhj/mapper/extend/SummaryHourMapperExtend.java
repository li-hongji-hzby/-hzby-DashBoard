package cn.hzby.lhj.mapper.extend;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import cn.hzby.lhj.mapper.SummaryHourMapper;
import cn.hzby.lhj.po.SummaryHour;

public interface SummaryHourMapperExtend extends SummaryHourMapper {

	@Select("<script>select * from (select * from summary_hour order by `timestamp` desc limit #{limit}) a order by timestamp</script>")
    List<SummaryHour> getNewestLimit(Integer limit);
}
