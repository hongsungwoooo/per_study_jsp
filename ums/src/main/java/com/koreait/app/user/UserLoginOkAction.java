package com.koreait.app.user;

<<<<<<< HEAD
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.user.dao.UserDAO;


public class UserLoginOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		ActionForward forward = new ActionForward();
		UserDAO udao = new UserDAO();
		
		String userid = req.getParameter("userid");
		String userpw = req.getParameter("userpw");
		
		if(udao.login(userid, userpw)) {
			// 로그인 성공
			forward.setPath("/app/main/mainview.jsp");
		} else {
			// 로그인 실패
			forward.setPath("/app/user/loginview.jsp?flag=false");
		}
		
		forward.setRedirect(false);
		return forward;
	}

	
	
}











=======
import java.util.Iterator;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.ActionForward;

public class UserLoginOkAction implements Action {
	@Override
	public ActionForward excute(HttpServletRequest req, HttpServletResponse resp) {
	UserDAO udao = new UserDAO();
	return result;
	}
	
	public boolean login(String userid, String userpw)
	}
}
>>>>>>> 5d275dffffccfaf86eba6b1da2d4082723e2e176
