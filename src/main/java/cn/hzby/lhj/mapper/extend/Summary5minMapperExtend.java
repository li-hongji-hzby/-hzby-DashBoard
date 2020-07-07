package cn.hzby.lhj.mapper.extend;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import cn.hzby.lhj.mapper.Summary5minMapper;
import cn.hzby.lhj.po.Summary5min;

/**
 * @author lhj
 */
public interface Summary5minMapperExtend extends Summary5minMapper {

    /**
     * 获取最新n条数据并根据时间排序
     * @param limit
     * @return List<T>
     * @throws
     */
	@Select("<script>select * from (select * from summary_5min order by `timestamp` desc limit #{limit}) a order by timestamp</script>")
    List<Summary5min> getNewestLimit(Integer limit);
}
