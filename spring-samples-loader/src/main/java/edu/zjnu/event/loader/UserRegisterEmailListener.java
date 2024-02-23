package edu.zjnu.event.loader;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @description: UserRegisterEmailListener
 * @author: 杨海波
 * @date: 2022-03-29 14:17
 **/
@Component
public class UserRegisterEmailListener implements ApplicationListener<UserEvent> {

	@Override
	public void onApplicationEvent(UserEvent userEvent) {
		System.out.println("UserRegisterEmailListener:" + userEvent.flag());
		System.out.println("source:" + userEvent.getSource());
	}
}
