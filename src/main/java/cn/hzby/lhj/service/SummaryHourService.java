package cn.hzby.lhj.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.hzby.lhj.po.SummaryHour;

@Service
public interface SummaryHourService extends BaseService<SummaryHour, Integer> {
	
	// 查询最新n条记录并按时间排序
    List<SummaryHour> getNewestLimit(Integer limit) throws Exception;
	
}
