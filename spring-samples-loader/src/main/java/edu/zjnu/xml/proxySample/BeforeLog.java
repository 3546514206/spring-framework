package edu.zjnu.xml.proxySample;


import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author: 杨海波
 * @date: 2022-12-14 19:21:02
 * @description: todo
 */
public class BeforeLog implements MethodBeforeAdvice {

	private void beforeLog() {
		System.out.println("before log!");
	}

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		beforeLog();
	}
}
