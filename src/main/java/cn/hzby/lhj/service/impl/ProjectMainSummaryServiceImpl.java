package cn.hzby.lhj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hzby.lhj.mapper.ProjectMainSummaryMapper;
import cn.hzby.lhj.po.ProjectMainSummary;
import cn.hzby.lhj.po.ProjectMainSummaryKey;
import cn.hzby.lhj.service.ProjectMainSummaryService;

@Service
public class ProjectMainSummaryServiceImpl implements ProjectMainSummaryService {

	@Autowired
	private ProjectMainSummaryMapper projectMainSummaryMapper;
	
	@Override
	public List<ProjectMainSummary> listAll() throws Exception {
		return projectMainSummaryMapper.selectByExampleWithBLOBs(null);
	}

	@Override
	public ProjectMainSummary getById(ProjectMainSummaryKey id) throws Exception {
		return projectMainSummaryMapper.selectByPrimaryKey(id);
	}

	@Override
	public int save(ProjectMainSummary t) throws Exception {
		return projectMainSummaryMapper.insertSelective(t);
	}

	@Override
	public int removeById(ProjectMainSummaryKey id) throws Exception {
		return projectMainSummaryMapper.deleteByPrimaryKey(id);
	}

}
