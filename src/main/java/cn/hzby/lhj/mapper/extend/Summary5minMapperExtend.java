package cn.hzby.lhj.mapper.extend;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import cn.hzby.lhj.mapper.Summary5minMapper;
import cn.hzby.lhj.po.Summary5min;

public interface Summary5minMapperExtend extends Summary5minMapper {

	@Select("<script>select * from (select * from summary_5min order by `timestamp` desc limit #{limit}) a order by timestamp</script>")
    List<Summary5min> getNewestLimit(Integer limit);
}
