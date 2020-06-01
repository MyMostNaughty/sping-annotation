package com.zixue.bean;

import org.springframework.beans.factory.FactoryBean;

// 创建一个spring定义的FactoryBean
public class ColorFactoryBean implements FactoryBean<Color>{

	/*
	 * 返回一个Color对象，这个对象会返回到容器中
	 */
	@Override
	public Color getObject() throws Exception {
		System.out.println("ColorFactoryBean.........getObject.......");
		return new Color();
	}

	// 返回对象的类型
	@Override
	public Class<?> getObjectType() {
		return Color.class;
	}
    
	/*
	 * 是单例？
	 * 如果返回true：这个bean是单实例，在容器中保存一份
	 *      false：这个bean是多实例，每次获取都会获取一个新的bean
	 */
	@Override
	public boolean isSingleton() {
		return false;
	}

	
}
