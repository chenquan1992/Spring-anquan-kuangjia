/**
 * 
 */
package com.imooc.web.interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author zhailiang
 *
 */
@Component//这个与过滤器filter的不同，只写@Component是不能使这个拦截器生效的，还是另外配置一个WebConfig，这个WebConfig还要继承WebMvcConfigurerAdapter才能生效
public class TimeInterceptor implements HandlerInterceptor {

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {//调用方法前使用的方法
		System.out.println("preHandle");
		
		System.out.println(((HandlerMethod)handler).getBean().getClass().getName());//这里就是拦截器与过滤器不同的地方，handler拦截器可以知道请求的是哪个类哪个方法，而filter过滤器则不能
		System.out.println(((HandlerMethod)handler).getMethod().getName());
		
		request.setAttribute("startTime", new Date().getTime());
		return true;//返回true才会继续执行下续的方法，如果返回false下续的方法直接就不运行了（postHandle）
		
//		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//		return false;//失败的时候这样返回，false、还有错误代码response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#postHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.web.servlet.ModelAndView)
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {//方法运行之后调用的方法，如果抛异常，则不运行
		System.out.println("postHandle");
		Long start = (Long) request.getAttribute("startTime");
		System.out.println("time interceptor 耗时:"+ (new Date().getTime() - start));

	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#afterCompletion(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {//方法运行之后调用，不论抛异常与否，都会调用，由于使用了全局异常处理@ControllerAdvice，
		// 所以这里如果有异常，就会先被全局异常处理掉，然后就不算是异常了，所以在这里的ex就打印不出异常，如果是没有在全局异常处理的，那么这里就能捕获到异常，输出异常
		System.out.println("afterCompletion");
		Long start = (Long) request.getAttribute("startTime");
		System.out.println("time interceptor 耗时:"+ (new Date().getTime() - start));
		System.out.println("ex is "+ex);

	}

}
