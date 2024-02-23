package edu.zjnu.factory;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author 杨海波
 * @date 2024/1/29 11:15
 * @description Restaurant 测试类
 */
public class Restaurant {

	@Value("welcome to my restaurant")
	private String welcome;

	public void setWelcome(String welcome) {
		this.welcome = welcome;
	}

	public void printWelcome() {
		System.out.println(this.welcome);
	}
}
