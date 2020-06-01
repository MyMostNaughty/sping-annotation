package com.zixue.dao;

import org.springframework.stereotype.Repository;

//BookDao注入到ioc容器中id名字默认是类名首字母小写
@Repository
public class BookDao {

	private String lable="1";

	public String getLable() {
		return lable;
	}

	public void setLable(String lable) {
		this.lable = lable;
	}

	@Override
	public String toString() {
		return "BookDao [lable=" + lable + "]";
	}
	
}
