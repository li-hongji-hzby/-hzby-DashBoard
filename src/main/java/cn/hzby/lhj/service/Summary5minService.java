package cn.hzby.lhj.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import cn.hzby.lhj.po.Summary5min;

@Service
public interface Summary5minService extends BaseService<Summary5min, Integer>{

	public List<Summary5min> getNewestLimit(@RequestParam("limit") Integer limit) throws Exception;
}
