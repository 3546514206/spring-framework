package edu.zjnu.event.parent;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * @author: 杨海波
 * @date: 2022-12-16 09:28:36
 * @description: todo
 */
public class SpringEventListener implements ApplicationListener<ContextRefreshedEvent> {
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		System.out.println("容器刷新事件已被监听：" + event.getApplicationContext().getId());
	}
}
