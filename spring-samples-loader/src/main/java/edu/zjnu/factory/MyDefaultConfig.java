package edu.zjnu.factory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 杨海波
 * @date 2024/1/29 11:16
 * @description MyDefaultConfig
 */
@Configuration
public class MyDefaultConfig {

	@Bean
	public static MyBeanFactoryPostProcessor myBeanFactoryPostProcessor() {
		return new MyBeanFactoryPostProcessor();
	}

	@Bean
	public Restaurant restaurant() {
		return new Restaurant();
	}
}
