<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head><title>메인입니다..</title>
</head>
<body>
   <table width=500 cellpadding="0" cellspacing="0"  align="center" border="1" >
         <tr>
           <td width="300" height="20">하하하</td>

           <td rowspan="3" align="center">
             ${sessionScope.memId}님이 <br>
             방문하셨습니다
             <form  method="post" action="logout.do">  
             <input type="submit"  value="로그아웃">
              <input type="button" value="회원정보변경" onclick="javascript:window.location='modifyForm.do'">
             <input type="button" value="회원탈퇴" onclick="javascript:window.location='deleteForm.do'">
             </form>
         </td>
        </tr> 
       <tr> 
         <td rowspan="2" width="300" >메인입니다.</td>
      </tr>
     </table>
     <br>
</body>
</html>
