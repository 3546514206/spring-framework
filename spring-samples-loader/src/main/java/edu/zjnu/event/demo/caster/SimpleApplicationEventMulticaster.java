package edu.zjnu.event.demo.caster;

import edu.zjnu.event.demo.event.AbstractContextEvent;
import edu.zjnu.event.demo.listener.ContextListener;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @description: SimpleApplicationEventMulticaster
 * @author: 杨海波
 * @date: 2022-03-28 14:27
 **/
public class SimpleApplicationEventMulticaster implements ApplicationEventMulticaster {

	/**
	 * 线程池
	 */
	private final Executor taskExecutor = new ThreadPoolExecutor(
			5,
			5,
			0,
			TimeUnit.SECONDS,
			new LinkedBlockingQueue<>());
	/**
	 * 事件监听器列表
	 */
	private final List<ContextListener<AbstractContextEvent>> contextListeners = new ArrayList<>();
	// 是否异步发布事件
	private boolean async = false;

	@Override
	public void addContextListener(ContextListener<AbstractContextEvent> listener) {
		contextListeners.add(listener);
	}

	@Override
	public void removeContextListener(ContextListener<AbstractContextEvent> listener) {
		contextListeners.remove(listener);
	}

	@Override
	public void removeAllListeners() {
		contextListeners.clear();
	}

	@Override
	public void multicastEvent(AbstractContextEvent event) {
		doMulticastEvent(contextListeners, event);
	}

	private void doMulticastEvent(List<ContextListener<AbstractContextEvent>> contextListeners, AbstractContextEvent event) {
		for (ContextListener<AbstractContextEvent> contextListener : contextListeners) {
			// 异步广播事件
			if (async) {
				taskExecutor.execute(() -> invokeListener(contextListener, event));
				// new Thread(() -> invokeListener(contextListener, event)).start();
			} else {
				// 同步发布事件，阻塞的方式
				invokeListener(contextListener, event);
			}
		}
	}

	private void invokeListener(ContextListener<AbstractContextEvent> contextListener, AbstractContextEvent event) {
		contextListener.onApplicationEvent(event);
	}

	public void setAsync(boolean async) {
		this.async = async;
	}
}
