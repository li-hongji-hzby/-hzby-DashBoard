package cn.hzby.lhj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hzby.lhj.mapper.extend.MachineStatusMapperExtend;
import cn.hzby.lhj.po.MachineStatus;
import cn.hzby.lhj.service.MachineStatusService;

@Service
public class MachineStatusServiceImpl implements MachineStatusService {

	@Autowired
	private MachineStatusMapperExtend machineStatusMapper;
	
	@Override
	public List<MachineStatus> listAll() throws Exception {
		return machineStatusMapper.selectByExample(null);
	}

	@Override
	public MachineStatus getById(Integer id) throws Exception {
		return machineStatusMapper.selectByPrimaryKey(id);
	}

	@Override
	public int save(MachineStatus t) throws Exception {
		return machineStatusMapper.insertSelective(t);
	}

	@Override
	public int removeById(Integer id) throws Exception {
		return machineStatusMapper.deleteByPrimaryKey(id);
	}

}
