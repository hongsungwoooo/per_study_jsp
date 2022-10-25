<%@page import="com.koreait.web.dao.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		UserDAO udao = new UserDAO();
		request.setAttribute("list", udao.getList());	
		pageContext.forward("search_view.jsp");
	%>
</body>
</html>





















