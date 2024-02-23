package edu.zjnu.event.parent;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: 杨海波
 * @date: 2022-12-16 08:48:07
 * @description: todo
 */
public class ParentMain {

	public static void main(String[] args) {
		AbstractApplicationContext subContext = new ClassPathXmlApplicationContext("spring-sub.xml");
		subContext.setId("subContext");
		subContext.refresh();

		Sub sub = (Sub) subContext.getBean("sub");
		System.out.println(sub.getName());

		AbstractApplicationContext parentContext = new ClassPathXmlApplicationContext("spring-parent.xml");
		parentContext.setId("parentContext");
		subContext.setParent(parentContext);
		subContext.refresh();

		Parent parent = (Parent) subContext.getBean("parent");
		System.out.println(parent.getName());
	}
}
