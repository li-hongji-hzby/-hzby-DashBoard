package cn.hzby.lhj.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import cn.hzby.lhj.po.SummaryDay;

/**
 * @author lhj
 */
@Service
public interface SummaryDayService extends BaseService<SummaryDay, Integer> {

	/**
	 * 获取最新的数据根据传入条数
	 * @param limit
	 * @return
	 * @throws Exception
	 */
	List<SummaryDay> getNewestLimit(@RequestParam("limit") Integer limit) throws Exception;
}
