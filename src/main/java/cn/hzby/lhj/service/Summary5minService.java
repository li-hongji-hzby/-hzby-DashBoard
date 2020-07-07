package cn.hzby.lhj.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import cn.hzby.lhj.po.Summary5min;

/**
 * @author lhj
 */
@Service
public interface Summary5minService extends BaseService<Summary5min, Integer>{

	/**
	 * 获取最新的数据根据传入条数
	 * @param limit
	 * @return
	 * @throws Exception
	 */
	List<Summary5min> getNewestLimit(@RequestParam("limit") Integer limit) throws Exception;
}
