package cn.hzby.lhj.service;

import java.util.List;



/**
 * @author lhj
 */
public interface BaseService<T,ID> {

    /**
     * 查询所有记录
     * @param
     * @return List<T>
     * @throws Exception
     */
    List<T> listAll() throws Exception;

    /**
     * 根据主键查询
     * @param id
     * @return T
     * @throws Exception
     */
    T getById(ID id) throws Exception;

    /**
     * 添加·修改
     * @param t
     * @return int
     * @throws Exception
     */
    int save(T t) throws Exception;

    /**
     * 根据主键删除
     * @param id
     * @return int
     * @throws Exception
     */
    int removeById(ID id) throws Exception;
}