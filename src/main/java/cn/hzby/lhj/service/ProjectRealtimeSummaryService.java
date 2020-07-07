package cn.hzby.lhj.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.hzby.lhj.po.ProjectRealtimeSummaryKey;
import cn.hzby.lhj.po.ProjectRealtimeSummaryWithBLOBs;

/**
 * @author lhj
 */
@Service
public interface ProjectRealtimeSummaryService extends BaseService<ProjectRealtimeSummaryWithBLOBs, ProjectRealtimeSummaryKey> {

	/**
	 * 根据项目名称获取实时数据总和列表
	 * @param project
	 * @return
	 * @throws Exception
	 */
	List<ProjectRealtimeSummaryWithBLOBs> getByProject(String project) throws Exception;
	
}
