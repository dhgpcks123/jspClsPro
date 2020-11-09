package com.increpas.cls.controller.reBoard;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.cls.controller.ClsMain;
import com.increpas.cls.dao.ReBoardDao;
import com.increpas.cls.util.PageUtil;
import com.increpas.cls.vo.ReBoardVO;

public class ReBoardList implements ClsMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		req.setAttribute("isRedirect", false);
		String view = "reBoard/ReBoard";
		int nowPage = 1;
		try {
			nowPage = Integer.parseInt(req.getParameter("nowPage"));
		}catch(Exception e) {}
		
		ReBoardDao rDao = new ReBoardDao();
		//총 갯수? 구해오자.
		int total = rDao.getTotal();
		//pageUtil 객체 만들고
		PageUtil page = new PageUtil(nowPage, total);
		
		ArrayList<ReBoardVO> list = rDao.getBoardList(page);
		
		req.getSession().setAttribute("LIST", list);
		return view;
	}

}
