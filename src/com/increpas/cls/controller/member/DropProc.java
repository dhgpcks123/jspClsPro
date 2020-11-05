package com.increpas.cls.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.cls.controller.ClsMain;
import com.increpas.cls.dao.MemberDAO;


public class DropProc implements ClsMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {

		req.setAttribute("isRedirect", true);
		
		
		MemberDAO mDAO = new MemberDAO();
		String view="/cls/member/login.cls";
		
		return null;
	}

}
