package cn.hzby.lhj.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSON;
import cn.hzby.lhj.mapper.extend.ProjectHistoryMachineMapperExtend;
import cn.hzby.lhj.po.ProjectHistoryMachine;
import cn.hzby.lhj.po.ProjectHistoryMachineExample;
import cn.hzby.lhj.po.ProjectHistoryMachineKey;
import cn.hzby.lhj.po.ProjectRealtimeMachineKey;
import cn.hzby.lhj.service.MachineAttributeService;
import cn.hzby.lhj.service.ProjectHistoryMachineService;

/**
 * @author lhj
 */
@Service
public class ProjectHistoryMachineServiceImpl implements ProjectHistoryMachineService {

	@Autowired
	private ProjectHistoryMachineMapperExtend projectHistoryMachineMapper;

	@Autowired
	private MachineAttributeService machineAttributeService;
	
	@Override
	public List<ProjectHistoryMachine> listAll() throws Exception {
		return projectHistoryMachineMapper.selectByExample(null);
	}

	@Override
	public ProjectHistoryMachine getById(ProjectHistoryMachineKey id) throws Exception {
		return projectHistoryMachineMapper.selectByPrimaryKey(id);
	}

	@Override
	public int save(ProjectHistoryMachine t) throws Exception {
		return projectHistoryMachineMapper.insertSelective(t);
	}

	@Override
	public int removeById(ProjectHistoryMachineKey id) throws Exception {
		return projectHistoryMachineMapper.deleteByPrimaryKey(id);
	}

	/**
	 * 根据项目查询历史数据页机器
	 * @param project
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<ProjectHistoryMachine> listByProjectIsshow(String project) throws Exception {
		ProjectRealtimeMachineKey key = new ProjectRealtimeMachineKey();
		key.setProjectNameEn(project);
		ProjectHistoryMachineExample example = new ProjectHistoryMachineExample();
		ProjectHistoryMachineExample.Criteria criteria = example.createCriteria();
		criteria.andProjectNameEnEqualTo(project);
		criteria.andIsShowEqualTo(1);
		List<ProjectHistoryMachine> machineList = projectHistoryMachineMapper.selectByExampleWithBLOBs(example);
		machineList.stream().forEach(e -> {
			try {
				e.setAttributeList(JSON.toJSONString(machineAttributeService.listByIds(JSON.parseArray(e.getAttributeList(), Integer.class))));
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		return machineList;
	}
}
