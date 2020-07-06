package cn.hzby.lhj.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import cn.hzby.lhj.po.SummaryDay;

@Service
public interface SummaryDayService extends BaseService<SummaryDay, Integer> {

	List<SummaryDay> getNewestLimit(@RequestParam("limit") Integer limit) throws Exception;
}
