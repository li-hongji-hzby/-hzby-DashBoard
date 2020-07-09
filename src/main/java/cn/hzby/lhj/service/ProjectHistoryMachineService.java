package cn.hzby.lhj.service;

import java.util.List;

import cn.hzby.lhj.po.MachineAttribute;
import org.springframework.stereotype.Service;

import cn.hzby.lhj.po.ProjectHistoryMachine;
import cn.hzby.lhj.po.ProjectHistoryMachineKey;

/**
 * @author lhj
 */
@Service
public interface ProjectHistoryMachineService extends BaseService<ProjectHistoryMachine, ProjectHistoryMachineKey> {

    /**
     * 根据项目查询历史数据页机器
     * @param project
     * @return List<ProjectHistoryMachine>
     * @throws Exception
     */
    List<ProjectHistoryMachine> listByProjectIsshow(String project) throws Exception;

    /**
     * 根据机器查询属性列表
     * @param id
     * @return List<ProjectHistoryMachine>
     * @throws Exception
     */
    List<MachineAttribute> listAttributesByMachineAndProject(ProjectHistoryMachineKey id) throws Exception;
}
