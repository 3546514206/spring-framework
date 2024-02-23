package edu.zjnu.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 杨海波
 * @date 2024/1/29 11:17
 * @description BeanFactoryPostProcessorTest
 */
public class BeanFactoryPostProcessorTest {
	public static void main(String[] args) {

		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-factory-post.xml");

		Restaurant restaurant = ac.getBean("restaurant", Restaurant.class);

		restaurant.printWelcome();
	}
}
