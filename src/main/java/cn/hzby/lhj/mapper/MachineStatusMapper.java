package cn.hzby.lhj.mapper;

import cn.hzby.lhj.po.MachineStatus;
import cn.hzby.lhj.po.MachineStatusExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MachineStatusMapper {
    int countByExample(MachineStatusExample example);

    int deleteByExample(MachineStatusExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MachineStatus record);

    int insertSelective(MachineStatus record);

    List<MachineStatus> selectByExample(MachineStatusExample example);

    MachineStatus selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MachineStatus record, @Param("example") MachineStatusExample example);

    int updateByExample(@Param("record") MachineStatus record, @Param("example") MachineStatusExample example);

    int updateByPrimaryKeySelective(MachineStatus record);

    int updateByPrimaryKey(MachineStatus record);
}