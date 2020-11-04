package com.increpas.cls.controller.member;

import java.util.ArrayList;

import javax.servlet.http.*;

import com.increpas.cls.controller.ClsMain;
import com.increpas.cls.dao.MemberDAO;
import com.increpas.cls.vo.AvatarVO;

public class Join implements ClsMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		//일단 뷰를 부르자
		String view="member/Join";
		
		//데이터를 준비한다
		MemberDAO mDao = new MemberDAO();
		ArrayList<AvatarVO> list = mDao.getAvtAll();
		req.setAttribute("LIST", list);
		return view;
	}

}
