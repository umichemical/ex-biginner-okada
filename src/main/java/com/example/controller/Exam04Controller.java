package com.example.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.Form.UserForm;
import com.example.domain.User;

@Controller
@RequestMapping("/exam04")
public class Exam04Controller {

	@ModelAttribute
	public UserForm setUpForm() {
		return new UserForm();
	}
	
	@RequestMapping("")
	public String index() {
		return "exam04";
	}
	
	@RequestMapping("/result")
	public String result(@Validated UserForm userForm
		,BindingResult result
		,RedirectAttributes redirectAttributes
		,Model model
		) {
		
		if(result.hasErrors()) {
			
			return "exam04";
		}
		User user=new User();
		
		BeanUtils.copyProperties(userForm, user);
		
		redirectAttributes.addFlashAttribute("user",user);
				
		return "redirect:/exam04/result2";
	}
	
	@RequestMapping("/result2")
	public String result2() {
		
		return "exam04-result";
	}
	
	
}
