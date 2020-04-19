package cn.hzby.lhj.mapper;

import cn.hzby.lhj.po.RealtimeAirCompressor;
import cn.hzby.lhj.po.RealtimeAirCompressorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RealtimeAirCompressorMapper {
    int countByExample(RealtimeAirCompressorExample example);

    int deleteByExample(RealtimeAirCompressorExample example);

    int deleteByPrimaryKey(String deviceName);

    int insert(RealtimeAirCompressor record);

    int insertSelective(RealtimeAirCompressor record);

    List<RealtimeAirCompressor> selectByExample(RealtimeAirCompressorExample example);

    RealtimeAirCompressor selectByPrimaryKey(String deviceName);

    int updateByExampleSelective(@Param("record") RealtimeAirCompressor record, @Param("example") RealtimeAirCompressorExample example);

    int updateByExample(@Param("record") RealtimeAirCompressor record, @Param("example") RealtimeAirCompressorExample example);

    int updateByPrimaryKeySelective(RealtimeAirCompressor record);

    int updateByPrimaryKey(RealtimeAirCompressor record);
}