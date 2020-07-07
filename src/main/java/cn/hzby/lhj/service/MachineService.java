package cn.hzby.lhj.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.hzby.lhj.po.Machine;
import cn.hzby.lhj.po.MachineKey;
import cn.hzby.lhj.vo.MachineWithAttributes;

/**
 * @author lhj
 */
@Service
public interface MachineService extends BaseService<Machine, MachineKey> {


	/**
	 * 查询所有机器属性
	 * @param
	 * @return List<MachineWithAttributes>
	 * @throws Exception
	 */
	List<MachineWithAttributes> listAllWithAttributes() throws Exception;
}
