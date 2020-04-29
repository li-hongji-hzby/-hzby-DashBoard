package cn.hzby.lhj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hzby.lhj.mapper.extend.Summary5minMapperExtend;
import cn.hzby.lhj.po.Summary5min;
import cn.hzby.lhj.service.Summary5minService;

@Service
public class Summary5minServiceImpl implements Summary5minService {

	@Autowired
	private Summary5minMapperExtend summary5minMapper;
	

	
	@Override
	public List<Summary5min> listAll() throws Exception {
		// TODO 查询所有
		return summary5minMapper.selectByExample(null);
	}

	@Override
	public Summary5min getById(Integer id) throws Exception {
		// TODO 根据主键查询
		return summary5minMapper.selectByPrimaryKey(id);
	}

	@Override
	public int save(Summary5min t) throws Exception {
		// TODO 插入一条数据
		return summary5minMapper.insertSelective(t);
	}

	@Override
	public int removeById(Integer id) throws Exception {
		// TODO 根据主键删除
		return summary5minMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<Summary5min> getNewestLimit(Integer limit) throws Exception {
		// TODO 查询最新n条记录并按时间排序
		return summary5minMapper.getNewestLimit(limit);
	}

}
