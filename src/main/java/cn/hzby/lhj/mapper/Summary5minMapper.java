package cn.hzby.lhj.mapper;

import cn.hzby.lhj.po.Summary5min;
import cn.hzby.lhj.po.Summary5minExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Summary5minMapper {
    int countByExample(Summary5minExample example);

    int deleteByExample(Summary5minExample example);

    int deleteByPrimaryKey(Integer timestamp);

    int insert(Summary5min record);

    int insertSelective(Summary5min record);

    List<Summary5min> selectByExample(Summary5minExample example);

    Summary5min selectByPrimaryKey(Integer timestamp);

    int updateByExampleSelective(@Param("record") Summary5min record, @Param("example") Summary5minExample example);

    int updateByExample(@Param("record") Summary5min record, @Param("example") Summary5minExample example);

    int updateByPrimaryKeySelective(Summary5min record);

    int updateByPrimaryKey(Summary5min record);
}