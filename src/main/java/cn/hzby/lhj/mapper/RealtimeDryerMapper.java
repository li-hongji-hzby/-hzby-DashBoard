package cn.hzby.lhj.mapper;

import cn.hzby.lhj.po.RealtimeDryer;
import cn.hzby.lhj.po.RealtimeDryerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RealtimeDryerMapper {
    int countByExample(RealtimeDryerExample example);

    int deleteByExample(RealtimeDryerExample example);

    int deleteByPrimaryKey(String deviceName);

    int insert(RealtimeDryer record);

    int insertSelective(RealtimeDryer record);

    List<RealtimeDryer> selectByExample(RealtimeDryerExample example);

    RealtimeDryer selectByPrimaryKey(String deviceName);

    int updateByExampleSelective(@Param("record") RealtimeDryer record, @Param("example") RealtimeDryerExample example);

    int updateByExample(@Param("record") RealtimeDryer record, @Param("example") RealtimeDryerExample example);

    int updateByPrimaryKeySelective(RealtimeDryer record);

    int updateByPrimaryKey(RealtimeDryer record);
}