<%@page import="com.withpill.web.beans.UserBean"%>
<%@page import="com.withpill.web.dao.UserDAO"%>
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
		String userid = request.getParameter("userid");
		UserBean user = udao.searchById(userid);
		request.setAttribute("user", user);
		pageContext.forward("search_view.jsp");
	%>

</body>
</html>


















