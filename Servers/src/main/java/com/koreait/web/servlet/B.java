package com.koreait.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Calc")
public class B extends HttpServlet {

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) 
			throws ServletException, IOException {
		
		int num1 =  Integer.parseInt( arg0.getParameter("data1") ); 
		int num2 =  Integer.parseInt( arg0.getParameter("data2") ); 
		
		int result = num1 + num2;
		
		arg0.setAttribute("result", result);
		arg0.getRequestDispatcher("c.jsp").forward(arg0, arg1);
		
	}
	
}















