package edu.zjnu.event.loader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description: APP
 * @author: 杨海波
 * @date: 2022-03-29 14:28
 **/
public class SpringListenerApp {

	public static void main(String[] args) {
		// 创建工厂,加载配置文件
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-listener.xml");

		UserEventService eventService = (UserEventService) ac.getBean("userEventService");
		eventService.publishEvent();
	}
}
