package edu.zjnu.xml.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Objects;

/**
 * @author: 杨海波
 * @date: 2022-12-16 09:52:19
 * @description: todo
 */
public class FactoryMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-factory.xml");
		Car car = (Car) context.getBean("car");
		// 加上 & 代表获取 工厂bean 本身
		CarFactoryBean factoryBean = (CarFactoryBean) context.getBean("&car");
		System.out.println(car);
		//  为什么通过两种方式获取的 实际对象 哈希值不一样？
		System.out.println(car.hashCode());
		System.out.println(Objects.requireNonNull(factoryBean.getObject()).hashCode());

		Car car1 = (Car) context.getBean("car");
		// 加上 & 代表获取 工厂bean 本身
		CarFactoryBean factoryBean1 = (CarFactoryBean) context.getBean("&car");
		//  为什么通过两种方式获取的 实际对象 哈希值不一样？
		System.out.println(car1.hashCode());
		System.out.println(Objects.requireNonNull(factoryBean1.getObject()).hashCode());

		// car 和 car1 的哈希值相同，说明 car 本身是单例的（默认作用域）
	}
}
