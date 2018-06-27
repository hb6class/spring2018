package com.bit.myapp05.model;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit.myapp05.model.entity.GuestVo;


@Repository
public class GuestDaoImpl01 implements GuestDao {
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<GuestVo> selectAll() throws SQLException {
		return sqlSession.selectList("guest.selectAll");
	}

	@Override
	public GuestVo selectOne(int sabun) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertOne(GuestVo bean) throws SQLException {
		sqlSession.insert("guest.insertOne",bean);
		return 0;
	}

	@Override
	public int updateOne(GuestVo bean) throws SQLException {
		// TODO Auto-generated method stub
		return sqlSession.update("guest.updateOne",bean);
	}

	@Override
	public int deleteOne(int sabun) throws SQLException {
		// TODO Auto-generated method stub
		return sqlSession.delete("guest.deleteOne",sabun);
	}

	@Override
	public int selectTotal() throws SQLException {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("guest.total");
	}

}
