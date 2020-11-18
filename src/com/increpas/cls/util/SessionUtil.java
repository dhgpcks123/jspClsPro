package com.increpas.cls.util;

import javax.servlet.http.*;
public class SessionUtil {
		public static String procSession(HttpServletRequest req, HttpServletResponse resp) {
				
			String sid = (String) req.getSession().getAttribute("SID");
			System.out.println("@@@@@@@@@@@@ sid : " + sid);
			if(sid == null) {
				try {
//					req.setAttribute("isRedirect", true);
					resp.sendRedirect("/cls/member/login.cls");
				} catch (Exception e) {}
			}
			return sid;
		}
}
