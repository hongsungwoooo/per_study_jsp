package com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controller.Action;
import com.dao.MemberDao;

public class LoginProAction implements Action{

    @Override
    public String execute(HttpServletRequest request,HttpServletResponse response) throws Throwable {

        String id =request.getParameter("id");
        String passwd =request.getParameter("passwd");
        
        MemberDao manager = MemberDao.getInstance();
        int check= manager.userCheck(id, passwd);        
        
        if(check==1){
            HttpSession session=request.getSession();
            session.setAttribute("memId", id);
        }
        
        request.setAttribute("check", new Integer(check));
        
        return "/view2/loginPro.jsp";
    }
}