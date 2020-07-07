package cn.hzby.lhj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hzby.lhj.mapper.ProjectMainHistoryMapper;
import cn.hzby.lhj.po.ProjectMainHistory;
import cn.hzby.lhj.po.ProjectMainHistoryKey;
import cn.hzby.lhj.service.ProjectMainHistoryService;

/**
 * @author lhj
 */
@Service
public class ProjectMainHistoryServiceImpl implements ProjectMainHistoryService {

	@Autowired
	private ProjectMainHistoryMapper projectMainHistoryMapper;
	
	@Override
	public List<ProjectMainHistory> listAll() throws Exception {
		return projectMainHistoryMapper.selectByExample(null);
	}

	@Override
	public ProjectMainHistory getById(ProjectMainHistoryKey id) throws Exception {
		return projectMainHistoryMapper.selectByPrimaryKey(id);
	}

	@Override
	public int save(ProjectMainHistory t) throws Exception {
		return projectMainHistoryMapper.insertSelective(t);
	}

	@Override
	public int removeById(ProjectMainHistoryKey id) throws Exception {
		return projectMainHistoryMapper.deleteByPrimaryKey(id);
	}

}
