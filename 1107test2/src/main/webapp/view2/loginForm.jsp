<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head><title>로그인</title>

   <script type="text/javascript">
     <!--
       function begin(){
         document.myform.id.focus();
       }
       function checkIt(){
         if(!document.myform.id.value){
           alert("이름을 입력하지 않으셨습니다.");
           document.myform.id.focus();
           return false;
         }  
         if(!document.myform.passwd.value){
           alert("비밀번호를 입력하지 않으셨습니다.");
           document.myform.passwd.focus();
           return false;
         }
         return true;
       }
     //-->
   </script>
</head>
<BODY onload="begin()">
<form name="myform" action="loginPro.do" method="post" onSubmit="return checkIt()">
<table cellspacing=1 cellpadding=1 width="260" border=1 align="center" >
  
  <tr height="30">
    <td colspan="2" align="center"><strong>회원로그인</strong></td></tr>
  
  <tr height="30">
    <td width="110" align=center>아이디</td>
    <td width="150" align=center>
       <input type="text" name="id" size="15" maxlength="12"></td></tr>
  <tr height="30">
    <td width="110" align=center>비밀번호</td>
    <td width="150" align=center>
      <input type=password name="passwd"  size="15" maxlength="12"></td></tr>
  <tr height="30">
    <td colspan="2" align="center">
      <input type=submit value="로그인"> 
      <input type="button" value="회원가입" onclick="location.href='inputForm.do'"></td></tr>
</table>
</form>

</body>
</html>