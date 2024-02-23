package edu.zjnu.factory;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @author 杨海波
 * @date 2024/1/29 11:21
 * @description MyBeanFactoryPostProcessor
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		BeanDefinition restaurantbd = beanFactory.getBeanDefinition("restaurant");
		MutablePropertyValues propertyValues = restaurantbd.getPropertyValues();
		propertyValues.add("welcome", "the modified welcome");
	}
}
