package cn.hzby.lhj.filter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CorsFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletResponse httpServletResponse = (HttpServletResponse) response; 
		// 如果不是80端口,需要将端口加上,如果是集群,则用Nginx的地址,同理不是80端口要加上端口
		String []  allowDomain= {"http://localhost:3000","http://127.0.0.1:3000","http://139.196.28.123:3000","http://localhost:3001","http://2s7413325f.zicp.vip","http://plant.hzby.tech:3000","https://plant.hzby.tech:3000",};
		Set<String> allowedOrigins= new HashSet<String>(Arrays.asList(allowDomain));
		String originHeader=((HttpServletRequest) request).getHeader("Origin");
		if (allowedOrigins.contains(originHeader)){
			httpServletResponse.setHeader("Access-Control-Allow-Origin", originHeader);
			httpServletResponse.setHeader("Access-Control-Allow-Headers","Content-Type,Access-Token");
			httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
			httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}

}