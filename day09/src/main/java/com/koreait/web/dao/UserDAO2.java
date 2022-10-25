package com.koreait.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.koreait.web.beans.UserBean;

public class UserDAO2 {
	
	Context context;
	DataSource dataSource;
	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;
	
	public boolean join( UserBean user ) {
		boolean result = false;
		
		// INSERT INTO TBL_USER VALUES('test', '1234', 'user1','M','01012345678')
		String sql = "INSERT INTO TBL_USER VALUES(?, ?, ?, ?, ?)";
		int cnt = 0;
		
		try {
			//conn = DBConnection.getConnection();
			
			context = new InitialContext(null);
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
			conn = dataSource.getConnection();
			
			pstm = conn.prepareStatement(sql);
			
			// param값 setting
			pstm.setString(1, user.getUserid());	
			pstm.setString(2, user.getUserpw());
			pstm.setString(3, user.getUsername());
			pstm.setString(4, user.getUsergender());
			pstm.setString(5, user.getUserphone());
			
			cnt = pstm.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		if( cnt != 0 ) {
			// 성공
			result = true;
		} else {
			// 실패
			result = false;
		}
		
		return result;
	}
	
	
	public UserBean login( String userid, String userpw ) {
		UserBean user = null;
		
		String sql = "SELECT * FROM TBL_USER tu  WHERE USERID = ? AND userpw = ?";
		
		try {
//			conn = DBConnection.getConnection();
			
//			context = new InitialContext(null);
//			DataSource dataSource = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
//			conn = dataSource.getConnection();
			
			conn = ((DataSource)new InitialContext(null).lookup("java:comp/env/jdbc/oracle")).getConnection();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, userid);
			pstm.setString(2, userpw);
			
			rs = pstm.executeQuery();
			
			if( rs.next() ) {
				user = new UserBean();
				user.setUserid(rs.getString(1));
				user.setUserpw(rs.getString(2));
				user.setUsername(rs.getString(3));
				user.setUsergender(rs.getString(4));
				user.setUserphone(rs.getString(5));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return user;
		
	}
	
	
//	public boolean login( String userid, String userpw ) {
//		boolean flag = false;
//		
//		String sql = "SELECT * FROM TBL_USER tu  WHERE USERID = ? AND userpw = ?";
//		
//		try {
//			conn = DBConnection.getConnection();
//			pstm = conn.prepareStatement(sql);
//			
//			pstm.setString(1, userid);
//			pstm.setString(2, userpw);
//			
//			rs = pstm.executeQuery();
//			
//			if(rs.next()) {
//				flag = true;
//			}
//			
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		return flag;
//	}
	
	
	public boolean checkId( String userid ) {
		boolean result = false;
		
		String sql = "SELECT count(*) FROM TBL_USER tu  WHERE USERID = ?";
		
		try {
//			conn = DBConnection.getConnection();
			
			conn = ((DataSource)new InitialContext(null).lookup("java:comp/env/jdbc/oracle")).getConnection();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, userid);
			rs = pstm.executeQuery();
			
			if( rs.next() ) {
				if( rs.getInt(1) == 1 ) {
					result = true;
				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
}































