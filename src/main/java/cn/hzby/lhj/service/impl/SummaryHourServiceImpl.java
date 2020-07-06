package cn.hzby.lhj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hzby.lhj.mapper.extend.SummaryHourMapperExtend;
import cn.hzby.lhj.po.SummaryHour;
import cn.hzby.lhj.service.SummaryHourService;

@Service
public class SummaryHourServiceImpl implements SummaryHourService {

	@Autowired
	private SummaryHourMapperExtend summaryHourMapper;
	
	@Override
	public List<SummaryHour> listAll() throws Exception {
		// 查询所有
		return summaryHourMapper.selectByExample(null);
	}

	@Override
	public SummaryHour getById(Integer id) throws Exception {
		// 根据主键查询
		return summaryHourMapper.selectByPrimaryKey(id);
	}

	@Override
	public int save(SummaryHour t) throws Exception {
		// 插入一条数据
		return summaryHourMapper.insertSelective(t);
	}

	@Override
	public int removeById(Integer id) throws Exception {
		// 根据主键删除
		return summaryHourMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<SummaryHour> getNewestLimit(Integer limit) throws Exception {
		// 查询最新n条记录并按时间排序
		return summaryHourMapper.getNewestLimit(limit);
	}
	
	

}
