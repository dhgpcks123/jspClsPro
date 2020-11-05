package com.increpas.cls.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.increpas.cls.controller.ClsMain;
import com.increpas.cls.dao.MemberDAO;

public class MemberEdit implements ClsMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		// 할일
		// 파라미터 받아오고
//		HttpSession session = req.getSession();
//		session.getAttribute("SID");
		String sid = (String)req.getSession().getAttribute("SID");

//		회원번호 전달한 경우
//		String smno = req.getParameter("mno");
//		int mno = Integer.parseInt(smno);
		
		String mail = req.getParameter("mail");
		String savt = req.getParameter("avt");
		int avt = Integer.parseInt(savt);
		// 뷰 요청방식 설정하고( 비동기통신 : null )
		req.setAttribute("isRedirect", null);
		//데이터베이스 작업하고 결과받아오고
		MemberDAO mDAO = new MemberDAO();
		int cnt = mDAO.editMember(sid, mail, avt);
		System.out.println("출력 : "+ cnt);
		//뷰를 부르고 
		return cnt+"";
	}

}
