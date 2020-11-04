package com.increpas.cls.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.increpas.cls.controller.ClsMain;
import com.increpas.cls.dao.MemberDAO;
import com.increpas.cls.vo.MemberVO;

public class MemberInfo implements ClsMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		String sid = (String) session.getAttribute("SID");
		
		MemberDAO mDAO = new MemberDAO();
		MemberVO mVO = new MemberVO();
		mVO = mDAO.getMembAll(sid);
		req.setAttribute("DATA", mVO);
		
		return "member/MemberInfo";
	}

}
