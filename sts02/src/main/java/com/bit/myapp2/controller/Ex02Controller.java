package com.bit.myapp2.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/guest3")
public class Ex02Controller {
	
	@RequestMapping("/lec01")
	public String ex01() {
		return "ex10";
	}
	@RequestMapping("/lec02")
	public String ex03(String id, HttpSession session, String pw) {
		if(id.equals("admin") && pw.equals("1234")) {
			session.setAttribute("login", true);
		}
		return "ex11";
	}
	@RequestMapping("/lec03/{msg}")
	public String ex04(@PathVariable int msg,Model model){
		model.addAttribute("msg", msg+100);
		return "ex12";
	}
}
