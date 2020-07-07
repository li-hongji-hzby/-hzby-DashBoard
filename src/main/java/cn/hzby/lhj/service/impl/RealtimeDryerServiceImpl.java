package cn.hzby.lhj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hzby.lhj.mapper.extend.RealtimeDryerMapperExtend;
import cn.hzby.lhj.po.RealtimeDryer;
import cn.hzby.lhj.service.RealtimeDryerService;

/**
 * @author lhj
 */
@Service
public class RealtimeDryerServiceImpl implements RealtimeDryerService {

	@Autowired
	private RealtimeDryerMapperExtend realtimeDryerMapper;
	
	@Override
	public List<RealtimeDryer> listAll() throws Exception {
		// 查询所有
		return realtimeDryerMapper.selectByExample(null);
	}

	@Override
	public RealtimeDryer getById(String id) throws Exception {
		// 根据主键查询
		return realtimeDryerMapper.selectByPrimaryKey(id);
	}

	@Override
	public int save(RealtimeDryer t) throws Exception {
		// 插入一条数据
		return realtimeDryerMapper.insertSelective(t);
	}

	@Override
	public int removeById(String id) throws Exception {
		// 根据主键删除
		return realtimeDryerMapper.deleteByPrimaryKey(id);
	}
}
