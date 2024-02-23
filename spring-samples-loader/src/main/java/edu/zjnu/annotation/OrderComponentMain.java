package edu.zjnu.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description: OrderComponentMain
 * @author: 杨海波
 * @date: 2022-05-14 16:35
 **/
public class OrderComponentMain {

	public static void main(String[] args) {
		// 创建工厂,加载配置文件
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-annotation.xml");
	}
}
