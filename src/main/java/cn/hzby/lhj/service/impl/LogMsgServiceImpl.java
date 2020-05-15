package cn.hzby.lhj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hzby.lhj.mapper.extend.LogMsgMapperExtend;
import cn.hzby.lhj.po.LogMsgWithBLOBs;
import cn.hzby.lhj.service.LogMsgService;

@Service
public class LogMsgServiceImpl implements LogMsgService {

	@Autowired
	private LogMsgMapperExtend logMsgMapper;
	
	@Override
	public List<LogMsgWithBLOBs> listAll() throws Exception {
		return logMsgMapper.selectByExampleWithBLOBs(null);
	}

	@Override
	public LogMsgWithBLOBs getById(Integer id) throws Exception {
		return logMsgMapper.selectByPrimaryKey(id);
	}

	@Override
	public int save(LogMsgWithBLOBs t) throws Exception {
		return logMsgMapper.insertSelective(t);
	}

	@Override
	public int removeById(Integer id) throws Exception {
		return logMsgMapper.deleteByPrimaryKey(id);
	}

}
