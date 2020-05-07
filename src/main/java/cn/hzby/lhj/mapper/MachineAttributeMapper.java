package cn.hzby.lhj.mapper;

import cn.hzby.lhj.po.MachineAttribute;
import cn.hzby.lhj.po.MachineAttributeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MachineAttributeMapper {
    int countByExample(MachineAttributeExample example);

    int deleteByExample(MachineAttributeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MachineAttribute record);

    int insertSelective(MachineAttribute record);

    List<MachineAttribute> selectByExample(MachineAttributeExample example);

    MachineAttribute selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MachineAttribute record, @Param("example") MachineAttributeExample example);

    int updateByExample(@Param("record") MachineAttribute record, @Param("example") MachineAttributeExample example);

    int updateByPrimaryKeySelective(MachineAttribute record);

    int updateByPrimaryKey(MachineAttribute record);
}