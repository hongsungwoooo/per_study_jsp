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
	<jsp:useBean id="user" class="com.koreait.web.beans.UserBean" />
	
	<!-- *로 처리하면 한번에 해결 가능 -->
<%-- 	<jsp:setProperty property="userid" name="user"/> --%>
<%-- 	<jsp:setProperty property="userpw" name="user"/> --%>
<%-- 	<jsp:setProperty property="username" name="user"/> --%>
	
	<!-- 외부에서 전달된 name 속성과 필드의 이름이 같으면 value 가 자동 세팅 -->
	<jsp:setProperty property="*" name="user"/>
	
	<%
		UserDAO udao = new UserDAO();
		if(udao.join(user)){
			// 가입성공
	%>
		<script>
			alert('회원가입 성공!');
			location.href = "login_view.jsp";
		</script>
	
	<%
		} else {
			// 가입실패
	%>
		<script>
			alert('회원가입 실패!');
			location.href = "join_view.jsp";
		</script>
	<%
		}
	%>
	
</body>
</html>



















