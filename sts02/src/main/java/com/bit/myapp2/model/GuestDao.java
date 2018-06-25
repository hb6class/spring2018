package com.bit.myapp2.model;

import java.sql.SQLException;
import java.util.List;

public interface GuestDao<T> {

	List<T> selectAll() throws SQLException;
	
	T selectOne(int pk) throws SQLException;
	
	int insertOne(T t) throws SQLException;
	
	int updateOne(T t) throws SQLException;
	
	int deleteOne(int pk) throws SQLException;
}
