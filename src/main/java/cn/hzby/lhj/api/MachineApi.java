package cn.hzby.lhj.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.hzby.lhj.po.Machine;
import cn.hzby.lhj.service.MachineService;
import cn.hzby.lhj.vo.MachineWithAttributes;


/**
 * @author lhj
 * @version: V1.0
 * @className: MachineApi
 * @packageName: api
 * @description: 机器数据API
 * @data: 2020-05-13 11:20
 **/
@RequestMapping("/Machine")
@RestController
public class MachineApi {

	@Autowired
	private MachineService machineService;
	
	@RequestMapping("/listAll")
	public List<Machine> listAll() throws Exception{
		return machineService.listAll();
	}

	@RequestMapping("/listAllWithAttributes")
	public List<MachineWithAttributes> listAllWithAttributes() throws Exception{
		return machineService.listAllWithAttributes();
	}
}
