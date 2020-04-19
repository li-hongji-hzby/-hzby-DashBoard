package cn.hzby.lhj.mapper;

import cn.hzby.lhj.po.SummaryDay;
import cn.hzby.lhj.po.SummaryDayExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SummaryDayMapper {
    int countByExample(SummaryDayExample example);

    int deleteByExample(SummaryDayExample example);

    int deleteByPrimaryKey(Integer timestamp);

    int insert(SummaryDay record);

    int insertSelective(SummaryDay record);

    List<SummaryDay> selectByExample(SummaryDayExample example);

    SummaryDay selectByPrimaryKey(Integer timestamp);

    int updateByExampleSelective(@Param("record") SummaryDay record, @Param("example") SummaryDayExample example);

    int updateByExample(@Param("record") SummaryDay record, @Param("example") SummaryDayExample example);

    int updateByPrimaryKeySelective(SummaryDay record);

    int updateByPrimaryKey(SummaryDay record);
}