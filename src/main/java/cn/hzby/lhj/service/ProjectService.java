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
    Project getByUsername(String username) throws Exception;
	
    /**
     * 根据项目获取项目及页面配置
     * @param username
     * @return
     * @throws Exception
     */
    Map<String,Object> getProjectConfigByUser(String username) throws Exception;
}
