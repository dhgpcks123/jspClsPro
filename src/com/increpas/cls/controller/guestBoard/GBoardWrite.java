package com.increpas.cls.controller.guestBoard;

import javax.servlet.http.*;
import com.increpas.cls.controller.*;
import com.increpas.cls.dao.*;

public class GBoardWrite implements ClsMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {

		//글 등록키를 누르면 여기서
		//redirect로 proc과정을 거칠거야.
		req.setAttribute("isRedirect", true);
		String sid="";
		String view="/cls/member/login.cls";
		int cnt=0;
		
		try {
			sid =(String) req.getSession().getAttribute("SID");
			String sbody = req.getParameter("body");
			GBoardDao GDao = new GBoardDao();
			cnt = GDao.addGBoard(sid, sbody);
			if(cnt ==1) {
				view = "/cls/guestBoard/guestBoard.cls";
			}
		} catch (Exception e) {
			view = "/cls/member/login.cls";
		}
		
		
		
		// 1. 파라미터 읽어오고
//		int sg_mno= ;
		//아이디로 읽어오네!!!!!!!!!!!!
		
		// 2. 데이터 베이스 작업하고.
		//글 입력 시킬거야. 그러면 어떤 데이터를 넘겨줘야하나!
		//g_mno랑 body를 넘겨줘야겠지? //add_gbd해주자.
		
		
		// 3. 결과에 따라 뷰 부르고
		return view;
	}

}
