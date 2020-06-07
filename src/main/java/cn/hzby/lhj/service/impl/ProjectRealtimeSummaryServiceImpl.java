package cn.hzby.lhj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hzby.lhj.mapper.extend.ProjectRealtimeSummaryMapperExtend;
import cn.hzby.lhj.po.ProjectRealtimeSummaryExample;
import cn.hzby.lhj.po.ProjectRealtimeSummaryKey;
import cn.hzby.lhj.po.ProjectRealtimeSummaryWithBLOBs;
import cn.hzby.lhj.service.ProjectRealtimeSummaryService;

@Service
public class ProjectRealtimeSummaryServiceImpl implements ProjectRealtimeSummaryService {

	@Autowired
	private ProjectRealtimeSummaryMapperExtend projectRealtimeSummaryMapper;
	
	@Override
	public List<ProjectRealtimeSummaryWithBLOBs> listAll() throws Exception {
		return projectRealtimeSummaryMapper.selectByExampleWithBLOBs(null);
	}

	@Override
	public ProjectRealtimeSummaryWithBLOBs getById(ProjectRealtimeSummaryKey id) throws Exception {
		return projectRealtimeSummaryMapper.selectByPrimaryKey(id);
	}

	@Override
	public int save(ProjectRealtimeSummaryWithBLOBs t) throws Exception {
		return projectRealtimeSummaryMapper.insertSelective(t);
	}

	@Override
	public int removeById(ProjectRealtimeSummaryKey id) throws Exception {
		return projectRealtimeSummaryMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<ProjectRealtimeSummaryWithBLOBs> getByProject(String project) throws Exception{
		ProjectRealtimeSummaryExample example = new ProjectRealtimeSummaryExample();
		ProjectRealtimeSummaryExample.Criteria criteria = example.createCriteria();
		criteria.andProjectNameEnEqualTo(project);
		return projectRealtimeSummaryMapper.selectByExampleWithBLOBs(example);
	}
}
