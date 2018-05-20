/**
 * 
 */
package com.imooc.exception;

/**
 * @author zhailiang
 *
 */
public class UserNotExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6112780192479692859L;
	
	private String id;
	
	public UserNotExistException(String id) {
		super("user not exist");//使用父类的方法，这是提示出错原因
		this.id = id;//id传进来可以获取到，知道这是具体哪里什么错误
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
