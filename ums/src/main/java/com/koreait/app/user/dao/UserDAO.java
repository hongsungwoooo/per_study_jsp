package com.koreait.app.user.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.koreait.app.mybatis.SqlMapConfig;

public class UserDAO {
	SqlSessionFactory factory = SqlMapConfig.getFactory();
	SqlSession sqlsession;
	
	public UserDAO() {
		sqlsession = factory.openSession(true);
	}

	public boolean join(UserDTO udto) {
		boolean result = false;
		if( sqlsession.insert("User.join",udto) != 0) {
			result = true;
		}
		return result;
	}
	
	
	
}













