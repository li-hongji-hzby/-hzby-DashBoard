package cn.hzby.lhj.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import cn.hzby.lhj.service.impl.MachineTypeServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MachineTypeTest {

	@TestConfiguration
	static class MachineTypeServices{
		@Bean
		public MachineTypeService getMachineTypeServiceImpl() {
			return new MachineTypeServiceImpl();
		}
	}
	
	@Autowired
	@Qualifier("getMachineTypeServiceImpl")
	MachineTypeServiceImpl machineTypeServiceImpl;
	
	@Test
	public void getAttributeList() throws Exception{
		System.out.println(machineTypeServiceImpl.getAttributeList(1));
    }
	
}
