package cn.hzby.lhj.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.hzby.lhj.po.ProjectRealtimeSummaryKey;
import cn.hzby.lhj.po.ProjectRealtimeSummaryWithBLOBs;

@Service
public interface ProjectRealtimeSummaryService extends BaseService<ProjectRealtimeSummaryWithBLOBs, ProjectRealtimeSummaryKey> {

	List<ProjectRealtimeSummaryWithBLOBs> getByProject(String project) throws Exception;
	
}
