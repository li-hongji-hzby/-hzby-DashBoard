package cn.hzby.lhj.mapper;

import cn.hzby.lhj.po.SummaryHour;
import cn.hzby.lhj.po.SummaryHourExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SummaryHourMapper {
    int countByExample(SummaryHourExample example);

    int deleteByExample(SummaryHourExample example);

    int deleteByPrimaryKey(Integer timestamp);

    int insert(SummaryHour record);

    int insertSelective(SummaryHour record);

    List<SummaryHour> selectByExample(SummaryHourExample example);

    SummaryHour selectByPrimaryKey(Integer timestamp);

    int updateByExampleSelective(@Param("record") SummaryHour record, @Param("example") SummaryHourExample example);

    int updateByExample(@Param("record") SummaryHour record, @Param("example") SummaryHourExample example);

    int updateByPrimaryKeySelective(SummaryHour record);

    int updateByPrimaryKey(SummaryHour record);
}