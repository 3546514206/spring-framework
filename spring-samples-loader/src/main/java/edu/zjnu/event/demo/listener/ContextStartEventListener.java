package edu.zjnu.event.demo.listener;

import edu.zjnu.event.demo.event.AbstractContextEvent;
import edu.zjnu.event.demo.event.ContextStartEvent;

/**
 * @description: ContextListener
 * @author: 杨海波
 * @date: 2022-03-28 14:11
 **/
public class ContextStartEventListener implements ContextListener<AbstractContextEvent> {

	/**
	 * Handle an application event.
	 *
	 * @param event the event to respond to
	 */
	@Override
	public void onApplicationEvent(AbstractContextEvent event) {
//        ContextListener.super.onApplicationEvent(event);
		if (event instanceof ContextStartEvent) {
			System.out.println("容器启动。。。，启动时间为：" + ((ContextStartEvent) event).getTimestamp());
		}
	}
}
