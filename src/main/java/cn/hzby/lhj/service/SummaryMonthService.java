package cn.hzby.lhj.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.hzby.lhj.po.SummaryMonth;

@Service
public interface SummaryMonthService extends BaseService<SummaryMonth, Integer> {

	// 查询最新n条记录并按时间排序
	public List<SummaryMonth> getNewestLimit(Integer limit) throws Exception;
}
