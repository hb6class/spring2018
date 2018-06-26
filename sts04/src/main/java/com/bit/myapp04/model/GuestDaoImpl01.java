package com.bit.myapp04.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.bit.myapp04.model.entity.GuestVo;

public class GuestDaoImpl01 implements GuestDao {
	JdbcTemplate jdbcTemplate;
	PlatformTransactionManager transactionManager;
	
	
//	public GuestDaoImpl01(PlatformTransactionManager transactionManager
//			,TransactionDefinition definition) {
//		transactionManager.getTransaction(definition);
//	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}

	
	RowMapper<GuestVo> rowMapper=new RowMapper<GuestVo>() {
		
		@Override
		public GuestVo mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new GuestVo(
					rs.getInt("sabun")
					,rs.getString("name")
					,rs.getDate("nalja")
					,rs.getInt("pay")
					);
		}
	};
	
	@Override
	public List<GuestVo> selectAll() throws SQLException {
		String sql="SELECT * FROM GUEST ORDER BY SABUN";
		return jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public GuestVo selectOne(int sabun) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/// 1000, 1000+111
	@Override
	public int insertOne(final GuestVo bean) throws SQLException {
		final String sql="INSERT INTO GUEST VALUES (?,?,SYSDATE,?)";
		
		TransactionDefinition definition=new DefaultTransactionDefinition();
		TransactionStatus status=transactionManager.getTransaction(definition);
		try {
			jdbcTemplate.update(new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, bean.getSabun());
					pstmt.setString(2, bean.getName());
					pstmt.setInt(3, bean.getPay());
					return pstmt;
				}
			});
			bean.setSabun(bean.getSabun()+333);
			jdbcTemplate.update(new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, bean.getSabun());
					pstmt.setString(2, bean.getName());
					pstmt.setInt(3, bean.getPay());
					return pstmt;
				}
			});
			transactionManager.commit(status);
		}catch (Exception e) {
			transactionManager.rollback(status);
		}
		return 0;
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
		
		
		// 생성자를 이용해 dataSource 주입
//		ptm=new DataSourceTransactionManager();
		
		TransactionDefinition definition=new DefaultTransactionDefinition();
		TransactionStatus status=transactionManager.getTransaction(definition);
		
		
		int result=jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, sabun);
				return pstmt;
			}
		});
		transactionManager.commit(status);
//		transactionManager.rollback(status);
		
		return result;
	}

}














