package edu.zjnu.event.demo.listener;

import edu.zjnu.event.demo.event.Event;

/**
 * @description: ContextListener
 * @author: 杨海波
 * @date: 2022-03-28 14:08
 **/
public interface ContextListener<T extends Event> extends EventListener {

	/**
	 * Handle an application event.
	 *
	 * @param event the event to respond to
	 */
	default void onApplicationEvent(T event) {
		System.out.println("统一事件处理");
	}
}
