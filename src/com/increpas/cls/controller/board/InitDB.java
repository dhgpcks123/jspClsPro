package com.increpas.cls.controller.board;

import javax.servlet.http.*;
import com.increpas.cls.controller.ClsMain;
import com.increpas.cls.service.*;

public class InitDB implements ClsMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		
		BoardInitService bSrvc = new BoardInitService();
		
		int cnt = bSrvc.setDB();
		System.out.println("***** " + cnt + " 명의 회원이 글을 남겼습니다");
		
		
		String view = "/cls/board/boardList.cls";
		req.setAttribute("isRedirect", true);
		return view;
	}

}
