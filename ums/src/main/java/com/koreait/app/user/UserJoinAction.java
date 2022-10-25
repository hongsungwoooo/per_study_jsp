package com.koreait.app.user;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.user.dao.UserDAO;
import com.koreait.app.user.dao.UserDTO;

public class UserJoinAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("excute 도착");
		UserDAO udao = new UserDAO();
		UserDTO udto = new UserDTO();
		ActionForward forward = new ActionForward();
		
		udto.setUserid(req.getParameter("userid"));
		udto.setUserpw(req.getParameter("userpw"));
		udto.setUsername(req.getParameter("username"));
		udto.setUserphone(req.getParameter("userphone"));
		udto.setUseraddr(req.getParameter("useraddr"));
		
		System.out.println(req.getParameter("userid"));
		
		if( udao.join(udto) ) {
			// 회원가입 성공, app/user/loginview.jsp
			// redirect
			forward.setRedirect(true);
			forward.setPath("/app/user/loginview.jsp");
		} else {
			// 회원가입 실패, index.jsp
			// redirect
			forward.setRedirect(true);
			forward.setPath("/index.jsp");
		}
		
		return forward;
	}

}











