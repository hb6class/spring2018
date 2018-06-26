package com.bit.myapp04;

import java.io.OutputStream;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bit.myapp04.model.GuestDao;
import com.bit.myapp04.model.entity.GuestVo;

@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	GuestDao guestDao;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	@RequestMapping(value="/guest/",method =RequestMethod.GET)
	public String list(Model model) throws SQLException {
		model.addAttribute("alist", guestDao.selectAll());
		return "list";
	}
	@RequestMapping(value="/guest/{sabun}",method =RequestMethod.GET)
	public String detail(Model model,@PathVariable int sabun) throws SQLException {
		model.addAttribute("sabun", sabun);
		return list(model);
	}
	@RequestMapping(value="/guest/",method =RequestMethod.POST)
	public String add(@ModelAttribute GuestVo bean) throws SQLException {
		guestDao.insertOne(bean);
		return "redirect:/guest/";
	}
	@RequestMapping(value="/guest/{sabun}",method = RequestMethod.PUT)
	public String edit(@PathVariable int sabun,@ModelAttribute GuestVo bean) throws SQLException {
		guestDao.updateOne(bean);
		return "redirect:/guest/"+sabun;
	}

	@RequestMapping(value="/guest/{sabun}", method =RequestMethod.DELETE)
	public String delete(@PathVariable int sabun) throws SQLException {
		guestDao.deleteOne(sabun);
		return "redirect:/guest/";
	}
}












	
