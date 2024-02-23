package edu.zjnu.xml.beanPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author: 杨海波
 * @date: 2022-12-16 15:20:13
 * @description: todo
 */
public class LogPostProcessor implements BeanPostProcessor {


	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof Machine) {
			System.out.println("正在处理:" + beanName);
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof Machine) {
			System.out.println("已经处理完成:" + beanName);
		}
		return bean;
	}

}
