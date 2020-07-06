package cn.hzby.lhj.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.hzby.lhj.po.MachineAttribute;

@Service
public interface MachineAttributeService extends BaseService<MachineAttribute, Integer> {

    /**
     * @version: V1.0
     * @author:  LHJ
     * @methodsName: listByIds
     * @description: 根据ID批量查询属性
     * @param: List<Integer> ids
     * @return: List<MachineAttribute>
     * @throws: Exception
     */
    List<MachineAttribute> listByIds(List<Integer> ids) throws Exception;
}
