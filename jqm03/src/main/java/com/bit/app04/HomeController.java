package com.bit.app04;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.xml.ws.RequestWrapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bit.app04.model.entity.GuestVo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	List<GuestVo> list = new ArrayList<GuestVo>();
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		list.add(new GuestVo(
				1111,
				"test1",
				new Date(),
				1000
				));
		list.add(new GuestVo(
				2222,
				"test2",
				new Date(),
				2000
				));
		return "index";
	}
	
	@RequestMapping("/list.json")
	public String list(Model model) {
		model.addAttribute("alist", list);
		return "list";
	}
	@RequestMapping("/test")
	public @ResponseBody String test() {
		return "test";
	}
	
	
}









