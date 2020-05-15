package cn.hzby.lhj.mapper;

import cn.hzby.lhj.po.LogMsg;
import cn.hzby.lhj.po.LogMsgExample;
import cn.hzby.lhj.po.LogMsgWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LogMsgMapper {
    int countByExample(LogMsgExample example);

    int deleteByExample(LogMsgExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LogMsgWithBLOBs record);

    int insertSelective(LogMsgWithBLOBs record);

    List<LogMsgWithBLOBs> selectByExampleWithBLOBs(LogMsgExample example);

    List<LogMsg> selectByExample(LogMsgExample example);

    LogMsgWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LogMsgWithBLOBs record, @Param("example") LogMsgExample example);

    int updateByExampleWithBLOBs(@Param("record") LogMsgWithBLOBs record, @Param("example") LogMsgExample example);

    int updateByExample(@Param("record") LogMsg record, @Param("example") LogMsgExample example);

    int updateByPrimaryKeySelective(LogMsgWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(LogMsgWithBLOBs record);

    int updateByPrimaryKey(LogMsg record);
}