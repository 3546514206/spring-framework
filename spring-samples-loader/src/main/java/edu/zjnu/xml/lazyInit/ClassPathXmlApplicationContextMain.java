package edu.zjnu.xml.lazyInit;

import edu.zjnu.xml.inject.Man;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: 杨海波
 * @date: 2022-12-13 20:15:49
 * @description: todo
 */
public class ClassPathXmlApplicationContextMain {

	public static void main(String[] args) {
		// 创建工厂,加载配置文件
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-xml-lazy-init.xml");
		Man man = (Man) context.getBean("man");
		System.out.println(man.toString());
		System.out.println(man.getWife().toString());
	}
}
