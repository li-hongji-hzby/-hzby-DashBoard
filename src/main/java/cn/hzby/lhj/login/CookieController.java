package cn.hzby.lhj.login;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cookie")
public class CookieController {

	@RequestMapping(value="/setCookie",method=RequestMethod.GET)
	public String setCookid(HttpServletResponse response) {
		Cookie cookie = new Cookie("sessionId","CookieTestInfo");
		cookie.setMaxAge(10);
		response.addCookie(cookie);
		return "添加cookie成功";
	}
	
	@RequestMapping("/getCookie")
	public String getCookie(@CookieValue("sessionId") String sessionId ) {
		//前提是已经创建了或者已经存在cookie了，那么下面这个就直接把对应的key值拿出来了。
		System.out.println("testCookieValue,sessionId="+sessionId);
	    return sessionId;
	}
	
	@RequestMapping("/delCookie")
	public String delCookie(@CookieValue("sessionId") String sessionId ,HttpServletResponse response) {
		//前提是已经创建了或者已经存在cookie了，那么下面这个就直接把对应的key值拿出来了。
		try {
			Cookie cookie = new Cookie("sessionId",null);
			cookie.setMaxAge(0);
	        response.addCookie(cookie);
		} catch (Exception e) {
			e.printStackTrace();
		}
	    return "销毁cookie成功";
	}
}
