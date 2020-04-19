package cn.hzby.lhj.mapper;

import cn.hzby.lhj.po.RealtimeFlowMeter;
import cn.hzby.lhj.po.RealtimeFlowMeterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RealtimeFlowMeterMapper {
    int countByExample(RealtimeFlowMeterExample example);

    int deleteByExample(RealtimeFlowMeterExample example);

    int deleteByPrimaryKey(String deviceName);

    int insert(RealtimeFlowMeter record);

    int insertSelective(RealtimeFlowMeter record);

    List<RealtimeFlowMeter> selectByExample(RealtimeFlowMeterExample example);

    RealtimeFlowMeter selectByPrimaryKey(String deviceName);

    int updateByExampleSelective(@Param("record") RealtimeFlowMeter record, @Param("example") RealtimeFlowMeterExample example);

    int updateByExample(@Param("record") RealtimeFlowMeter record, @Param("example") RealtimeFlowMeterExample example);

    int updateByPrimaryKeySelective(RealtimeFlowMeter record);

    int updateByPrimaryKey(RealtimeFlowMeter record);
}