package cn.hzby.lhj.mapper;

import cn.hzby.lhj.po.MachineType;
import cn.hzby.lhj.po.MachineTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MachineTypeMapper {
    int countByExample(MachineTypeExample example);

    int deleteByExample(MachineTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MachineType record);

    int insertSelective(MachineType record);

    List<MachineType> selectByExample(MachineTypeExample example);

    MachineType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MachineType record, @Param("example") MachineTypeExample example);

    int updateByExample(@Param("record") MachineType record, @Param("example") MachineTypeExample example);

    int updateByPrimaryKeySelective(MachineType record);

    int updateByPrimaryKey(MachineType record);
}