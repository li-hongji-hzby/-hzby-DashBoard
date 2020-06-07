package cn.hzby.lhj.mapper;

import cn.hzby.lhj.po.ProjectRealtimeMachine;
import cn.hzby.lhj.po.ProjectRealtimeMachineExample;
import cn.hzby.lhj.po.ProjectRealtimeMachineKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectRealtimeMachineMapper {
    int countByExample(ProjectRealtimeMachineExample example);

    int deleteByExample(ProjectRealtimeMachineExample example);

    int deleteByPrimaryKey(ProjectRealtimeMachineKey key);

    int insert(ProjectRealtimeMachine record);

    int insertSelective(ProjectRealtimeMachine record);

    List<ProjectRealtimeMachine> selectByExampleWithBLOBs(ProjectRealtimeMachineExample example);

    List<ProjectRealtimeMachine> selectByExample(ProjectRealtimeMachineExample example);

    ProjectRealtimeMachine selectByPrimaryKey(ProjectRealtimeMachineKey key);

    int updateByExampleSelective(@Param("record") ProjectRealtimeMachine record, @Param("example") ProjectRealtimeMachineExample example);

    int updateByExampleWithBLOBs(@Param("record") ProjectRealtimeMachine record, @Param("example") ProjectRealtimeMachineExample example);

    int updateByExample(@Param("record") ProjectRealtimeMachine record, @Param("example") ProjectRealtimeMachineExample example);

    int updateByPrimaryKeySelective(ProjectRealtimeMachine record);

    int updateByPrimaryKeyWithBLOBs(ProjectRealtimeMachine record);

    int updateByPrimaryKey(ProjectRealtimeMachine record);
}