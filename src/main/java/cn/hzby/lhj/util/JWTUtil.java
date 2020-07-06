package cn.hzby.lhj.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * @author lhj
 */
public class JWTUtil {

	
	public static String setJWT(String id, String msg ,Integer time) {
	    long now = System.currentTimeMillis();//当前时间 
	    long exp = now + time;//过期时间为3秒
		JwtBuilder builder = Jwts.builder().setId(id).setSubject(msg).setIssuedAt(new Date())// 设置签发时间
				.signWith(SignatureAlgorithm.HS256, "evil-scream")
		        .setExpiration(new Date(exp));//设置过期时间;// 设置签名秘钥
		return builder.compact();
	}
	
	public static Map<String,String> checkJWT(String jwt, HttpServletResponse response) {
		Map<String,String> result = new HashMap<String, String>(16);
		try {
			Jwts.parser().setSigningKey("evil-scream").parseClaimsJws(jwt).getBody();
			// Claims claims =Jwts.parser().setSigningKey("evil-scream").parseClaimsJws(jwt).getBody();
			result.put("msg","JWT验证通过");
			result.put("code", "true");
		} catch (ExpiredJwtException e) {
			e.printStackTrace();
			result.put("msg", "过期");
			result.put("code", "false");
			response.setStatus(401);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("msg", "其他");
			result.put("code", "false");
			response.setStatus(401);
		}
		return result;
	}
}
