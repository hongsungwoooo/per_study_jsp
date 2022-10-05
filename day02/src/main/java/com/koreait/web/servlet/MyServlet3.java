package com.koreait.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/hello3")
public class MyServlet3 extends HttpServlet{

	
/*
 * request 	:  /hello3
 * response :  /1 : hello servlet 
 * 				2 : hello servlet 
 * 				3 : hello servlet
 * 				....
 * 				100 : hello servlet 
 * 
 */
	
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) 
			throws ServletException, IOException {
		
		arg1.setCharacterEncoding("UTF-8");
		arg1.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = arg1.getWriter();
		for(int i=1; i<101; i++) {
			
			out.println( i + " : 안녕 Servlet<br>");
		
		}
		
	}
	
	
}
