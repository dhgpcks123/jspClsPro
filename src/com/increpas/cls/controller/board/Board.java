package com.increpas.cls.controller.board;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.cls.controller.ClsMain;
import com.increpas.cls.dao.BoardDao;
import com.increpas.cls.util.PageUtil;
import com.increpas.cls.vo.BoardVO;

public class Board implements ClsMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		BoardDao bDao = new BoardDao();
		int nowPage = 1;
		int total = 0;
		total = bDao.getTotalCnt();
		String str = (String)req.getParameter("nowPage");
		
		try {
				nowPage = Integer.parseInt(str);
		}catch(Exception e) {}
		
		PageUtil page = new PageUtil(nowPage, total, 4, 4);
		
		ArrayList<BoardVO> list = bDao.getBoardList(page);
		
		
		req.setAttribute("LIST", list);
		req.setAttribute("PAGE", page);
		String view = "board/BoardList"; //forward 방식으로 뷰를 부른다.
		return view;
	}

}
