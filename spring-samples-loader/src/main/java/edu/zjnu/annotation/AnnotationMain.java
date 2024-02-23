package edu.zjnu.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description: AnnotationMain
 * @author: 杨海波
 * @date: 2022-01-27
 **/
public class AnnotationMain {

	public static void main(String[] args) {

		// 创建工厂,加载配置文件
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-annotation.xml");

		// 通过工厂获得对象
		// "userService" 对应注解中 value 的值
		PersonServiceImpl personService = (PersonServiceImpl) ac.getBean("userService");
		System.out.println(personService.getPersonByNameAndAge("杨海波", 18));
	}
}
