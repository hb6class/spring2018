package com.bit.myApp.model;

import java.sql.SQLException;
import java.util.List;

import com.bit.myApp.model.entity.GuestVo;

public interface GuestDao {

	public List<GuestVo> selectAll() throws SQLException;

	public void insertOne(GuestVo bean) throws SQLException;
}
