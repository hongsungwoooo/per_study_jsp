package com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Action;

public class LoginFormAction implements Action{

    @Override
    public String execute(HttpServletRequest request,HttpServletResponse response) throws Throwable {
    
        return "/view2/loginForm.jsp";
    }  
}