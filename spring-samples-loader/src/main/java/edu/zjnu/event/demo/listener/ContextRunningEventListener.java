package edu.zjnu.event.demo.listener;

import edu.zjnu.event.demo.event.AbstractContextEvent;
import edu.zjnu.event.demo.event.ContextRunningEvent;

/**
 * @description: ContextRunningEventListener
 * @author: 杨海波
 * @date: 2022-03-28 14:19
 **/
public class ContextRunningEventListener implements ContextListener<AbstractContextEvent> {

	/**
	 * Handle an application event.
	 *
	 * @param event the event to respond to
	 */
	@Override
	public void onApplicationEvent(AbstractContextEvent event) {
//        ContextListener.super.onApplicationEvent(event);
		if (event instanceof ContextRunningEvent) {
			System.out.println("容器开始运行。。。");
			try {
				Thread.sleep(3000);
				System.out.println("容器运行结束。。。");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
