/**
 * 
 */
package com.imooc.security.browser.support;

/**
 * @author zhailiang
 *
 */
public class SimpleResponse {//封装一下返回的值
	
	public SimpleResponse(Object content){
		this.content = content;
	}
	
	private Object content;

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}
	
}
