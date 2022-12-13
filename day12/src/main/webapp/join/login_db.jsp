<%@page import="com.koreait.web.beans.UserBean"%>
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

<!-- 
	로그인 기능 완성, 
	로그인 성공 -> main_view.jsp
	로그인 실패 -> login_view.jsp
 -->
 
 <%
	String userid = request.getParameter("userid");
 	String userpw = request.getParameter("userpw");
 	UserDAO user = new UserDAO();
 	UserBean userBean = user.login(userid, userpw);
 	
 	if( userBean != null ){
 		// 로그인 성공	
 		session.setAttribute("session_id", userBean);
 %>
 		<script>
			location.href = "main_view.jsp"; 		
 		</script>
 <%
 	} else {
 		// 로그인 실패
 %>
 		<script>
			alert("로그인 실패!");
// 			location.href = "login_view.jsp"; 	
			history.go(-1);
 		</script>
 <%
 	}
 %>

</body>
</html>





















