package cn.hzby.lhj.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import cn.hzby.lhj.mapper.extend.ProjectRealtimeMachineMapperExtend;
import cn.hzby.lhj.po.ProjectRealtimeMachine;
import cn.hzby.lhj.po.ProjectRealtimeMachineExample;
import cn.hzby.lhj.po.ProjectRealtimeMachineKey;
import cn.hzby.lhj.service.MachineAttributeService;
import cn.hzby.lhj.service.ProjectRealtimeMachineService;

@Service
public class ProjectRealtimeMachineServiceImpl implements ProjectRealtimeMachineService {

	@Autowired
	private ProjectRealtimeMachineMapperExtend projectRealtimeMachineMapper;
	
	@Autowired
	private MachineAttributeService machineAttributeService;
	
	@Override
	public List<ProjectRealtimeMachine> listAll() throws Exception {
		return projectRealtimeMachineMapper.selectByExampleWithBLOBs(null);
	}

	@Override
	public ProjectRealtimeMachine getById(ProjectRealtimeMachineKey id) throws Exception {
		return projectRealtimeMachineMapper.selectByPrimaryKey(id);
	}

	@Override
	public int save(ProjectRealtimeMachine t) throws Exception {
		return projectRealtimeMachineMapper.insertSelective(t);
	}

	@Override
	public int removeById(ProjectRealtimeMachineKey id) throws Exception {
		return projectRealtimeMachineMapper.deleteByPrimaryKey(id);
	}

	// 根据项目查询实时数据页机器
	@Override
	public Map<String, List<ProjectRealtimeMachine>> listByProjectIsshow(String project) throws Exception {
		ProjectRealtimeMachineKey key = new ProjectRealtimeMachineKey();
		key.setProjectNameEn(project);
		ProjectRealtimeMachineExample example = new ProjectRealtimeMachineExample();
		ProjectRealtimeMachineExample.Criteria criteria = example.createCriteria();
		criteria.andProjectNameEnEqualTo(project);
		criteria.andIsShowEqualTo(1);
		List<ProjectRealtimeMachine> machineList = projectRealtimeMachineMapper.selectByExampleWithBLOBs(example);
		machineList.stream().forEach(e -> {
			try {
				e.setAttributeList(JSON.toJSONString(machineAttributeService.listByIds(JSON.parseArray(e.getAttributeList(), Integer.class))));
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		return machineList.stream().collect(Collectors.groupingBy(ProjectRealtimeMachine::getMachineTypeName));
	}


}
