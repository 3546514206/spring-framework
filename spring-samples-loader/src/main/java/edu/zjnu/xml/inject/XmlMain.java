package edu.zjnu.xml.inject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description: 主方法
 * @author: 杨海波
 * @date: 2022-01-26
 **/
public class XmlMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-xml.xml");
		Man man = (Man) context.getBean("man");
		System.out.println(man.toString());
		System.out.println(man.getWife().toString());
	}
}
