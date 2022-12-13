package com.action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controller.Action;
import com.dao.MemberDao;
import com.domain.Member;

public class ModifyProAction implements Action{

    @Override
    public String execute(HttpServletRequest request,HttpServletResponse response) throws Throwable {

        //1.로그인 여부 조사
        HttpSession session =request.getSession();
        if(session.getAttribute("memId")==null)
            return"/view/loginForm.jsp";
        
        //2.인코딩처리
        request.setCharacterEncoding("utf-8");
        
        //3.자바빈을 생성하고 자바빈에 전송된 데이터를 저장
        Member member =new Member();
        member.setId((String)session.getAttribute("memId"));
        member.setName(request.getParameter("name"));
        member.setPasswd(request.getParameter("passwd"));
        member.setJumin1(request.getParameter("jumin1"));
        member.setJumin2(request.getParameter("jumin2"));
        member.setEmail(request.getParameter("email"));
        member.setBlog(request.getParameter("blog"));  
        member.setReg_date(new Timestamp(System.currentTimeMillis()));
        
        //4.MemberDao의 updateMember 메소드에 자바빈 전달
        MemberDao manager = MemberDao.getInstance();
        manager.updateMember(member);
        
        return "/view2/modifyPro.jsp";
    }
}
