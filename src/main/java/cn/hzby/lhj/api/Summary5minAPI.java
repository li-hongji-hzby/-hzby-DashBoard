package cn.hzby.lhj.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.hzby.lhj.po.Summary5min;
import cn.hzby.lhj.service.Summary5minService;

@CrossOrigin
@RestController
@RequestMapping("/Summary5min")
public class Summary5minAPI {
	
	@Autowired
	private Summary5minService summary5minService;
	
	@RequestMapping(value="/getNewestLimit")
	public List<Summary5min> getNewestLimit(@RequestParam("limit") Integer limit) throws Exception{
		return summary5minService.getNewestLimit(limit);
	}
	
}
