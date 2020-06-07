package cn.hzby.lhj.api;


import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aliyun.hitsdb.client.value.response.LastDataValue;

import cn.hzby.lhj.util.TSDBUtils;


@RestController
@CrossOrigin
public class PageConfigAPI {


	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public List<LastDataValue> getProjectConfig() throws Exception{
		TSDBUtils tsdbUtils = new TSDBUtils();
		return null;
	}
	
}
