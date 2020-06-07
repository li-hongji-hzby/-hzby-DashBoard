package cn.hzby.lhj.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import cn.hzby.lhj.po.ProjectRealtimeMachine;
import cn.hzby.lhj.po.ProjectRealtimeMachineKey;

@Service
public interface ProjectRealtimeMachineService extends BaseService<ProjectRealtimeMachine, ProjectRealtimeMachineKey> {

	// 根据项目查询实时数据页机器
	public Map<String, List<ProjectRealtimeMachine>> listByProjectIsshow(String project) throws Exception;
	
	
}
