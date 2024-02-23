package edu.zjnu.annotation;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @description: OrderComponent
 * @author: 杨海波
 * @date: 2022-05-14 16:24
 **/
@Component
@Order(1)
public class OrderComponent {

	@Resource(name = "userService")
	private PersonServiceImpl personService;

	public void printUserWhileSpringContextComplete() {
		System.out.println(personService.getDefaultUser());
	}

}
