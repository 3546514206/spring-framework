package edu.zjnu.event.loader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * @description: UserEventService
 * @author: 杨海波
 * @date: 2022-03-29 14:24
 **/
@Component(value = "userEventService")
public class UserEventService {
	//    时间分发器
	@Autowired
	private ApplicationEventPublisher eventPublisher;

	public void publishEvent() {
		UserEvent userEvent = new UserEvent(this);
		eventPublisher.publishEvent(userEvent);
	}
}
