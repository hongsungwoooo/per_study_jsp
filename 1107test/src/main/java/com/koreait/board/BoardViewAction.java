package com.koreait.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.board.dao.BoardDAO;

public class BoardViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		ActionForward forward = new ActionForward();
		BoardDAO bdao = new BoardDAO();
		
		int boardnum = Integer.parseInt( req.getParameter("boardnum") );
	
		
		req.setAttribute("board", bdao.getDetail(boardnum));

		
		forward.setRedirect(false);
		forward.setPath("/board/prof_view.jsp");
		
		return forward;
	}
	
	
}















