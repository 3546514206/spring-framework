package edu.zjnu.event.demo;

import edu.zjnu.event.demo.caster.ApplicationEventMulticaster;
import edu.zjnu.event.demo.caster.SimpleApplicationEventMulticaster;
import edu.zjnu.event.demo.event.ContextDestroyEvent;
import edu.zjnu.event.demo.event.ContextRunningEvent;
import edu.zjnu.event.demo.event.ContextStartEvent;
import edu.zjnu.event.demo.listener.ContextDestroyEventListener;
import edu.zjnu.event.demo.listener.ContextRunningEventListener;
import edu.zjnu.event.demo.listener.ContextStartEventListener;

/**
 * @description: App
 * @author: 杨海波
 * @date: 2022-03-28 14:34
 **/
public class DemoListenerApp {

	public static void main(String[] args) {
		new DemoListenerApp().testContextLifecycleEventInSync();
	}

	public void testContextLifecycleEventInSync() {
		// 新建SimpleApplicationEventMulticaster对象，并添加容器生命周期监听器
		ApplicationEventMulticaster eventMulticaster = new SimpleApplicationEventMulticaster();
		eventMulticaster.addContextListener(new ContextStartEventListener());
		eventMulticaster.addContextListener(new ContextRunningEventListener());
		eventMulticaster.addContextListener(new ContextDestroyEventListener());
		// 发射容器启动事件ContextStartEvent
		eventMulticaster.multicastEvent(new ContextStartEvent(this));
		// 发射容器正在运行事件ContextRunningEvent
		eventMulticaster.multicastEvent(new ContextRunningEvent(this));
		// 发射容器正在运行事件ContextDestroyEvent
		eventMulticaster.multicastEvent(new ContextDestroyEvent(this));
	}

	public void testContextLifecycleEventInAsync() {
		// 新建SimpleApplicationEventMulticaster对象，并添加容器生命周期监听器
		ApplicationEventMulticaster eventMulticaster = new SimpleApplicationEventMulticaster();
		eventMulticaster.addContextListener(new ContextStartEventListener());
		eventMulticaster.addContextListener(new ContextRunningEventListener());
		eventMulticaster.addContextListener(new ContextDestroyEventListener());

		((SimpleApplicationEventMulticaster) eventMulticaster).setAsync(true);

		// 发布容器启动事件ContextStartEvent
		eventMulticaster.multicastEvent(new ContextStartEvent(this));
		// 发布容器正在运行事件ContextRunningEvent
		eventMulticaster.multicastEvent(new ContextRunningEvent(this));
		// 发布容器正在运行事件ContextDestroyEvent
		eventMulticaster.multicastEvent(new ContextDestroyEvent(this));
	}
}
