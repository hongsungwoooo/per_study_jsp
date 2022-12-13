package com.koreait.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.board.dao.BoardDAO;
import com.koreait.board.dao.BoardDTO;

public class BoardWriteOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		ActionForward forward = new ActionForward();
		BoardDAO bdao = new BoardDAO();
		
		String name = req.getParameter("name");
		String userid = req.getParameter("userid");
		String position = req.getParameter("position");
		String sal = req.getParameter("sal");
		int hiredate = Integer.parseInt(req.getParameter("hiredate")); 
		
		
		
		
		BoardDTO board = new BoardDTO();
		board.setName(name);
		board.setUserid(userid);
		board.setPosition(position);
		board.setSal(sal);
		board.setHiredate(hiredate);
		
		forward.setRedirect(true);
		if(bdao.insertBoard(board)) {
			// 성공시
			int profno = bdao.getSeq();
			forward.setPath(req.getContextPath() + "/board/prof_view.bo?profno" + profno);
		} else {
			// 실패시
			forward.setPath(req.getContextPath() + "/board/prof_add.bo" );
		}
		
		return forward;
	}

}
















