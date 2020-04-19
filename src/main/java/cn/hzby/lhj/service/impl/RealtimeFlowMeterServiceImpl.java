package cn.hzby.lhj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hzby.lhj.mapper.extend.RealtimeFlowMeterMapperExtend;
import cn.hzby.lhj.po.RealtimeFlowMeter;
import cn.hzby.lhj.service.RealtimeFlowMeterService;

@Service
public class RealtimeFlowMeterServiceImpl implements RealtimeFlowMeterService {

	@Autowired
	private RealtimeFlowMeterMapperExtend realtimeFlowMeterMapper;
	
	@Override
	public List<RealtimeFlowMeter> listAll() throws Exception {
		// TODO 查询所有
		return realtimeFlowMeterMapper.selectByExample(null);
	}

	@Override
	public RealtimeFlowMeter getById(String id) throws Exception {
		// TODO 根据主键查询
		return realtimeFlowMeterMapper.selectByPrimaryKey(id);
	}

	@Override
	public int save(RealtimeFlowMeter t) throws Exception {
		// TODO 插入一条数据
		return realtimeFlowMeterMapper.insertSelective(t);
	}

	@Override
	public int removeById(String id) throws Exception {
		// TODO 根据主键删除
		return realtimeFlowMeterMapper.deleteByPrimaryKey(id);
	}

}
