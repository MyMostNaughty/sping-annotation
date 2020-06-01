package com.zixue.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/*
 * 后置处理器：初始化前后进行处理工作
 * 将后置处理器加到ioc容器中，这样spring就能让它工作
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor{

	/**
	 * bean：容器中bean创建 还没初始化实例对象
	 * beanName：这个实例的名字
	 */
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("postProcessBeforeInitialization...."+beanName+"====>>"+bean);
		return bean;
	}
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("postProcessAfterInitialization...."+beanName+"====>>"+bean);
		return bean;
	}

	

}
