<%@page import="com.koreait.web.dao.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userid = request.getParameter("userid");
	UserDAO udao = new UserDAO();
	
	if( !udao.checkId(userid) ){
		// 회원가입이 가능한 경우
		out.print("ok");
	} else {
		// 회원가입이 불가능한 경우
		out.print("not-ok");
	}
	

%>