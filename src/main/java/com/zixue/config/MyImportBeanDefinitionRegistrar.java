package com.zixue.config;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import com.zixue.bean.RainBow;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

	/**
	 * AnnotationMetadata:当前类的注解信息，以及当前类的其他信息都能获得
	 * BeanDefinitionRegistry: BeanDefinition注册类；
	 * 		把有需要添加到容器中的bean写在下面方法中：调用
	 *                  BeanDefinitionRegistry.registerBeanDefinition进行手动注册
	 */
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		boolean definition = registry.containsBeanDefinition("com.zixue.bean.Red");
		boolean definition2 = registry.containsBeanDefinition("com.zixue.bean.Blue");
		if(definition&&definition2){
			// 下面方法第二个参数是一个BeanDefintion接口参数，指定Bean定义信息；（Bean的类型，Bean作用域等等都可以定义）
			RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(RainBow.class);
			
			// 往ioc容器注册一个Bean,并指定bean名称
			registry.registerBeanDefinition("rainBow", rootBeanDefinition);
		}
	}

}
