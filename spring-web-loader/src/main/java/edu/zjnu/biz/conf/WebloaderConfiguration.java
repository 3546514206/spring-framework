package edu.zjnu.biz.conf;

import edu.zjnu.biz.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: WebloaderConfiguration
 * @author: 杨海波
 * @date: 2022-05-17 08:17
 **/
@Configuration
public class WebloaderConfiguration {

	@Bean
	public User getUser() {
		System.out.println("WebloaderConfiguration配置类已执行。");
		User user = new User();
		user.setName("杨海波");
		user.setAge(17);
		return user;
	}
}
