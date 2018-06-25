package com.bit.myapp03.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;

import com.bit.myapp03.model.entity.GuestVo;

public class GuestDaoImpl02 implements GuestDao {
	Logger log = Logger.getLogger(getClass());
	JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<GuestVo> selectAll() throws SQLException {
		String sql="SELECT * FROM GUEST ORDER BY SABUN DESC";
		return jdbcTemplate.query(sql, new RowMapper<GuestVo>() {

			@Override
			public GuestVo mapRow(ResultSet rs, int rowNum) throws SQLException {
				GuestVo bean = new GuestVo();
				bean.setSabun(rs.getInt("sabun"));
				bean.setName(rs.getString("name"));
				bean.setNalja(rs.getDate("nalja"));
				bean.setPay(rs.getInt("pay"));
				log.debug(rowNum+"¹øÂ°:"+bean);
				return bean;
			}});
	}

	@Override
	public GuestVo selectOne(int sabun) throws SQLException {
		String sql="SELECT * FROM GUEST WHERE SABUN=?";
		return jdbcTemplate.queryForObject(sql
				, new Object[] {sabun}, new RowMapper<GuestVo>() {

					@Override
					public GuestVo mapRow(ResultSet rs, int rowNum) throws SQLException {
						GuestVo bean = new GuestVo();
						bean.setSabun(rs.getInt("sabun"));
						bean.setName(rs.getString("name"));
						bean.setNalja(rs.getDate("nalja"));
						bean.setPay(rs.getInt("pay"));
						log.debug(rowNum==1);
						log.debug(bean);
						return bean;
					}});
	}

	@Override
	public int insertOne(final GuestVo bean) throws SQLException {
		final String sql="INSERT INTO GUEST VALUES (?,?,SYSDATE,?)";
		return jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, bean.getSabun());
				pstmt.setString(2, bean.getName());
				pstmt.setInt(3, bean.getPay());
				return pstmt;
			}
		});
	}

	@Override
	public int updateOne(final GuestVo bean) throws SQLException {
		final String sql="UPDATE GUEST SET NAME=?,PAY=? WHERE SABUN=?";
		return jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, bean.getName());
				pstmt.setInt(2, bean.getPay());
				pstmt.setInt(3, bean.getSabun());
				return pstmt;
			}
		});
	}

	@Override
	public int deleteOne(final int sabun) throws SQLException {
		final String sql="DELETE FROM GUEST WHERE SABUN=?";
		
		return jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, sabun);
				return pstmt;
			}
		});
	}

}
