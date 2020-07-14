package cn.hzby.lhj.service;


import java.util.Map;

import org.springframework.stereotype.Service;

import cn.hzby.lhj.po.Project;

/**
 * @author lhj
 */
@Service
public interface ProjectService extends BaseService<Project, String> {

    /**
     * 根据用户查找对应项目
     * @param username
     * @return
     * @throws Exception
     */
    Project getDefaultProjectByUsername(String username) throws Exception;
	
    /**
     * 根据项目获取项目及页面配置
     * @param username
     * @return
     * @throws Exception
     */
    Map<String,Object> getDefaultProjectConfigByUser(String username) throws Exception;

	/**
	 * 根据用户获取项目
	 * @param username
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> listProjectByUser(String username) throws Exception;

	/**
	 * 根据用户获取所有项目
	 * @param username
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> getConfigByProject(String project) throws Exception;
}
