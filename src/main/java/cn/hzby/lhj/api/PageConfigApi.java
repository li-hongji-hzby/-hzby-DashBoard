package cn.hzby.lhj.api;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.hzby.lhj.service.ProjectService;

/**
 * @author lhj
 * @description: 页面配置API
 **/
@RequestMapping("/PageConfig")
@RestController
@CrossOrigin
public class PageConfigApi {

	@Autowired
	private ProjectService projectService;
	
	@RequestMapping(value = "/getConfigByProject", method = RequestMethod.GET)
	public Map<String,Object> getConfigByProject(@RequestParam("project")String project) throws Exception{
		return projectService.getConfigByProject(project);
	}
}
