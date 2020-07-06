package cn.hzby.lhj.mapper;

import cn.hzby.lhj.po.RealtimeOverview;
import cn.hzby.lhj.po.RealtimeOverviewExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RealtimeOverviewMapper {
    int countByExample(RealtimeOverviewExample example);

    int deleteByExample(RealtimeOverviewExample example);

    int deleteByPrimaryKey(String property);

    int insert(RealtimeOverview record);

    int insertSelective(RealtimeOverview record);

    List<RealtimeOverview> selectByExample(RealtimeOverviewExample example);

    RealtimeOverview selectByPrimaryKey(String property);

    int updateByExampleSelective(@Param("record") RealtimeOverview record, @Param("example") RealtimeOverviewExample example);

    int updateByExample(@Param("record") RealtimeOverview record, @Param("example") RealtimeOverviewExample example);

    int updateByPrimaryKeySelective(RealtimeOverview record);

    int updateByPrimaryKey(RealtimeOverview record);
}