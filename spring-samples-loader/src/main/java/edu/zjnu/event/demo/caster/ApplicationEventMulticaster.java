package edu.zjnu.event.demo.caster;

import edu.zjnu.event.demo.event.AbstractContextEvent;
import edu.zjnu.event.demo.listener.ContextListener;

/**
 * @description: ApplicationEventMulticaster
 * @author: 杨海波
 * @date: 2022-03-28 14:23
 **/
public interface ApplicationEventMulticaster {

	/**
	 * 添加监听器
	 *
	 * @param listener
	 */
	void addContextListener(ContextListener<AbstractContextEvent> listener);

	/**
	 * 删除监听器
	 *
	 * @param listener
	 */
	void removeContextListener(ContextListener<AbstractContextEvent> listener);

	/**
	 * 删除所有监听器
	 */
	void removeAllListeners();

	/**
	 * 事件分发
	 *
	 * @param event
	 */
	void multicastEvent(AbstractContextEvent event);
}
