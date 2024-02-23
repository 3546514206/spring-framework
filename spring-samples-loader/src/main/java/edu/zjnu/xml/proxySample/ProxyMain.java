package edu.zjnu.xml.proxySample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: 杨海波
 * @date: 2022-12-14 19:29:40
 * @description: todo
 */
public class ProxyMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-xml-proxy.xml");
		BizService service = context.getBean(BizService.class);
		service.doSomeThing();
	}
}
