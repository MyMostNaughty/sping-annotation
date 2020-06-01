package com.zixue.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.zixue.bean.Car;

/**
 * bean的生命周期；
 *      bean创建----初始化-----销毁的过程
 * 容器管理bean的生命周期
 * 我们可以自定义初始化和销毁方法；容器在bean进行到当前生命周期的时候来调用我们自定义的初始化和销毁方法；
 * 
 * 构造（对象创建）
 *      单实例：在容器启动的时候创建对象
 *      多实例：在每次获取时候创建对象
 * 
 * BeanPostProcessor.postProcessBeforeInitialization
 * 初始化：
 *      对象创建完成，并赋值好，调用初始化方法。。。
 * BeanPostProcessor.postProcessAfterInitialization
 * 
 * 销毁：
 *      单实例bean：容器关闭的时候，进行销毁
 *      多实例bean：容器不会管理这个bean，容器不会调用销毁方法，可以手动调用销毁方法
 * 
 * 遍历得到容器中所有的BeanPostProcessor：挨个执行beforeInitialization,
 * 一但返回null，跳出for循环，不会执行后面的BeanPostProcessor.PostProcessorsBeforeInitialization
 * BeanPostProcessor原理：
 * populateBean(beanName, mbd, instanceWrapper);先给bean进行属性赋值
 * initializeBean {
 *   applyBeanPostProcessorsBeforeInitialization(wrappedBean, beanName);初始化前调用
 *   invokeInitMethods(beanName,wrappedBean,mbd);执行自定义初始化方法
 *   applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);初始化后调用
 * }
 * 
 * 
 * 1）、指定初始化和销毁方法
 *      通过@Bean指定init-method=""  destory-method=""
 *      
 * 2）、通过让Bean实现InitializingBean（定义初始化逻辑），
 *             实现DisposableBean（定义销毁逻辑，针对单实例对象）
 * 
 * 3）、可以使用JSR250规范里面的两个注解：
 *      @PostConstruct：作用在bean创建完成，并且属性赋值完成时，执行被注解方法（这个注解只能放在方法上）。
 *      @PreDestroy：在bean被容器移除前，会执行被此注解标注的方法，用于销毁前调用（这个注解只能放在方法上）
 *      
 * 4）、BeanPostProcessor（接口）：bean的后置处理器（spring提供）  （见：MyBeanPostProcessor类）
 *      在bean初始化前后进行一些处理工作，里面有两个抽象方法,  ★(不管有没有定义初始化方法都会调用，包括sping自己的类)
 *      postProcessBeforeInitialization：在初始化调用之前
 *      postProcessAfterInitialization：在初始化方法调用之后
 *      
 * Spring底层对 BeanPostProcessor（大量使用，很多注解都有专门的BeanPostProcessor实现类提取工作），具体使用 ：
 *           bean赋值，注入其他组件，@Autowired,生命周期注解功能，@Async,xxx BeanPostProcessor; 
 *    
 */
@ComponentScan("com.zixue.bean")
@Configuration
public class MainConfigOfLifeCycle {
	
//	@Scope("prototype")
	@Bean(initMethod="init",destroyMethod="destory")
	public Car car(){
		return new Car();
	}
	
}
