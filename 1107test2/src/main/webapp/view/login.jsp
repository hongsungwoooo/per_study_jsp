<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% //로그인이 되었이어야  보여지도록 검증
   if(session.getAttribute("memId") == null){
	   response.sendRedirect("main.jsp");
   }else{
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><title>메인입니다..</title>
</head>
<body>
       <table width="500" cellpadding="0" cellspacing="0"  align="center" border="1" >
         <tr>
           <td width="300" height="20">하하하</td>

           <td rowspan="3" align="center">
             <%=session.getAttribute("memId")%>님이 <br>
             방문하셨습니다
             <form  method="post" action="logout.jsp">  
             <input type="submit"  value="로그아웃">
        <!-- javascript:window.location='modifyForm.jsp' => location.href-->
             <input type="button" value="회원정보변경" onclick="location.href='modifyForm.jsp'">
             <input type="button" value="회원탈퇴" onclick="location.href='deleteForm.jsp'">
             <input type="button" value="게시판으로" onclick="location.href='../BoardList.bo'">
             </form>
         </td>
        </tr>
       <tr > 
         <td rowspan="2" width="300" >메인입니다.</td>
      </tr>
     </table>
 </body>
</html>
<%}%>