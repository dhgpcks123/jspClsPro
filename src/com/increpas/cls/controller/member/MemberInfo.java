package com.increpas.cls.controller.member;

import java.util.*;

import javax.servlet.http.*;
import javax.servlet.http.HttpSession;

import com.increpas.cls.controller.ClsMain;
import com.increpas.cls.dao.MemberDAO;
import com.increpas.cls.vo.AvatarVO;
import com.increpas.cls.vo.MemberVO;

public class MemberInfo implements ClsMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "member/MemberInfo";
		String ssid = (String) req.getSession().getAttribute("SID");
		if(ssid ==null) {
			//연결이 해제되거나 로그인이 안 된 경우
			//로그인페이지로 돌려보낸다.
			req.setAttribute("isRedirect", true);
			view = "/cls/member/login.cls";
			return view;
		}
		
		String sid = req.getParameter("id");
		if((!ssid.equals(sid) || sid == null)) {
			sid=ssid;
		}
		
		
		
		MemberDAO mDAO = new MemberDAO();
		MemberVO mVO = new MemberVO();
		mVO = mDAO.getMembAll(sid);
		req.setAttribute("DATA", mVO);

		ArrayList<AvatarVO> list = mDAO.getAvtAll();
		req.setAttribute("LIST", list);
		
		return view;
	}

}
