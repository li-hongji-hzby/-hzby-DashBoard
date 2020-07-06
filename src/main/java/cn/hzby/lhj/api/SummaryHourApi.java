package cn.hzby.lhj.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.hzby.lhj.po.SummaryHour;
import cn.hzby.lhj.service.SummaryHourService;

/**
 * @author lhj
 */
@CrossOrigin
@RestController
@RequestMapping("/SummaryHour")
public class SummaryHourApi {
	
	@Autowired
	private SummaryHourService summaryHourService;
	
	@RequestMapping(value="/getNewestLimit")
	public List<SummaryHour> getNewestLimit(@RequestParam("limit") Integer limit) throws Exception{
		return summaryHourService.getNewestLimit(limit);
	}
}
