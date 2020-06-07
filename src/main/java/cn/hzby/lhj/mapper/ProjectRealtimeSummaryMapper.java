package cn.hzby.lhj.mapper;

import cn.hzby.lhj.po.ProjectRealtimeSummary;
import cn.hzby.lhj.po.ProjectRealtimeSummaryExample;
import cn.hzby.lhj.po.ProjectRealtimeSummaryKey;
import cn.hzby.lhj.po.ProjectRealtimeSummaryWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectRealtimeSummaryMapper {
    int countByExample(ProjectRealtimeSummaryExample example);

    int deleteByExample(ProjectRealtimeSummaryExample example);

    int deleteByPrimaryKey(ProjectRealtimeSummaryKey key);

    int insert(ProjectRealtimeSummaryWithBLOBs record);

    int insertSelective(ProjectRealtimeSummaryWithBLOBs record);

    List<ProjectRealtimeSummaryWithBLOBs> selectByExampleWithBLOBs(ProjectRealtimeSummaryExample example);

    List<ProjectRealtimeSummary> selectByExample(ProjectRealtimeSummaryExample example);

    ProjectRealtimeSummaryWithBLOBs selectByPrimaryKey(ProjectRealtimeSummaryKey key);

    int updateByExampleSelective(@Param("record") ProjectRealtimeSummaryWithBLOBs record, @Param("example") ProjectRealtimeSummaryExample example);

    int updateByExampleWithBLOBs(@Param("record") ProjectRealtimeSummaryWithBLOBs record, @Param("example") ProjectRealtimeSummaryExample example);

    int updateByExample(@Param("record") ProjectRealtimeSummary record, @Param("example") ProjectRealtimeSummaryExample example);

    int updateByPrimaryKeySelective(ProjectRealtimeSummaryWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ProjectRealtimeSummaryWithBLOBs record);

    int updateByPrimaryKey(ProjectRealtimeSummary record);
}