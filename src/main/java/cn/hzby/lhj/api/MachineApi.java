package cn.hzby.lhj.api;

import java.util.List;
import java.util.Map;
import java.util.jar.Attributes;
import java.util.stream.Collectors;

import cn.hzby.lhj.po.MachineAttribute;
import cn.hzby.lhj.po.ProjectHistoryMachineKey;
import cn.hzby.lhj.service.ProjectHistoryMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.hzby.lhj.po.Machine;
import cn.hzby.lhj.service.MachineService;
import cn.hzby.lhj.vo.MachineWithAttributes;

import javax.servlet.http.HttpServletResponse;


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

	@Autowired
	private ProjectHistoryMachineService projectHistoryMachineService;
	
	@RequestMapping("/listAll")
	public List<Machine> listAll() throws Exception{
		return machineService.listAll();
	}

	@RequestMapping("/listAllWithAttributes")
	public List<MachineWithAttributes> listAllWithAttributes() throws Exception{
		return machineService.listAllWithAttributes();
	}

	@RequestMapping(value = "/mapAttributesByMachineAndProject", method = RequestMethod.GET)
	public Map<String, String> mapAttributesByMachineAndProject (@RequestParam("project") String project, @RequestParam("machine") String machine, HttpServletResponse response) throws Exception{
		ProjectHistoryMachineKey id = new ProjectHistoryMachineKey();
		id.setProjectNameEn(project);
		id.setMachineNameEn(machine);
		List<MachineAttribute> attributeList = projectHistoryMachineService.listAttributesByMachineAndProject(id);
		return attributeList.stream().collect(Collectors.toMap(MachineAttribute::getAttributeNameCn, MachineAttribute::getAttributeNameEn));
	}
}
