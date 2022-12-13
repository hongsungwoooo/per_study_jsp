package com.action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controller.Action;
import com.dao.MemberDao;
import com.domain.Member;

public class ModifyFormAction implements Action{

    @Override
    public String execute(HttpServletRequest request,HttpServletResponse response) throws Throwable {

        //1. 로그인 여부 조사
        HttpSession session =request.getSession();
        if(session.getAttribute("memId")==null)
            return"/view/loginForm.jsp";

        //2.session에 저장된 id 호출        
        String id = (String)session.getAttribute("memId");  
            
        //3.MemberDao의 getMember 메서드에 id 전달
        MemberDao manager = MemberDao.getInstance();
        Member member = manager.getMember(id);        
        
        //4.반환받은  Member를 request에 저장
        request.setAttribute("member", member);
        
        return "/view2/modifyForm.jsp";
    }
}