package cn.hzby.lhj.mapper;

import cn.hzby.lhj.po.ProjectMainSummary;
import cn.hzby.lhj.po.ProjectMainSummaryExample;
import cn.hzby.lhj.po.ProjectMainSummaryKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectMainSummaryMapper {
    int countByExample(ProjectMainSummaryExample example);

    int deleteByExample(ProjectMainSummaryExample example);

    int deleteByPrimaryKey(ProjectMainSummaryKey key);

    int insert(ProjectMainSummary record);

    int insertSelective(ProjectMainSummary record);

    List<ProjectMainSummary> selectByExampleWithBLOBs(ProjectMainSummaryExample example);

    List<ProjectMainSummary> selectByExample(ProjectMainSummaryExample example);

    ProjectMainSummary selectByPrimaryKey(ProjectMainSummaryKey key);

    int updateByExampleSelective(@Param("record") ProjectMainSummary record, @Param("example") ProjectMainSummaryExample example);

    int updateByExampleWithBLOBs(@Param("record") ProjectMainSummary record, @Param("example") ProjectMainSummaryExample example);

    int updateByExample(@Param("record") ProjectMainSummary record, @Param("example") ProjectMainSummaryExample example);

    int updateByPrimaryKeySelective(ProjectMainSummary record);

    int updateByPrimaryKeyWithBLOBs(ProjectMainSummary record);

    int updateByPrimaryKey(ProjectMainSummary record);
}