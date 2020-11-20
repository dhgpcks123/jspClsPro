package com.increpas.cls.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.cls.controller.ClsMain;
import com.increpas.cls.dao.BoardDao;
import com.increpas.cls.vo.BoardVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BoardEditProc implements ClsMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "board/boardRedirect";
		
		//할 일
		// 1. 파라미터 받고
		/*
		 * String sno = req.getParameter("bno"); int bno = Integer.parseInt(sno);
		 * 지금은 스트림 방식이므로 MultipartRequest로 꺼내와야 한다;;
		 */
		int cnt = 0;
		int bno = 0;
		String path = req.getSession().getServletContext().getRealPath("");
		path = path+"WEB-INF\\resources\\img\\upload";
//		String path = req.getSession().getServletContext().getRealPath("\\WEB-INF\\resources\\img\\upload");
		
		System.out.println("#### Controller real path : " + path);
		
		try {
			MultipartRequest multi = new MultipartRequest(req, path, 1024*1024*1024, 
					"UTF-8", new DefaultFileRenamePolicy());
			String title = multi.getParameter("title");
			String body = multi.getParameter("body");
			
			String sno = multi.getParameter("bno");
			bno = Integer.parseInt(sno);
		
			// 2. VO에 채우고
			BoardVO bVO = new BoardVO();
			bVO.setBno(bno);
			bVO.setTitle(title);
			bVO.setBody(body);
			
			// 3. 데이터베이스에 작업하고 결과 받고
			BoardDao bDao = new BoardDao();
			cnt = bDao.editBoard(bVO);
			

		
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		String tmp = "";
		if(cnt ==1) {
				//정보수정에 성공한 경우
			tmp = "boardDetail.cls";
		}else if(cnt ==0) {
				//정보수정에 실패한 경우
			tmp = "boatdEdit.cls";
		}
		
		req.setAttribute("VIEW", tmp);
		req.setAttribute("BNO", bno);
		
		return view;
	}

}
