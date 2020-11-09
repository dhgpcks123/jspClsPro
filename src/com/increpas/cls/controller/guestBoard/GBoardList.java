package com.increpas.cls.controller.guestBoard;

import javax.servlet.http.*;
import java.util.*;

import com.increpas.cls.controller.ClsMain;
import com.increpas.cls.dao.*;
import com.increpas.cls.vo.*;
import com.increpas.cls.util.*;

public class GBoardList implements ClsMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view ="guestBoard/GBoardList";
		
		
		int nowPage = 1;
		try{
			nowPage = Integer.parseInt(req.getParameter("nowPage"));
		}catch(Exception e) {}
		
		// pageUtil 객체 만들고
		GBoardDao gDao = new GBoardDao();
		int total = gDao.getTotal();
		PageUtil page = new PageUtil(nowPage, total);
		
		
		// 데이터베이스에서 데이터 가져오기
		ArrayList<GuestBoardVO> list = gDao.getGBoardList(page);
		
		int cnt = 0;
		try {
			String sid= (String)req.getSession().getAttribute("SID");
	
			cnt = gDao.getIdCnt(sid);
		} catch (Exception e) {}
		
		// 뷰에 데이터 심고
		req.setAttribute("CNT", cnt);
		req.setAttribute("LIST", list);
		req.setAttribute("PAGE", page);
		
		return view;
	}

}
