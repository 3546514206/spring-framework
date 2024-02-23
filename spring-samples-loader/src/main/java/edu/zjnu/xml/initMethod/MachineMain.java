package edu.zjnu.xml.initMethod;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: 杨海波
 * @date: 2022-12-16 15:09:11
 * @description: todo
 */
public class MachineMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-xml-init-method.xml");
		Machine machine = context.getBean(Machine.class);
		System.out.println(machine.getName());
	}
}
