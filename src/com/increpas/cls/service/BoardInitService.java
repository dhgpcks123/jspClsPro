package com.increpas.cls.service;

import java.util.*;

import com.increpas.cls.dao.BoardDao;
import com.increpas.cls.vo.BoardVO;

public class BoardInitService {
	private BoardDao bDao;
	
	public BoardInitService() {
		bDao = new BoardDao();
	}
	
	public int setDB() {
		int cnt = 0 ;
		bDao.getBoardList();
		ArrayList<String> ids = bDao.getIdList();
		for(int i = 0 ; i < ids.size(); i++) {
			BoardVO bVO = new BoardVO();
			bVO.setId(ids.get(i));
			bVO.setTitle("Title - [ "+(i+1) + " ]");	
			bVO.setBody("body Content  [ "+(i+1) + " ]");	
			cnt += bDao.addBoard(bVO);
		}
		return cnt;
	}
}
