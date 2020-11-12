package com.increpas.cls.controller.reBoard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.cls.controller.ClsMain;
import com.increpas.cls.dao.ReBoardDao;

public class ReBoardCommentProc implements ClsMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String nowPage = req.getParameter("nowPage");
		String body = req.getParameter("body");
		String supno = (String)req.getParameter("upno");
		int upno = Integer.parseInt(supno);
		String id = (String)req.getSession().getAttribute("SID");
	
		ReBoardDao rDao = new ReBoardDao();
		rDao.addComment(id, body, upno);
		
		
		String view = "/cls/reBoard/reBoardList.cls?nowPage="+nowPage;
		req.setAttribute("isRedirect", true);
		return view;
	}

}
