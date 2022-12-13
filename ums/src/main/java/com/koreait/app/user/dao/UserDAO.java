package com.koreait.app.user.dao;

import java.util.HashMap;

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
		if( sqlsession.insert("User1.join",udto) != 0) {
			result = true;
		}
		return result;
	}

	public boolean login(String userid, String userpw) {
		HashMap<String, String> datas = new HashMap<>();
		datas.put("userid", userid);
		datas.put("userpw", userpw);
		boolean result = false;
		
		if((Integer)sqlsession.selectOne("User1.login",datas) == 1) {
			result = true;
		}

		return result;
	}
	
	
	
}













