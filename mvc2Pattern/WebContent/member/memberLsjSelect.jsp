<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="com.mvc2.member.dao.LsjMemberDao" %>
<%@ page import ="com.mvc2.member.dao.LsjMemberDaoImpl" %>
<%@ page import ="com.mvc2.member.vo.LsjMemberVO" %>
<%@ page import = "java.util.ArrayList"%>
<%@ page import= "com.mvc2.common.utils.FilePath" %>
<%
    request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>memberLsjSelect</title>
	</head>
	<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.0.min.js"></script> 
	<script>
		$(function(){
			$("#selectAllBtn").click(function(){
				alert("selectAllBtn >>>>> ");
				$("#ISUD_TYPE").val("SA");
				alert("$('#ISUD_TYPE').val('SA') >>> " + $("#ISUD_TYPE").val())
				$("#memberLsjSelect").attr("action","/mvc2Pattern/member").submit();
			});	
			$("#updateBtn").click(function(){
				alert("updateBtn >>>>> ");
				$("#ISUD_TYPE").val("U");
				alert("$('#ISUD_TYPE').val('U') >>> " + $("#ISUD_TYPE").val())
				$("#memberLsjSelect").attr("action","/mvc2Pattern/member").submit();
			});	
			$("#deleteBtn").click(function(){
				alert("deleteBtn >>>>> ");
				$("#ISUD_TYPE").val("D");
				alert("$('#ISUD_TYPE').val('D') >>> " + $("#ISUD_TYPE").val())
				$("#memberLsjSelect").attr("action","/mvc2Pattern/member").submit();
			});	
			$("#boardSelectBtn").click(function(){
				alert("boardSelectBtn >>>>> ");
				$("#ISUD_TYPE").val("BSA");
				alert("$('#ISUD_TYPE').val('BSA') >>> " + $("#ISUD_TYPE").val())
				$("#memberLsjSelect").attr("action","/mvc2Pattern/member").submit();
			});	
		});
	</script>
	<body>
		<form name="memberLsjSelect" id="memberLsjSelect" method ="POST" >
		<% 

		Object obj = request.getAttribute("aList"); 
		System.out.println("obj1 >>> : " +obj);
				
		if (obj != null){
			ArrayList<LsjMemberVO> aList = (ArrayList<LsjMemberVO>) obj;
			if (aList.size() == 0){
	
			%>	
			<table border="1" class="table">
				<tr>
					<td>NO DATA</td>
				</tr>
			</table>			
			<% 		
	 		}else{
			%>
			<table border="1" class="table">
				<tr>
					<td colspan="16" align="center"><h3>????????????  </h3></td>
				</tr>	
				<tr>
					<td class="info_title"><input type="checkbox" name="chkAll" id="chkAll"></td>
				 	<td class="info_title">????????????</td>
					<td class="info_title">?????????</td>
					<td class="info_title">????????????</td>
					<td class="info_title">??????</td>
					<td class="info_title">??????</td>
					<td class="info_title">????????????</td>
					<td class="info_title">?????????</td>
					<td class="info_title">?????????</td>
					<td class="info_title">????????????</td>
					<td class="info_title">??????</td>
					<td class="info_title">????????????</td>
					<td class="info_title">????????????</td>
					<td class="info_title">?????????</td>
					<td class="info_title">?????????</td>
				</tr>
			 		
		<% 		for(int i =0; i<aList.size(); i++){  
					LsjMemberVO lvo = aList.get(i);
					System.out.println("????????????>>> : "+ "../upload/"+ lvo.getLimage());
		%>
				<tr>
				 <td class="info_con"><input type="checkbox" name="chkInLmem" id="chkInLmem"  
												value="<%= lvo.getLmem() %>"></td>    
				<td class="info_con"><%=lvo.getLmem() %></td>
				<td class="info_con"><%=lvo.getLid() %></td>
				<td class="info_con"><%=lvo.getLpw() %></td>
				<td class="info_con"><%=lvo.getLname() %></td>
				<td class="info_con"><%=lvo.getLgender() %></td>
				<td class="info_con"><%=lvo.getLbirth() %></td>
				<td class="info_con"><%=lvo.getLemail() %></td>
				<td class="info_con"><%=lvo.getLhp() %></td>
				<td class="info_con"><%=lvo.getLpostno() %></td>
				<td class="info_con"><%=lvo.getLaddr() %></td>
				<td><img src = "./upload/<%=lvo.getLimage()%>" border=0 width="150" height="100"></td>
				<td class="info_con"><%=lvo.getLdeleteyn() %></td>
				<td class="info_con"><%=lvo.getLinsertdate() %></td>
				<td class="info_con"><%=lvo.getLupdatedate() %></td>		
				</tr>
				
		<%			} //for???
				} //aList.size if ???
			}//object if ???%>
				<!-- tr -->
				<tr>
					<td colspan="16" class="info_button">
						<input type="hidden" id="ISUD_TYPE" name="ISUD_TYPE">
						<input type="button" value="????????????" id="selectAllBtn" name="selectAllBtn" class="btn">
						<input type="button" value="??????" id="updateBtn" name="updateBtn" class="btn">
						<input type="button" value="??????" id="deleteBtn" name="deleteBtn" class="btn">
						<input type="button" value="???????????????" id="boardSelectBtn" name="boardSelectBtn" class="btn">
					</td>
				</tr>
				<!-- //tr -->
			</table>	
		</form>
	</body>
</html>