package cn.hzby.lhj.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.hzby.lhj.po.ProjectHistoryMachine;
import cn.hzby.lhj.po.ProjectHistoryMachineKey;

@Service
public interface ProjectHistoryMachineService extends BaseService<ProjectHistoryMachine, ProjectHistoryMachineKey> {

	// 根据项目查询历史数据页机器
    List<ProjectHistoryMachine> listByProjectIsshow(String project) throws Exception;
}
