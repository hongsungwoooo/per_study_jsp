package com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controller.Action;
import com.dao.MemberDao;

public class DeleteProAction implements Action{

    @Override
    public String execute(HttpServletRequest request,HttpServletResponse response) throws Throwable {
        
        request.setCharacterEncoding("utf-8");
        
        //1. 로그인 여부 체크
        HttpSession session =request.getSession();
        if(session.getAttribute("memId")==null)
            return"/view2/loginForm.jsp";
        
        //2. session에서 id를 추출해고 전송받은 비밀번호를
        
        String id =(String)session.getAttribute("memId");
        String passwd = request.getParameter("passwd");
                
        //     memberDao의 userCheck 에 전달
        MemberDao manager = MemberDao.getInstance();
        int check = manager.userCheck(id, passwd);
        
        //3. check 1인 경우 deleteMember 메소드에 id 전달
        if(check== 1){
            manager.deleteMember(id);
            session.invalidate();
        }           
        
        //4. check를 request에 저장
        request.setAttribute("check", check);
        
        return "/view2/deletePro.jsp";
    }
}