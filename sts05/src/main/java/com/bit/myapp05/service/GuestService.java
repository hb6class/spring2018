package com.bit.myapp05.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.bit.myapp05.model.GuestDao;
import com.bit.myapp05.model.entity.GuestVo;


@Service
public class GuestService {
	@Autowired
	GuestDao guestDao;
	
	public void listPage(Model model) throws SQLException {
		model.addAttribute("alist", guestDao.selectAll());
		model.addAttribute("total", guestDao.selectTotal());
	}

	public void addPage(GuestVo bean) throws SQLException {
		guestDao.insertOne(bean);
	}
	
	public void deletePage(int sabun) throws SQLException {
		guestDao.deleteOne(sabun);
		
	}
	
	public void updatePage(GuestVo bean) throws SQLException {
		guestDao.updateOne(bean);
	}
}














