package cn.hzby.lhj.service;

import java.util.List;



/**
 * @author lhj
 */
public interface BaseService<T,ID> {
	
	/** 查询所有记录 **/
    List<T> listAll() throws Exception;
	 /** 根据主键查询 **/
    T getById(ID id) throws Exception;
	/** 添加·修改 **/
    int save(T t) throws Exception;
	/** 根据主键删除 **/
    int removeById(ID id) throws Exception;
}