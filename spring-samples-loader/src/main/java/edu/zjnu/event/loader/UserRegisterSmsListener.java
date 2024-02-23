package edu.zjnu.event.loader;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @description: UserRegisterSmsListener
 * @author: 杨海波
 * @date: 2022-03-29 14:13
 **/
@Component
public class UserRegisterSmsListener {

	@EventListener
	public void handleUserEvent(UserEvent userEvent) {
		System.out.println("UserRegisterSmsListener:" + userEvent.flag());
		System.out.println("source:" + userEvent.getSource());
	}
}
