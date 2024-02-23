package edu.zjnu;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 杨海波
 * @date 2024/2/2 09:46
 * @description SpringSchemasExtMain
 */
public class SpringSchemasExtMain {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-service.xml");
		DistributedIdComponent bean = context.getBean(DistributedIdComponent.class);

		String id = bean.generateId();
		System.out.println(id);
	}
}
