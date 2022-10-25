<%@page import="com.koreait.web.beans.UserBean"%>
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
		//String userid =  (String)session.getAttribute("session_id");
		UserBean user = (UserBean)session.getAttribute("session_id");
	
		if( user != null ){
	%>
	<script>
<%-- 	alert("<%=userid %>님 안녕하세요!"); --%>
		// 이름으로 ~~~님 안녕하세요! alert
		alert("<%=user.getUsername() %>님 안녕하세요!");
	</script>

	<p>
		<%=user.getUserid() %>님 (<%=user.getUsername() %>) 
		<input type="button" value="로그아웃" onclick="location.href='logout_db.jsp'">
		<!-- userid님, (이름) -->
	</p>

	<%
		} else {
	%>
		<script>
			alert("로그인 후 이용하세요!");
			location.href = "login_view.jsp";
		</script>
	<%
		}
	%>
</body>
</html>














