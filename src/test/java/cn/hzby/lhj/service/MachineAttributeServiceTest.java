package cn.hzby.lhj.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import cn.hzby.lhj.service.impl.MachineAttributeServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MachineAttributeServiceTest {
	
    @TestConfiguration
    static class MachineAttributeServices{
        @Bean
        public MachineAttributeService getMachineAttributeServiceImpl() {
            return new MachineAttributeServiceImpl();
        }

    }
    
	@Autowired
	@Qualifier("getMachineAttributeServiceImpl")
	MachineAttributeServiceImpl machineAttributeServiceImpl;
 
    @Test
	public void getById() throws Exception{
    	System.out.println(machineAttributeServiceImpl.getById(123).getAttributeNameCn());
	}
 
 
}