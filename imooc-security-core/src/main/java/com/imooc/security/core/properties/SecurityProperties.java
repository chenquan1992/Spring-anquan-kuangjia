/**
 * 
 */
package com.imooc.security.core.properties;

import com.imooc.security.core.SecurityCoreConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author zhailiang
 * @see SecurityCoreConfig 使SecurityProperties这个类生效还需要SecurityCoreConfig这个类的声明
 *
 */
@ConfigurationProperties(prefix = "imooc.security")//这个注解表示SecurityProperties这个类会读取配置文件中以imooc.security开头的配置项
public class SecurityProperties {
	//imooc.security.browser.signUpUrl = /demo-signUp.html配置文件中的一个项
	private BrowserProperties browser = new BrowserProperties();//其中browser的项就会被这个browser的属性读取，然后这个他里面还有一个signUpUrl的属性可以具体的读取这个项的内容
	
	private ValidateCodeProperties code = new ValidateCodeProperties();
	
	private SocialProperties social = new SocialProperties();

	public BrowserProperties getBrowser() {
		return browser;
	}

	public void setBrowser(BrowserProperties browser) {
		this.browser = browser;
	}

	public ValidateCodeProperties getCode() {
		return code;
	}

	public void setCode(ValidateCodeProperties code) {
		this.code = code;
	}

	public SocialProperties getSocial() {
		return social;
	}

	public void setSocial(SocialProperties social) {
		this.social = social;
	}
}

