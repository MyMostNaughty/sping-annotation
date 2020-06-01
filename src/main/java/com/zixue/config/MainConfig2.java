package com.zixue.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;

import com.zixue.bean.Color;
import com.zixue.bean.ColorFactoryBean;
import com.zixue.bean.Person;
import com.zixue.bean.Red;
import com.zixue.condition.LinuxCondition;
import com.zixue.condition.MyImportSelector;
import com.zixue.condition.WindowsCondition;

//类中组件同意设置，表示当前类满足WindowsCondition.class中条件判断，类中的bean才会被注册到ioc容器中
@Conditional({WindowsCondition.class})
@Configuration
@Import({Color.class,Red.class,MyImportSelector.class,MyImportBeanDefinitionRegistrar.class})
//@Import导入组件，id默认是组件的全类名
public class MainConfig2 {

//	@Scope("prototype")
	/*
	 * ConfigurableBeanFactory.SCOPE_PROTOTYPE    prototype
	 * ConfigurableBeanFactory.SCOPE_SINGLETON    singleton
	 * org.springframework.web.context.WebApplicationContext.SCOPE_REQUEST    request(不会用到)
	 * org.springframework.web.context.WebApplicationContext.SCOPE_SESSION    session(不会用到)
	 * @Scope  使用它可以调整作用域
	 * prototype：多实例的                       ioc容器启动并不会调用方法创建对象，而是每次获取的时候才会创建对象，
	 *                          并且每次都会创建一个新的对象。
	 * singleton：单实例的（默认值）  ioc容器启动时会调用方法创建对象并放到ioc容器中。
	 *                         以后每次获取直接从容器（map.get()）中拿。
	 * request：同一次请求创建一个实例
	 * session：同一个session创建一个实例
	 * 
	 * 懒加载：@Lazy （只针对单实例，多实例本身就是使用（获取）Bean才创建对象）
	 *       单实例bean：默认在容器启动时候创建实例对象；
	 *       懒加载：容器启动不创建对象，第一次使用（获取）Bean创建对象，并初始化；
	 * 
	 */
	@Lazy
	@Bean("person")
	public Person person(){
		System.out.println("给容器中添加一个Person..........");
		return new Person("张三",25);
	}
	
	/**
	 * @Conditional({Condition}): 按照一定的条件进行判断，满足条件 才给容器中注册bean（Spring4中才有这个注解，并大量使用）
	 * 
	 * 如果系统是windows，给容器中注册("Bill")
	 * 如果系统是linus,给容器中注册("linus")
	 */
	@Conditional({WindowsCondition.class})
	@Bean("Bill")
	public Person person01(){
		return new Person("Bill Gates", 62);
	}
	@Conditional({LinuxCondition.class})
	@Bean("linus")
	public Person person02(){
		return new Person("linus",48);
	}
	
	/**
	 * 给容器中注册组件：
	 * 1）、包扫描+组件标注注解（@Controller/@Service/@Repository/@Component）[自己写的类]
	 * 2）、@Bean[导入的第三方包里面的组件]
	 * 3）、@Import[快速给容器中导入一个组件]
	 *           1）、@Import(要导入的到容器中的组件)；容器中就会自动注册这个组件，id默认是全类名
	 *           2）、ImportSelector：返回需要导入的组件的全类名数组；(见MyImportSelector类中写法) ★★ 在SpringBoot这个用的非常多
	 *           3）、ImportBeanDefinitionRegistrar：手动注册bean到容器中（见MyImportBeanDefinitionRegistrar类）
	 * 4）、使用Spring提供的 FactoryBean（工厂Bean）; ★★ spring与其他框架整合时，这个用的特别多
	 *           1）、默认获取得到的是 工厂bean调用getObject()创建的对象。
	 *           2）、要获取工厂bean本身，我们在使用applicationContext.getBean("&colorFactoryBean");给id前加上&符号（在源码BeanFactory中又定义&），就会获得工厂本身
	 */
	@Bean
	public ColorFactoryBean colorFactoryBean(){
		return new ColorFactoryBean();
	}
	
}
