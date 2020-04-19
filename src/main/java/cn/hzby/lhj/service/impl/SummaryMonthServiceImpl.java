package cn.hzby.lhj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hzby.lhj.mapper.extend.SummaryMonthMapperExtend;
import cn.hzby.lhj.po.SummaryMonth;
import cn.hzby.lhj.service.SummaryMonthService;

@Service
public class SummaryMonthServiceImpl implements SummaryMonthService {

	@Autowired
	private SummaryMonthMapperExtend summaryMonthMapper;
	
	@Override
	public List<SummaryMonth> listAll() throws Exception {
		// TODO 查询所有
		return summaryMonthMapper.selectByExample(null);
	}

	@Override
	public SummaryMonth getById(Integer id) throws Exception {
		// TODO 根据主键查询
		return summaryMonthMapper.selectByPrimaryKey(id);
	}

	@Override
	public int save(SummaryMonth t) throws Exception {
		// TODO 插入一条数据
		return summaryMonthMapper.insertSelective(t);
	}

	@Override
	public int removeById(Integer id) throws Exception {
		// TODO 根据主键删除
		return summaryMonthMapper.deleteByPrimaryKey(id);
	}
	

	@Override
	public List<SummaryMonth> getNewestLimit(Integer limit) throws Exception {
		// TODO 查询最新n条记录并按时间排序
		return summaryMonthMapper.getNewestLimit(limit);
	}

}
