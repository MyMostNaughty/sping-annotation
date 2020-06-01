package com.zixue.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.ComponentScans;

import com.zixue.Service.BookService;
import com.zixue.bean.Person;

// 配置类就==以前的配置文件
@Configuration   // 告诉Spring这是一个配置类

@ComponentScans(
		value={
				@ComponentScan(value="com.zixue",
//		 	   			excludeFilters={
//		    		    		@Filter(type=FilterType.ANNOTATION,classes={Controller.class})}// 排除：将@Controller注解的类排除
						includeFilters={
//								@Filter(type=FilterType.ANNOTATION,classes={Controller.class}),  
//								@Filter(type=FilterType.ASSIGNABLE_TYPE,classes={BookService.class}),
								@Filter(type=FilterType.CUSTOM,classes={MyTypeFilter.class})
								},useDefaultFilters=false  // 只包含：Controller.class(按注解规则)，BookService.class(按类型)。一定要配置useDefaultFilters=false（禁用掉默认的扫描规则（默认规则扫描所有的））才能生效
				) 
})
// @ComponentScan 配置扫描，value="com.zixue"配置要扫描的包
// excludeFilters：Filter[] excludeFilters() default {};     指定扫描的时候按照哪些规则排除哪些组件
// includeFilters：Filter[] includeFilters() default {};  相反 指定扫描的时候按照哪些规则只要那些组件
// FilterType.ANNOTATION: 按照注解  
// FilterType.ASSIGNABLE_TYPE: 按照给定的类型
// FilterType.ASPECTJ: 使用ASPECTJ表达式 （不常用）
// FilterType.REGEX：使用正则表达式
// FilterType.CUSTOM: 使用自定义规则 （可以自定义规则，自定义规则必须包含TypeFilter实现类）
public class MainConfig {
	
	// 给容器中注册一个bean，类型自然就是返回值的类型，id默认用方法名作为id
	@Bean("person") // 1.方法名默认为Person类在ioc容器中id值，也可以在@bean(设置id值)
	public Person person01(){
		return new Person("李四",20);
	}

}
