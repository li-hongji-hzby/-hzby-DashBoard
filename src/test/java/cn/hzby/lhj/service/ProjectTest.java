package cn.hzby.lhj.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import cn.hzby.lhj.service.impl.ProjectServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectTest {

	@TestConfiguration
	static class ProjectServices{
		@Bean
		public ProjectServiceImpl getProjectServiceImpl() {
			return new cn.hzby.lhj.service.impl.ProjectServiceImpl();
		}
	}
	
	@Autowired
	@Qualifier("getProjectServiceImpl")
	ProjectServiceImpl ProjectServiceImpl;
	
	@Test
	public void getProjectList() throws Exception{
		System.out.println(ProjectServiceImpl.listAll());
	}
	
}