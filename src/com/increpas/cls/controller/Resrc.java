package com.increpas.cls.controller;

import javax.servlet.annotation.*;
import javax.servlet.*;
import javax.servlet.http.*;

//@WebServlet({"/css/*", "/js/*", "/img/*"})
public class Resrc extends HttpServlet {
	
	/*
		css 파일을 요청하는 경우
			/css/w3.css
			/css/cls.css
			/css/member/member.css
			...
		js 파일을 요청하는 경우
			/js/jquery-3.5.1.min.js
			/js/member.js
	 */
	//root경로 : 더 이상 올라갈 수 없는 상태의 경로!
	public void service(HttpServletRequest req, HttpServletResponse resp) {
		//req, resp 객체 매개변수는 서버가 연결해서 넘겨주는 거야.
		//그럼? req에 요청하는 정보들이 담겨있고, 그걸 볼 수 있도록 구현되어있겠지.
		String url = req.getRequestURI();
		// ### url(실제 요청 경로) : /jspcls/css/member/member.css
		// 실제 파일 경로 /WEB_INF/resources/css/member/member.css
		
		
		
		url = url.substring(url.indexOf("/", 1));
		//		==> /css/member/member.css
//---------------------------------------------------------------------		
//		String spath = url.substring(0,url.indexOf("/", 1));
//		System.out.println(" spath : "+spath);
//		//	==> /css || /js || /img 뽑아냄
//		
//		/*
//	 	css 파일 : /WEB-INF/resources/css/xxxxx
//	 	js 파일 : /WEB-INF/resources/js/xxxxx
//	 	img 파일 : /WEB-INF/resources/img/xxxxx
//		 */
//		
//		url = url.substring(url.indexOf(spath+"/"));
//		//	==> /member/member.css
//		System.out.println(" spath + / : "+spath+"/");
//		System.out.println(" url.indexOf(spath+\"/\") : "+url.indexOf(spath+"/"));
//		System.out.println(" url - /member/member.css : "+url);
//---------------------------------------------------------------------
		
		String view = "/WEB-INF/resources" + url;
		// ==> 형태  /WEB-INF/resources/css/member/member.css
		System.out.println("#######view 경로 : "+ view);
		
		RequestDispatcher rd = req.getRequestDispatcher(view);
		
		try {
			rd.forward(req, resp); //안에 페이지를 교체해주는 게 forward
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
