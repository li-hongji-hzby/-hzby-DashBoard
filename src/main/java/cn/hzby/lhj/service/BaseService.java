package cn.hzby.lhj.service;

import java.util.List;



public interface BaseService<T,ID> {
	
	// 查询所有记录
	public List<T> listAll() throws Exception;
	// 根据主键查询
	public T getById(ID id) throws Exception;
	// 添加·修改
	public int save(T t) throws Exception;
	// 根据主键删除
	public int removeById(ID id) throws Exception;
}