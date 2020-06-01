package com.zixue.config;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

public class MyTypeFilter implements TypeFilter {

	/*
	 * metadataReader:读取到的当前正在扫描类的信息
	 * metadataReaderFactory: 可以获取到其他任何类的信息
	 * 
	 * 返回false就不会将类加载到IOC容器中
	 */
	@Override
	public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
		// 获取当前类注解的信息
		AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
//		System.out.println(annotationMetadata);
//		System.out.println("===========================================================");
		
		// 获取当前正在扫描的类的类的信息（比如它的类型，它的实现接口等）
		ClassMetadata classMetadata = metadataReader.getClassMetadata();
		String className = classMetadata.getClassName();
		System.out.println(className);
		// 模拟：如果当前扫描类包含er就放入IOC容器中
		if(className.contains("er")){
			return true;
		}
		
		// 获取当前类的资源信息（类的路径，磁盘路径-class文件）
		Resource resource = metadataReader.getResource();
//		System.out.println(resource);
		return false;
	}

}
