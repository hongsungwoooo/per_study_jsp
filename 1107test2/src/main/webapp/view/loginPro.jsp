<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="com.dao.MemberDao" %>
    
<%
	request.setCharacterEncoding("utf-8");

	String id =request.getParameter("id");
	String passwd =request.getParameter("passwd");
	
	//2개정도는 자바빈없이 넘겨도됨?
	MemberDao manager =MemberDao.getInstance();
	int check=manager.userCheck(id, passwd);
	
	//userCheck에서 x를 return 받아서 로긴체크 
	//history.go(-1); : 전페이지로 (입력창)
	if(check==1){
		//로그인 성공
		session.setAttribute("memId",id);
		response.sendRedirect("main.jsp");
		
	}else if(check==0){	
%>  
	<script>
		alert("비밀번호가 맞지 않습니다.");
		history.go(-1);		
	</script>
<%}else{ %>
	<script>
		alert("아이디가 맞지 않습니다.");
		history.go(-1);		
	</script>
<%} %>