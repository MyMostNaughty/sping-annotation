package com.zixue.test;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.zixue.Service.BookService;
import com.zixue.bean.Boss;
import com.zixue.bean.Car;
import com.zixue.bean.Color;
import com.zixue.bean.Yellow;
import com.zixue.config.MainConfigOfAutowired;
import com.zixue.config.MainConfigOfProfile;
import com.zixue.dao.BookDao;

public class IOCTest_Profile {

	//1、 使用命令行动态参数,在虚拟机参数位置加载 -Dspring.profiles.active=test  ====》》test01
	//2、代码的方式激活某种环境；=======》》test02
	
	@Test
	public void test02(){
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		//1、 创建一个applicationContext
		//2、设置需要激活的环境
//		applicationContext.getEnvironment().setActiveProfiles("test","dev");
		applicationContext.getEnvironment().setActiveProfiles("test");
		//3、注册配置类
		applicationContext.register(MainConfigOfProfile.class);
		//4.启动刷新容器
		applicationContext.refresh();
		String[] beanNamesForType = applicationContext.getBeanNamesForType(DataSource.class);
		for (String string : beanNamesForType) {
			System.out.println(string);
		}
		
		Yellow yellow = applicationContext.getBean(Yellow.class);
		System.out.println(yellow);
		
		applicationContext.close();
	}
	@Test
	public void test01(){
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfProfile.class);
		
		String[] beanNamesForType = applicationContext.getBeanNamesForType(DataSource.class);
		for (String string : beanNamesForType) {
			System.out.println(string);
		}
		
		applicationContext.close();
	}
	
}
