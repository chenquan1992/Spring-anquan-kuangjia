/**
 * 
 */
package com.imooc.security.core;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.imooc.security.core.properties.SecurityProperties;

/**
 * @author zhailiang
 * @see SecurityProperties 
 */
@Configuration//声明为配置类
@EnableConfigurationProperties(SecurityProperties.class)//声明使SecurityProperties.class这个类可以读取到配置文件的属性值
public class SecurityCoreConfig {

}
