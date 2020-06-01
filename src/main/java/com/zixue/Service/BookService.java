package com.zixue.Service;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.zixue.dao.BookDao;

@Service
public class BookService {
	
//	@Qualifier("bookDao")
//	@Autowired(required=false)
//	@Resource(name="bookDao")
	@Inject
	private BookDao bookDao;
	
	private void print(){
		System.out.println(bookDao);
	}

	@Override
	public String toString() {
		return "BookService [bookDao=" + bookDao + "]";
	}
	
	
}
