package edu.zjnu.event.demo.listener;

import edu.zjnu.event.demo.event.AbstractContextEvent;
import edu.zjnu.event.demo.event.ContextStartEvent;

/**
 * @description: ContextDestroyEventListener
 * @author: 杨海波
 * @date: 2022-03-28 14:20
 **/
public class ContextDestroyEventListener implements ContextListener<AbstractContextEvent> {

	/**
	 * Handle an application event.
	 *
	 * @param event the event to respond to
	 */
	@Override
	public void onApplicationEvent(AbstractContextEvent event) {
//        ContextListener.super.onApplicationEvent(event);
		if (event instanceof ContextStartEvent) {
			System.out.println("容器销毁。。。，销毁时间为：" + ((ContextStartEvent) event).getTimestamp());
			System.out.println("事件源" + ((ContextStartEvent) event).getSource());
		}
	}
}
