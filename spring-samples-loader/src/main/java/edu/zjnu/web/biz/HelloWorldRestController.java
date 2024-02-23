package edu.zjnu.web.biz;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 杨海波
 * @date: 2022-12-15 10:06:29
 * @description: HelloWorldRestController
 */
@RestController
public class HelloWorldRestController {

	@RequestMapping("/hello/{player}")
	public Message message(@PathVariable String player) {

		Message msg = new Message(player, "Hello " + player);
		return msg;
	}

}


