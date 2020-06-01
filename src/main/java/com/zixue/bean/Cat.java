package com.zixue.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class Cat implements InitializingBean,DisposableBean{
	
	public Cat(){
		System.out.println("Cat.....constructor.......");
	}

	// 在bean创建完成，并且初始化后，调用
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Cat........afterPropertiesSet..........");
	}
	
	// 在容器关闭时调用销毁方法（只针对单实例对象）
	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Cat.......destory..........");
	}


}
