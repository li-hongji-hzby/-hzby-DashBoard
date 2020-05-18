package cn.hzby.lhj.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import cn.hzby.lhj.filter.CorsFilter;


@Configuration
@ConditionalOnMissingBean(WebMvcConfigurationSupport.class)
public class WebConfigurer implements WebMvcConfigurer{
	
	
  
    // 这个方法是用来配置静态资源的，比如html，js，css，等等
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
//		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
//		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
	 
	// 这个方法用来注册拦截器，我们自己写好的拦截器需要通过这里添加注册才能生效
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns("/**") 表示拦截所有的请求，
        // excludePathPatterns("/login", "/register") 表示除了登陆与注册之外，因为登陆注册不需要登陆也可以访问
		//registry.addInterceptor(userLoginInterceptor).excludePathPatterns("/login/**","/register","/static/**");
//		registry.addInterceptor(loginInterceptor).excludePathPatterns("/api/**","/user/login","/user/loginError","/register","/static/**");
	}


	
	/**
	 * 注册 cors filter
	 * @return
	 */
	@Bean
	public FilterRegistrationBean<CorsFilter> someFilterRegistration() {
	    FilterRegistrationBean<CorsFilter> registration = new FilterRegistrationBean<CorsFilter>();
	    registration.setFilter(new CorsFilter());
	    registration.addUrlPatterns("/*");
	    registration.setName("corsFilter");
	    registration.setOrder(1);
	    return registration;
	}
}
