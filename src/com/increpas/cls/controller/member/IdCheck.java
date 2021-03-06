package com.increpas.cls.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.cls.controller.*;
import com.increpas.cls.dao.*;

public class IdCheck implements ClsMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		// ajax 처리 속성
		//안해줘도 된다
		req.setAttribute("isRedirect", null);
		
		StringBuffer buff = new StringBuffer();
		
		// 1. 파라미터 꺼내오고
		String sid = req.getParameter("id");
		// 2. 데이터베이스 작업하고
		MemberDAO mDAO = new MemberDAO();
		int cnt = mDAO.getIdCnt(sid);
		// 3. 결과만들고
		String result = "";
		
		if(cnt == 0) {
			result="OK";
		} else {
			result="NO";
		}
		
		System.out.println("#### cont result : " + result);
		
		buff.append("{");
		buff.append("	\"result\":\"" +result + "\"");
		buff.append("}");
		System.out.println(buff.toString());
		return buff.toString();
	}

}
