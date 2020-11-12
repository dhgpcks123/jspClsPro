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
		String view = "reBoard/ReBoard";
		ReBoardDao rDao = new ReBoardDao();

		String sid = "";
		String avatar = "noimage.jpg";
		
		//아바타 꺼내오기
		try {
			sid = (String)req.getSession().getAttribute("SID");
			avatar = rDao.getAvtFile(sid);
		} catch (Exception e) {}
		
		// 파라미터 받고
		int nowPage = 1;
		try {
			nowPage = Integer.parseInt(req.getParameter("nowPage"));
		} catch (Exception e) {}
		
		// PageUtil 만들고
		int total = rDao.getCnt();
		PageUtil page = new PageUtil(nowPage, total);
		
		ArrayList<ReBoardVO> list = rDao.getBoardList(page);
		
		// 데이터 뷰에 심고
		req.setAttribute("LIST", list);
		//setParmeter없소이다!
		req.setAttribute("PAGE", page);
		req.setAttribute("AVTIMG", avatar);
		
		
		return view;
	}

}
