package cn.hzby.lhj.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.hzby.lhj.po.SummaryDay;
import cn.hzby.lhj.service.SummaryDayService;

@CrossOrigin
@RestController
@RequestMapping("/SummaryDay")
public class SummaryDayAPI {

	@Autowired
	private SummaryDayService summaryDayService;
	
	@RequestMapping(value="/getNewestLimit")
	public List<SummaryDay> getNewestLimit(@RequestParam("limit") Integer limit) throws Exception{
		return summaryDayService.getNewestLimit(limit);
	}
}
