package cn.hzby.lhj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hzby.lhj.mapper.extend.RealtimeAirCompressorMapperExtend;
import cn.hzby.lhj.po.RealtimeAirCompressor;
import cn.hzby.lhj.service.RealtimeAirCompressorService;

@Service
public class RealtimeAirCompressorServiceImpl implements RealtimeAirCompressorService {

	@Autowired
	private RealtimeAirCompressorMapperExtend realtimeAirCompressorMapper;
	
	@Override
	public List<RealtimeAirCompressor> listAll() throws Exception {
		// TODO 查询所有
		return realtimeAirCompressorMapper.selectByExample(null);
	}

	@Override
	public RealtimeAirCompressor getById(String id) throws Exception {
		// TODO 根据主键查询
		return realtimeAirCompressorMapper.selectByPrimaryKey(id);
	}

	@Override
	public int save(RealtimeAirCompressor t) throws Exception {
		// TODO 插入一条数据
		return realtimeAirCompressorMapper.insertSelective(t);
	}

	@Override
	public int removeById(String id) throws Exception {
		// TODO 根据主键删除
		return realtimeAirCompressorMapper.deleteByPrimaryKey(id);
	}

}
