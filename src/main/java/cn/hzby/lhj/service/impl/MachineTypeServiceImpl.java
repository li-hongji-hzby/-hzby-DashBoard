package cn.hzby.lhj.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import cn.hzby.lhj.mapper.extend.MachineTypeMapperExtend;
import cn.hzby.lhj.po.MachineAttribute;
import cn.hzby.lhj.po.MachineType;
import cn.hzby.lhj.service.MachineAttributeService;
import cn.hzby.lhj.service.MachineTypeService;

@Service
public class MachineTypeServiceImpl implements MachineTypeService {

	@Autowired
	private MachineTypeMapperExtend machineTypeMapper; 
	
	@Autowired
	private MachineAttributeService machineAttributeService; 

    private final Logger log = LoggerFactory.getLogger(MachineTypeServiceImpl.class);
	
	@Override
	public List<MachineType> listAll() throws Exception {
		return machineTypeMapper.selectByExample(null);
	}

	@Override
	public MachineType getById(Integer id) throws Exception {
		return machineTypeMapper.selectByPrimaryKey(id);
	}

	@Override
	public int save(MachineType t) throws Exception {
		return machineTypeMapper.insertSelective(t);
	}

	@Override
	public int removeById(Integer id) throws Exception {
		return machineTypeMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Map<String, Object> getAttributeList(Integer machineTypeId) throws Exception {
		// 根据属性列表获取机器属性
		Map<String, Object> attributes = new HashMap<String, Object>(16);
		MachineType machineType = getById(machineTypeId);
		List<Integer> machineAttributeIds = JSON.parseArray(machineType.getAttributeList(), Integer.class);
		for(Integer id:machineAttributeIds) {
			MachineAttribute attribute = machineAttributeService.getById(id);
			if(attribute != null) {
				attributes.put(machineAttributeService.getById(id).getAttributeNameCn(), machineAttributeService.getById(id).getAttributeNameEn());
			}else {
				log.warn("查无此条机器属性");
			}
		}
		return attributes;
	}

}
