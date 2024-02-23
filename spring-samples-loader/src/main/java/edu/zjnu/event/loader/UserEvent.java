package edu.zjnu.event.loader;

import org.springframework.context.ApplicationEvent;

/**
 * @description: UserRunEvent:用户事件
 * @author: 杨海波
 * @date: 2022-03-29 14:07
 **/
public class UserEvent extends ApplicationEvent {

	private static final long serialVersionUID = 7094057708183571937L;

	/**
	 * Create a new {@code ApplicationEvent}.
	 *
	 * @param source the object on which the event initially occurred or with
	 *               which the event is associated (never {@code null})
	 */
	public UserEvent(Object source) {
		super(source);
	}

	public String flag() {
		return "flag";
	}
}
