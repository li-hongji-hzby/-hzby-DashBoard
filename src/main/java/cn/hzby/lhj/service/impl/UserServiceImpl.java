package cn.hzby.lhj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hzby.lhj.mapper.extend.UserMapperExtend;
import cn.hzby.lhj.po.User;
import cn.hzby.lhj.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapperExtend userMapper;
	
	@Override
	public List<User> listAll() throws Exception {
		// 查询所有用户
		return userMapper.selectByExample(null);
	}

	@Override
	public User getById(String id) throws Exception {
		// 根据主键查询用户
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public int save(User t) throws Exception {
		// 插入单个 用户
		return userMapper.insertSelective(t);
	}

	@Override
	public int removeById(String id) throws Exception {
		// 根据主键删除单个用户
		return userMapper.deleteByPrimaryKey(id);
	}

}
