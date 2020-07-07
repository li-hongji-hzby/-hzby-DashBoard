package cn.hzby.lhj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hzby.lhj.mapper.extend.RealtimeOverviewMapperExtend;
import cn.hzby.lhj.po.RealtimeOverview;
import cn.hzby.lhj.service.RealtimeOverviewService;

/**
 * @author lhj
 */
@Service
public class RealtimeOverviewServiceImpl implements RealtimeOverviewService {


	@Autowired
	private RealtimeOverviewMapperExtend realtimeOverviewMapper;
	
	@Override
	public List<RealtimeOverview> listAll() throws Exception {
		// 查询所有
		return realtimeOverviewMapper.selectByExample(null);
	}

	@Override
	public RealtimeOverview getById(String id) throws Exception {
		// 根据主键查询
		return realtimeOverviewMapper.selectByPrimaryKey(id);
	}

	@Override
	public int save(RealtimeOverview t) throws Exception {
		// 插入一条数据
		return realtimeOverviewMapper.insertSelective(t);
	}

	@Override
	public int removeById(String id) throws Exception {
		// 根据主键删除
		return realtimeOverviewMapper.deleteByPrimaryKey(id);
	}

}
