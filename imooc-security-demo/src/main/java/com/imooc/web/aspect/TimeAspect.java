/**
 * 
 */
package com.imooc.web.aspect;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;

/**
 * @author zhailiang
 *
 */
//@Aspect//声明为切片（类）
//@Component//声明为Spring容器的一部分
public class TimeAspect {
	//@Around表明在方法的前后，抛出异常时起作用
	//"execution(* com.imooc.web.controller.UserController.*(..))"执行表达式，表明在哪些方法上起作用，具体写法百度去
	//上面的写法表明在UserController中的所有方法，无论参数，无论返回值都起作用，就是运行下面的函数
	@Around("execution(* com.imooc.web.controller.UserController.*(..))")//切入点
	public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {//增强，ProceedingJoinPoint这个参数是必须这么写的
		
		System.out.println("time aspect start");//环绕拦截，之前，相当于@Before
		
		Object[] args = pjp.getArgs();//这是获取请求带过来的参数，这是Interceptor拦截器办不到的，
		for (Object arg : args) {
			System.out.println("arg is "+arg);
		}
		
		long start = new Date().getTime();
		
		Object object = pjp.proceed();//调用控制器Controller被拦截的方法
		
		System.out.println("time aspect 耗时:"+ (new Date().getTime() - start));
		
		System.out.println("time aspect end");//环绕拦截，之前，相当于@after
		
		return object;
	}

	//备注：一般使用@around的比较多，还可以将Object object = pjp.proceed();包含在try...catch中，捕获抛出的异常

}
