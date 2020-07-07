package cn.hzby.lhj.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hzby.lhj.mapper.extend.MachineMapperExtend;
import cn.hzby.lhj.po.Machine;
import cn.hzby.lhj.po.MachineKey;
import cn.hzby.lhj.service.MachineService;
import cn.hzby.lhj.service.MachineTypeService;
import cn.hzby.lhj.vo.MachineWithAttributes;

/**
 * @author lhj
 */
@Service
public class MachineServiceImpl implements MachineService {

	@Autowired
	private MachineMapperExtend machineMapper;
	
	@Autowired
	private MachineTypeService machineTypeService;
	
	@Override
	public List<Machine> listAll() throws Exception {
		return machineMapper.selectByExample(null);
	}

	@Override
	public Machine getById(MachineKey id) throws Exception {
		return machineMapper.selectByPrimaryKey(id);
	}

	@Override
	public int save(Machine t) throws Exception {
		return machineMapper.insertSelective(t);
	}

	@Override
	public int removeById(MachineKey id) throws Exception {
		return machineMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<MachineWithAttributes> listAllWithAttributes() throws Exception {
		List<Machine> machineList=machineMapper.selectByExample(null);
		List<MachineWithAttributes> machineWithAttributesList = new ArrayList<>();
		for(Machine machine : machineList) {
			MachineWithAttributes machineWithAttributes = new MachineWithAttributes();
			BeanUtils.copyProperties(machine, machineWithAttributes);
			machineWithAttributes.setAttributeList(machineTypeService.getAttributeList(machine.getMachineType()));
			machineWithAttributesList.add(machineWithAttributes);
		}
		return machineWithAttributesList;
	}

}
