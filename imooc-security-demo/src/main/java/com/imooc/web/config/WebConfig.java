/**
 * 
 */
package com.imooc.web.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.imooc.web.filter.TimeFilter;
import com.imooc.web.interceptor.TimeInterceptor;

/**
 * @author zhailiang
 *
 */
@Configuration//告诉Spring boot这是一个配置类
public class WebConfig extends WebMvcConfigurerAdapter {
	
	@SuppressWarnings("unused")
	@Autowired
	private TimeInterceptor timeInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {//拦截器注册器
//		registry.addInterceptor(timeInterceptor);//注册拦截器
	}
	
//	@Bean //交给Spring 管理这个方法
	public FilterRegistrationBean timeFilter() {
		//FilterRegistrationBean这是Spring boot专门用来加载fillter的配置类，
		// 这样的写法就可以不用再filter上标注@Component的注解，同时也可以控制那些路径需要拦截，也可以将第三方的拦截器配置到自己的系统中
		
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();//必须new 的
		
		TimeFilter timeFilter = new TimeFilter();//这是自己定义的一个filter过滤器
		registrationBean.setFilter(timeFilter);//将过滤器配置在registrationBean中
		
		List<String> urls = new ArrayList<>();
		urls.add("/*");//设置过滤的路径，这个表示全部路径拦截
		registrationBean.setUrlPatterns(urls);//把路径配置在registrationBean中
		
		return registrationBean;
		
	}

}
