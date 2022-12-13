<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.dao.MemberDao" %>
<% 
	if(session.getAttribute("memId")==null){
		response.sendRedirect("main.jsp");
	}else{
		request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="member" class="com.domain.Member">
	<jsp:setProperty name="member" property="*"/>
</jsp:useBean>
<%
	member.setId((String)session.getAttribute("memId"));

	MemberDao manager = MemberDao.getInstance();
	manager.updateMember(member);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Refresh" content="5; url=main.jsp; charset=UTF-8">
<title>회원정보 수정</title>
</head>
<body>
<h3>회원정보 수정</h3>
<div align="center">회원정보가 정상적으로 수정되었습니다</div>
</body>
</html>
<%}%>