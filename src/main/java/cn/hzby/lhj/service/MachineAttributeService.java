package cn.hzby.lhj.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.hzby.lhj.po.MachineAttribute;

@Service
public interface MachineAttributeService extends BaseService<MachineAttribute, Integer> {

	// 根据ID批量查询属性
    List<MachineAttribute> listByIds(List<Integer> ids) throws Exception;
}
