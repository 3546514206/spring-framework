package edu.zjnu.xml.proxySample;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @author: 杨海波
 * @date: 2022-12-14 19:22:01
 * @description: todo
 */
public class AfterLog implements AfterReturningAdvice {

	private void afterLog() {
		System.out.println("after log!");
	}

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		afterLog();
	}
}
