package com.increpas.cls.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.cls.controller.*;
import com.increpas.cls.dao.*;

public class LoginProc implements ClsMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		//뷰 요청방식
		req.setAttribute("isRedirect", true);
		String view ="/cls/main.cls";
		
		// 파라미터 받고
		String sid = req.getParameter("id");
		String spw = req.getParameter("pw");
		
		// 데이터베이스 작업하고 결과받고
		MemberDAO mDao = new MemberDAO();
		int cnt = mDao.getLoginCnt(sid, spw);
		if(cnt != 1) {
			view="/cls/member/login.cls";
		} else {
			// 이 경우는 로그인 성공한 경우이므로 세션에 데이터를 기록해준다.
			req.getSession().setAttribute("SID", sid);
		}
		
		return view;
	}

}
