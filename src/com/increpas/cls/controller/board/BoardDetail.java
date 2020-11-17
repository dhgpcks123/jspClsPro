package com.increpas.cls.controller.board;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.cls.controller.ClsMain;
import com.increpas.cls.dao.BoardDao;
import com.increpas.cls.vo.BoardVO;
import com.increpas.cls.vo.FileVO;

public class BoardDetail implements ClsMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view="board/BoardDetail";
		String sbno = req.getParameter("bno");
		
	
		 int bno = 0;
		 try {
		 	bno = Integer.parseInt(sbno);
		 }catch(Exception e) {
			 System.out.println("###숫자포맷오류###");
		 }
		 BoardDao bDao = new BoardDao();
//		 ArrayList<BoardVO> list = bDao.getDetail(bno);
		 HashMap map= null;
		 map = bDao.getDetailIMG(bno);
		 FileVO fVO = (FileVO) map.get("FileVO");
		 BoardVO bVO = (BoardVO) map.get("BoardVO");
		 
		 req.setAttribute("BOARD", bVO);
		 req.setAttribute("FILE", fVO);
//		 req.setAttribute("LIST", list);
	
		
		return view;
	}

}
