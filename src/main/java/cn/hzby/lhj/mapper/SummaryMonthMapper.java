package cn.hzby.lhj.mapper;

import cn.hzby.lhj.po.SummaryMonth;
import cn.hzby.lhj.po.SummaryMonthExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SummaryMonthMapper {
    int countByExample(SummaryMonthExample example);

    int deleteByExample(SummaryMonthExample example);

    int deleteByPrimaryKey(Integer timestamp);

    int insert(SummaryMonth record);

    int insertSelective(SummaryMonth record);

    List<SummaryMonth> selectByExample(SummaryMonthExample example);

    SummaryMonth selectByPrimaryKey(Integer timestamp);

    int updateByExampleSelective(@Param("record") SummaryMonth record, @Param("example") SummaryMonthExample example);

    int updateByExample(@Param("record") SummaryMonth record, @Param("example") SummaryMonthExample example);

    int updateByPrimaryKeySelective(SummaryMonth record);

    int updateByPrimaryKey(SummaryMonth record);
}