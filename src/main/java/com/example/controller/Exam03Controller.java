package com.example.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Form.exam03Form;

@Controller
@RequestMapping("/exam03")
public class Exam03Controller {
	
	@ModelAttribute
	public exam03Form setUpForm() {
		return new exam03Form();
	}

	@Autowired
	private ServletContext application;
	
	@RequestMapping("")
	public String index() {
		
		return "exam03";
		
	}
	
	@RequestMapping("/result")
	public String result(exam03Form form) {
		
		Integer total=form.getProduct1()+form.getProduct2()+form.getProduct3();
		
		Integer includeTax=(int)(total*1.1);
		
		application.setAttribute("total",total);
		application.setAttribute("includeTax", includeTax);
		
		return "exam03-result";
	}
	
	
}
