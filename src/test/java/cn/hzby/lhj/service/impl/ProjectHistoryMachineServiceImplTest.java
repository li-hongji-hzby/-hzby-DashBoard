package cn.hzby.lhj.service.impl;

import cn.hzby.lhj.DashBoardServerApplication;
import cn.hzby.lhj.po.MachineAttribute;
import cn.hzby.lhj.po.ProjectHistoryMachineKey;
import cn.hzby.lhj.service.ProjectHistoryMachineService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {DashBoardServerApplication.class})
class ProjectHistoryMachineServiceImplTest {

    @Autowired
    private ProjectHistoryMachineService projectHistoryMachineService;

    @Test
    void listAttributesByMachineAndProject() throws Exception{

        ProjectHistoryMachineKey id = new ProjectHistoryMachineKey();
        id.setMachineNameEn("air_compressor_1:ZJG");
        id.setProjectNameEn("张家港");
        List<MachineAttribute> attrs = projectHistoryMachineService.listAttributesByMachineAndProject(id);
        System.out.println(attrs.size());
        for (MachineAttribute attr: attrs){
            System.out.println(attr.getId());
        }
    }
}