/**
 * 
 */
package com.imooc.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.imooc.exception.UserNotExistException;

/**
 * @author zhailiang
 *
 */
@ControllerAdvice//这个注解捕获所有Controller抛出的异常
public class ControllerExceptionHandler {

	@ExceptionHandler(UserNotExistException.class)//当捕获到UserNotExistException这个异常运行下面的方法
	@ResponseBody//返回json格式
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)//指定返回的错误码
	public Map<String, Object> handleUserNotExistException(HttpServletRequest request,UserNotExistException ex) {//捕获到的异常肯定要接受传进来的
		Map<String, Object> result = new HashMap<>();
		result.put("id", ex.getId());
		result.put("message", ex.getMessage());
		return result;
	}

}
