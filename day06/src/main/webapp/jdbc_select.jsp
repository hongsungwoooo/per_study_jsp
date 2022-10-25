<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
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
		Connection conn = null;
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "jsp";
		String password = "jsp";
		
		Class.forName(driver);
		conn = DriverManager.getConnection(url, user, password);
	
		String sql = "SELECT sysdate FROM dual";
		// 2022-10-14 14:32:11.000
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		
		if( rs.next() ){
			out.println(rs.getDate(1));
		}
		
		// close 반납
		rs.close();
		pstm.close();
		conn.close();
		
	
	%>
</body>
</html>














