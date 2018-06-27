package com.bit.myapp06;

import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bit.myapp06.model.GuestDao;
import com.bit.myapp06.model.entity.GuestVo;

@Controller
public class HomeController {
	@Autowired
	SqlSession sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "home";
	}
	
	@RequestMapping("/list")
	public void list(Model model) throws SQLException {
		model.addAttribute("alist"
				, sqlSession.getMapper(GuestDao.class).selectAll());
	}
	
	@RequestMapping("/detail")
	public void detail(@RequestParam("idx") int sabun,Model model) throws SQLException{
		model.addAttribute("bean"
				, sqlSession.getMapper(GuestDao.class).selectOne(sabun));
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String edit(@ModelAttribute GuestVo bean) throws SQLException {
		sqlSession.getMapper(GuestDao.class).updateOne(bean);
		return "redirect:/detail?idx="+bean.getSabun();
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String del(int idx) throws SQLException {
		sqlSession.getMapper(GuestDao.class).deleteOne(idx);
		return "redirect:/list";
	}
}













