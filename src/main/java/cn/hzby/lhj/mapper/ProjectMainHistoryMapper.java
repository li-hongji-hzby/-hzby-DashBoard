package cn.hzby.lhj.mapper;

import cn.hzby.lhj.po.ProjectMainHistory;
import cn.hzby.lhj.po.ProjectMainHistoryExample;
import cn.hzby.lhj.po.ProjectMainHistoryKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectMainHistoryMapper {
    int countByExample(ProjectMainHistoryExample example);

    int deleteByExample(ProjectMainHistoryExample example);

    int deleteByPrimaryKey(ProjectMainHistoryKey key);

    int insert(ProjectMainHistory record);

    int insertSelective(ProjectMainHistory record);

    List<ProjectMainHistory> selectByExample(ProjectMainHistoryExample example);

    ProjectMainHistory selectByPrimaryKey(ProjectMainHistoryKey key);

    int updateByExampleSelective(@Param("record") ProjectMainHistory record, @Param("example") ProjectMainHistoryExample example);

    int updateByExample(@Param("record") ProjectMainHistory record, @Param("example") ProjectMainHistoryExample example);

    int updateByPrimaryKeySelective(ProjectMainHistory record);

    int updateByPrimaryKey(ProjectMainHistory record);
}