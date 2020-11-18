package com.increpas.cls.controller.board;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.cls.controller.ClsMain;
import com.increpas.cls.dao.BoardDao;
import com.increpas.cls.util.SessionUtil;
import com.increpas.cls.vo.BoardVO;
import com.increpas.cls.vo.FileVO;

public class BoardDetail implements ClsMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
//		SessionUtil util = new SessionUtil();
//		util.procSession(req, resp); 이렇게 할 필요 없어. 왜냐고?
//		SessionUtil클래스 만들 때 procSession을 static으로 해놨어.
//		그냥 import만 해주면 불러와서 쓸 수 있는셈이지
		//session 비어 있으면 로그인페이지로 돌려보내자 
		String sid = (String) req.getSession().getAttribute("SID");
		if(sid == null) {
			req.setAttribute("isRedirect", true);
			return "/cls/member/login.cls";
		}
		//??? 이건 되고,
		//new SessionUtil().procSession(req, resp); 이건 안 되는 이유가 뭘까?
		//Survey.java 참고해보셈. Survey.java는 된다고
		
		String view="board/BoardDetail";
		
		String sbno = req.getParameter("bno");
		
	
		BoardDao bDao = new BoardDao();
		int bno = 0;
		try {
			bno = Integer.parseInt(sbno);
			bDao.getUpCnt(bno);
			HashMap map= null;
			map = bDao.getDetailIMG(bno);
			FileVO fVO = (FileVO) map.get("FileVO");
			BoardVO bVO = (BoardVO) map.get("BoardVO");
			
			req.setAttribute("BOARD", bVO);
			req.setAttribute("FILE", fVO);
		}catch(Exception e) {
			System.out.println("###숫자포맷오류###");
		}
		 
		 
//		 ArrayList<BoardVO> list = bDao.getDetail(bno);
		
//		 req.setAttribute("LIST", list);
	
		
		return view;
	}

}
