package cn.hzby.lhj.log;

import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.omg.CORBA.UNKNOWN;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import cn.hzby.lhj.po.LogMsgWithBLOBs;
import cn.hzby.lhj.service.LogMsgService;


/**
 * 日志切面类
 * @author oKong
 *
 */

@Aspect
@Component
public class LogAspect {
	
	@Autowired
	private LogMsgService logMsgService;

    private final Logger log = LoggerFactory.getLogger(LogAspect.class);

    private static String UNKNOWN = "unknown";
    private static String LOCALHOST = "127.0.0.1";
    private static  int ADDRLEN = 15;
    private static  String COMMA = ",";

	/**
	 * 设置切入点：这里直接拦截被@RestController注解的类
	 * @return
	 * @throws
	 */
	@Pointcut("within(@org.springframework.stereotype.Controller *) || within(@org.springframework.web.bind.annotation.RestController *)")
	public void pointcut() {
		
	}
	
	/**
	 * 切面方法,记录日志
	 * @return
	 * @throws Throwable 
	 */
	@Around("pointcut()")
	public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
		/* 1.开始时间 */
		long beginTime = System.currentTimeMillis();
		/* 利用RequestContextHolder获取requst对象 */
		ServletRequestAttributes requestAttr = (ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
    	String uri = requestAttr.getRequest().getRequestURI();
    	log.info("开始计时: {}  URI: {}", new Date(),uri);
    	/* 访问目标方法的参数 可动态改变参数值 */
        Object[] args = joinPoint.getArgs();
    	/* 方法名获取 */
    	String methodName = joinPoint.getSignature().getName();
        log.info("请求方法：{}, 请求参数: {}", methodName, Arrays.toString(args));
        /* 可能在反向代理请求进来时，获取的IP存在不正确行 这里直接摘抄一段来自网上获取ip的代码 */
        log.info("请求ip：{}", getIpAddr(requestAttr.getRequest()));
		Signature signature = joinPoint.getSignature();
		if(!(signature instanceof MethodSignature)) {
			throw new IllegalArgumentException("暂不支持非方法注解");
		}
		//调用实际方法
		Object object = joinPoint.proceed();
		//获取执行的方法
		MethodSignature methodSign = (MethodSignature) signature;
		Method method = methodSign.getMethod();
		//判断是否包含了 无需记录日志的方法 可以提前进行判断的
		Log logAnno = AnnotationUtils.getAnnotation(method, Log.class);
		if(logAnno != null && logAnno.ignore()) {
			return object;
		} 
		/* log.info("log注解描述：{}", logAnno.desc()); */
		long endTime = System.currentTimeMillis();
		log.info("结束计时: {},  URI: {},耗时：{}", new Date(),uri,endTime - beginTime);
		/* 后续可以日志入库处理，注意要使用异步方式 */
		return object;
	}
	
	/**
	 * 指定拦截器规则；也可直接使用within(@org.springframework.web.bind.annotation.RestController *)
	 * 这样简单点 可以通用
	 * @param joinPoint
	 * @throws Exception 
	 */
	@AfterThrowing(pointcut="pointcut()",throwing="e")
	public void afterThrowable(JoinPoint  joinPoint,Throwable e) throws Exception {
		LogMsgWithBLOBs logMsg = new LogMsgWithBLOBs();
		ServletRequestAttributes requestAttr = (ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
		logMsg.setTime(System.currentTimeMillis()/1000);
		logMsg.setIp(getIpAddr(requestAttr.getRequest()));
		logMsg.setMethodName(joinPoint.getSignature().getName());
		logMsg.setParam(Arrays.toString(joinPoint.getArgs()));
		logMsg.setMsg(e.toString());
		logMsgService.save(logMsg);
		/* log.error("切面发生了异常：", e); */
		/*这里可以做个统一异常处理
		自定义一个异常 包装后排除
		throw new AopException("xxx);*/
	}

	/**
	 * 转自：https://my.oschina.net/u/994081/blog/185982
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String ipAddress = null;
		try {
			ipAddress = request.getHeader("x-forwarded-for");
			if (ipAddress == null || ipAddress.length() == 0 || UNKNOWN.equalsIgnoreCase(ipAddress)) {
				ipAddress = request.getHeader("Proxy-Client-IP");
			}
			if (ipAddress == null || ipAddress.length() == 0 || UNKNOWN.equalsIgnoreCase(ipAddress)) {
				ipAddress = request.getHeader("WL-Proxy-Client-IP");
			}
			if (ipAddress == null || ipAddress.length() == 0 || UNKNOWN.equalsIgnoreCase(ipAddress)) {
				ipAddress = request.getRemoteAddr();
				if (LOCALHOST.equals(ipAddress)) {
					/* 根据网卡取本机配置的IP */
					InetAddress inet = null;
					try {
						inet = InetAddress.getLocalHost();
					} catch (UnknownHostException e) {
						/* log.error("获取ip异常：{}" ,e.getMessage()); */
						e.printStackTrace();
					}
					ipAddress = inet.getHostAddress();
				}
			}
			/* 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割 */
			if (ipAddress != null && ipAddress.length() > ADDRLEN) {
				if (COMMA.indexOf(ipAddress) > 0) {
					ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
				}
			}
		} catch (Exception e) {
			ipAddress = "";
		}
		/* ipAddress = this.getRequest().getRemoteAddr(); */
		return ipAddress;
	}	
}