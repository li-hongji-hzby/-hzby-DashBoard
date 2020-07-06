package cn.hzby.lhj.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import cn.hzby.lhj.po.User;
import cn.hzby.lhj.service.ProjectService;
import cn.hzby.lhj.service.UserService;
import cn.hzby.lhj.util.EncryptUtil;
import cn.hzby.lhj.util.JWTUtil;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserAPI {

	@Autowired
	private UserService userSrvice;

	@Autowired
	private ProjectService projectService; 
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public Map<String, String> register(@RequestParam("username")String username,@RequestParam("password")String password) throws Exception{
		Map<String, String> result = new HashMap<String, String>();
		User user = new User();
		try {
			user.setUsername(username);
			user.setPassword(EncryptUtil.getSHA256Str(password));
			userSrvice.save(user);
			result.put("msg", "注册成功");
			result.put("code","1");
		} catch (Exception e) {
			e.printStackTrace();
			result.put("msg", "注册失败");
			result.put("code","0");
		}
		return result;
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public Map<String, String> login(@RequestBody JSONObject getJSON) throws Exception{
		Map<String, String> result = new HashMap<String, String>();
		User user = new User();
		String username = getJSON.getString("username");
		String password = getJSON.getString("password");
		try {
			user = userSrvice.getById(username);
			if(user!=null) {
				if(user.getPassword().equals(EncryptUtil.getSHA256Str(password)) && user.getStatus()) {
					String JWTString = JWTUtil.setJWT(user.getUsername(), user.getUsername(), 1000*60*2880*7);
					Map<String, Object> msg = new HashMap<String, Object>();
					msg.put("user", username);
					msg.put("jwt", JWTString);
					msg.put("pageConfig", projectService.getProjectConfigByUser(username));
					msg.put("project", projectService.getByUsername(username));
					result.put("msg", JSON.toJSONString(msg));
					result.put("code", "1");
				}else if(!user.getStatus()){
					result.put("msg", "登录失败,用户未激活 ");
					result.put("code","0");
				}else{
					result.put("msg", "登录失败,密码错误");
					result.put("code","0");
				}
			}else {
				result.put("msg", "登录失败,用户不存在");
				result.put("code","0");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("msg", "登录失败");
			result.put("code","0");
		}
		return result;
	}

	@RequestMapping(value="/loginError", method=RequestMethod.GET)
	public Map<String, String> loginError() throws Exception{
		Map<String, String> result = new HashMap<String, String>();
		result.put("msg","用户未登录");
		result.put("code","0");
		return result;
	}
	
}
