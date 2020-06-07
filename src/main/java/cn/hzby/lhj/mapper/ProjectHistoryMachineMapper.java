package cn.hzby.lhj.mapper;

import cn.hzby.lhj.po.ProjectHistoryMachine;
import cn.hzby.lhj.po.ProjectHistoryMachineExample;
import cn.hzby.lhj.po.ProjectHistoryMachineKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectHistoryMachineMapper {
    int countByExample(ProjectHistoryMachineExample example);

    int deleteByExample(ProjectHistoryMachineExample example);

    int deleteByPrimaryKey(ProjectHistoryMachineKey key);

    int insert(ProjectHistoryMachine record);

    int insertSelective(ProjectHistoryMachine record);

    List<ProjectHistoryMachine> selectByExampleWithBLOBs(ProjectHistoryMachineExample example);

    List<ProjectHistoryMachine> selectByExample(ProjectHistoryMachineExample example);

    ProjectHistoryMachine selectByPrimaryKey(ProjectHistoryMachineKey key);

    int updateByExampleSelective(@Param("record") ProjectHistoryMachine record, @Param("example") ProjectHistoryMachineExample example);

    int updateByExampleWithBLOBs(@Param("record") ProjectHistoryMachine record, @Param("example") ProjectHistoryMachineExample example);

    int updateByExample(@Param("record") ProjectHistoryMachine record, @Param("example") ProjectHistoryMachineExample example);

    int updateByPrimaryKeySelective(ProjectHistoryMachine record);

    int updateByPrimaryKeyWithBLOBs(ProjectHistoryMachine record);

    int updateByPrimaryKey(ProjectHistoryMachine record);
}