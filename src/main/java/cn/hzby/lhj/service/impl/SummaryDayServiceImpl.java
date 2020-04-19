package cn.hzby.lhj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hzby.lhj.mapper.extend.SummaryDayMapperExtend;
import cn.hzby.lhj.po.SummaryDay;
import cn.hzby.lhj.service.SummaryDayService;

@Service
public class SummaryDayServiceImpl implements SummaryDayService {

	@Autowired
	private SummaryDayMapperExtend summaryDayMapper;
	
	@Override
	public List<SummaryDay> listAll() throws Exception {
		// TODO 查询所有
		return summaryDayMapper.selectByExample(null);
	}

	@Override
	public SummaryDay getById(Integer id) throws Exception {
		// TODO 根据主键查询
		return summaryDayMapper.selectByPrimaryKey(id);
	}

	@Override
	public int save(SummaryDay t) throws Exception {
		// TODO 插入一条数据
		return summaryDayMapper.insertSelective(t);
	}

	@Override
	public int removeById(Integer id) throws Exception {
		// TODO 根据主键删除
		return summaryDayMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<SummaryDay> getNewestLimit(Integer limit) throws Exception {
		// TODO 查询最新n条记录并按时间排序
		return summaryDayMapper.getNewestLimit(limit);
	}

}
