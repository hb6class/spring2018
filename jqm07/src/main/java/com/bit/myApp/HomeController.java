package com.bit.myApp;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bit.myApp.model.GuestDao;
import com.bit.myApp.model.entity.GuestVo;
@Controller
public class HomeController {
	@Autowired
	SqlSession sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		
		return "home";
	}
	
	
	//@CrossOrigin(origins = "http://203.236.209.193:3000")
	@RequestMapping("/list.json")
	public String list(Model model,HttpServletResponse resp) throws SQLException {
		GuestDao dao = sqlSession.getMapper(GuestDao.class);
		List<GuestVo> list = dao.selectAll();
		for(GuestVo bean : list) {
			logger.debug(bean.toString());
		}
		model.addAttribute("alist", list);
		resp.setHeader("Access-Control-Allow-Origin","*");
		resp.setHeader("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE");
		resp.setHeader("Access-Control-Allow-Credentials", "true");
		resp.setContentType("application/json; charset=UTF-8");
		return "list";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(@ModelAttribute GuestVo bean,HttpServletResponse resp) throws SQLException {
		sqlSession.getMapper(GuestDao.class).insertOne(bean);
		resp.setHeader("Access-Control-Allow-Origin","*");
		resp.setHeader("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE");
		resp.setHeader("Access-Control-Allow-Credentials", "true");
		resp.setContentType("application/json; charset=UTF-8");
		return "list";
	}
	
}
















