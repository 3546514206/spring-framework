package edu.zjnu.xml.beanPostProcessor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: 杨海波
 * @date: 2022-12-16 15:22:10
 * @description: todo
 */
public class ProcessorMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-xml-processor.xml");
		Machine machine = context.getBean(Machine.class);
		System.out.println(machine.getName());
	}
}
