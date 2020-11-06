package com.increpas.cls.controller.guestBoard;

import javax.servlet.http.*;
import java.util.*;

import com.increpas.cls.controller.ClsMain;
import com.increpas.cls.dao.*;
import com.increpas.cls.vo.*;

public class GuestBoard implements ClsMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view ="guestBoard/GuestBoard";		
		
		// 데이터베이스에서 데이터 가져오기
		GBoardDao gDao = new GBoardDao();
		ArrayList<GuestBoardVO> list = gDao.getGBoardList();
		
		int cnt = 0;
		try {
			String sid= (String)req.getSession().getAttribute("SID");
			
			//list 활용하는 방법
			/*
			 * for(int i = 0 ; i < list.size(); i++) { String tid = list.get(i).getId();
			 * if(sid.equals(tid)) { cnt = 1; } }
			 */
			
			//질의명령을 한번 더 보내서 처리하는 방법
			cnt = gDao.getIdCnt(sid);
		} catch (Exception e) {}
		
		// 뷰에 데이터 심고
		req.setAttribute("CNT", cnt);
		req.setAttribute("LIST", list);
		
		
		return view;
	}

}
