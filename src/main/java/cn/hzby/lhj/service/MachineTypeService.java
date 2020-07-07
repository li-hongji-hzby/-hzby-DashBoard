package cn.hzby.lhj.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import cn.hzby.lhj.po.MachineType;

/**
 * @author lhj
 */
@Service
public interface MachineTypeService extends BaseService<MachineType, Integer> {

    /**
     * 根据属性列表获取机器属性
     * @param machineTypeId
     * @return Map<String, Object>
     * @throws Exception
     */
    Map<String, Object> getAttributeList(Integer machineTypeId) throws Exception;
}
