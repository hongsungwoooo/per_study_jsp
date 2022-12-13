<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="com.dao.MemberDao,com.domain.Member" %>
<%  //로그인 체크
	if(session.getAttribute("memId")==null){
		response.sendRedirect("main.jsp");
	}else{
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 정보 수정</title>
</head>
<%
	String memId =(String)session.getAttribute("memId");
	MemberDao manager= MemberDao.getInstance();
	Member c = manager.getMember(memId);
	
	//Email Blog null값일때 공백처리
	if(c.getEmail()==null){
		c.setEmail("");
	}
	if(c.getBlog()==null){
		c.setBlog("");
	}
%>
<body>
<form method="post" action="modifyPro.jsp" name="userinput">
<h3>회원정보 수정</h3>
사용자ID : <%=c.getId() %><br/>
비밀번호 : <input type="password" name="passwd" size="10" maxlength="10" value="<%=c.getPasswd()%>"><br/>
사용이름 : <input type="text" name="name" size="15" maxlength="20" value="<%=c.getName()%>"><br/>
주민등록번호 : <%=c.getJumin1() %>-<%=c.getJumin2()%><br/>
E-Mail : <input type ="text" name ="email" size="40" maxlength="30" value="<%=c.getEmail() %>"><br/>
Blog : <input type ="text" name ="blog" size="60" maxlength="50" value="<%= c.getBlog() %>"><br/>

<input type="submit" name="modify" value="수   정">
<input type="button" value="취   소" onclick="location.href='main.jsp'">
</form>
</body>
</html>
<%}%>