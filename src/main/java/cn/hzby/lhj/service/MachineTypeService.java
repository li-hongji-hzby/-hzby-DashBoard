package cn.hzby.lhj.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import cn.hzby.lhj.po.MachineType;

@Service
public interface MachineTypeService extends BaseService<MachineType, Integer> {
	
	// 根据属性列表获取机器属性
	public Map<String, Object> getAttributeList(Integer machineTypeId) throws Exception;
}
