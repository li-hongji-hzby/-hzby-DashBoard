package cn.hzby.lhj.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.hzby.lhj.po.Machine;
import cn.hzby.lhj.po.MachineKey;
import cn.hzby.lhj.vo.MachineWithAttributes;

@Service
public interface MachineService extends BaseService<Machine, MachineKey> {


	List<MachineWithAttributes> listAllWithAttributes() throws Exception;
}
