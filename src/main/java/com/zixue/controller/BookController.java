package com.zixue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.zixue.Service.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;
}
