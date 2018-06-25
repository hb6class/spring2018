package com.bit.myapp03.controller;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bit.myapp03.model.GuestDao;
import com.bit.myapp03.model.entity.GuestVo;

@Controller
public class AddController {
	Logger log = Logger.getLogger(getClass());
	
	@Autowired
	GuestDao guestDao;

	@RequestMapping("/guest/add")
	public String addForm(Model model) {
		model.addAttribute("path", "myapp03");
		return "add";
	}
	@RequestMapping(value="/guest/",method=RequestMethod.POST)
	public String add(GuestVo bean) throws SQLException {
		log.debug("param:"+bean);
		guestDao.insertOne(bean);
		return "redirect:./";
	}
	
	
}





