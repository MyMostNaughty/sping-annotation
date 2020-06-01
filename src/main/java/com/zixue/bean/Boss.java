package com.zixue.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//默认加载ioc容器中的组件，容器启动会调用无参构造器创建对象，在进行初始化赋值等操作
@Component
public class Boss {
//	@Autowired 
	private Car car;
	
//	public Boss(){
//		System.out.println("Boss....无参构造器");
//	}
	
	// 构造器要用的组件，都是从容器中获取
//	@Autowired 
	public Boss(Car car){//如果组件只有一个有参构造器，这个有参构造器的@Autowired可以省略，参数位置的组件还是可以自动从容器中获取（还是可以自动注入）
//	public Boss(@Autowired Car car){  // 标在有参构造器方法里面时，当前类必须没有无参构造器。否则调用的是无参构造器，并且结构car==null，没有注入进来
		this.car=car;
		System.out.println("Boss....有参构造器");
	}
	

	public Car getCar() {
		return car;
	}
	
//	@Autowired 
	//标注在方法Spring容器创建当前对象时，就会调用方法，完成赋值；
	//方法使用的参数，自定义类型的值从ioc容器中获取
//	public void setCar(@Autowired Car car) {
		public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public String toString() {
		return "Boss [car=" + car + "]";
	}
	
}
