package cn.hzby.lhj.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.hzby.lhj.po.SummaryMonth;
import cn.hzby.lhj.service.SummaryMonthService;

@CrossOrigin
@RestController
@RequestMapping("/SummaryMonth")
/**
 * @author lhj
 */
public class SummaryMonthAPI {

	@Autowired
	private SummaryMonthService summaryMonthService;
	
	@RequestMapping(value="/getNewestLimit")
	public List<SummaryMonth> getNewestLimit(@RequestParam("limit") Integer limit) throws Exception{
		return summaryMonthService.getNewestLimit(limit);
	}
}
