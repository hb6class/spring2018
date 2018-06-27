package com.bit.myapp05.controller;

import java.sql.SQLException;
import java.util.Locale;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bit.myapp05.model.GuestDao;
import com.bit.myapp05.model.entity.GuestVo;
import com.bit.myapp05.service.GuestService;

@Controller
public class MainController {
	@Autowired
	GuestService service;
	
	String view="redirect:/guest/";
	
	public void setService(GuestService service) {
		this.service = service;
	}

	@RequestMapping("/")
	public String test() throws SQLException {
		return "home";
	}
	@RequestMapping(value="/guest/",method=RequestMethod.GET)
	public String list(Model model) throws SQLException {
		service.listPage(model);
		return "list";
	}
	@RequestMapping(value="/guest/",method=RequestMethod.POST)
	public String add(@ModelAttribute GuestVo bean, String name) throws SQLException {
		System.out.println(bean.getName());
		System.out.println(name);
		service.addPage(bean);
		return view;
	}
	@RequestMapping(value="/guest/{sabun}",method=RequestMethod.DELETE)
	public String del(@PathVariable int sabun) throws SQLException {
		service.deletePage(sabun);
		return view;
	}
	@RequestMapping(value="/guest/{sabun}", method=RequestMethod.PUT)
	public String edit(@PathVariable int sabun
			, @ModelAttribute GuestVo bean,Model model) throws SQLException {
		service.updatePage(bean);
		model.addAttribute("sabun", sabun);
		return view;
	}
}
