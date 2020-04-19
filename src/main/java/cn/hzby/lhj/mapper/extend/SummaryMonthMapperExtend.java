package cn.hzby.lhj.mapper.extend;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import cn.hzby.lhj.mapper.SummaryMonthMapper;
import cn.hzby.lhj.po.SummaryMonth;

public interface SummaryMonthMapperExtend extends SummaryMonthMapper {

	@Select("<script>select * from (select * from summary_month order by `timestamp` desc limit #{limit}) a order by timestamp</script>")    
	public List<SummaryMonth> getNewestLimit(Integer limit); 
}
