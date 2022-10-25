package com.koreait.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class MyServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) 
			throws ServletException, IOException {
		
		String[] numstr = arg0.getParameterValues("num");
		
		int result = 0;
		
		for( int i = 0; i<numstr.length; i++ ) {
			int num = Integer.parseInt(numstr[i]);
			result += num;
		}
		
		arg1.getWriter().println("결과는 : " + result);
		
	}
	
}













