package cn.hzby.lhj.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.hzby.lhj.po.MachineAttribute;

/**
 * @author lhj
 */
@Service
public interface MachineAttributeService extends BaseService<MachineAttribute, Integer> {
    
    /**
     * 根据ID批量查询属性
     * @param ids
     * @return List<MachineAttribute>
     * @throws Exception
     */
    List<MachineAttribute> listByIds(List<Integer> ids) throws Exception;
}
