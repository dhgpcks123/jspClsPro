package com.increpas.cls.controller.survey;

import javax.servlet.http.*;
import java.util.*;

import com.increpas.cls.controller.*;
import com.increpas.cls.dao.*;
import com.increpas.cls.util.SessionUtil;
import com.increpas.cls.vo.*;

public class SurveyInfo implements ClsMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		
//		String sid = SessionUtil.procSession(req, resp);
		
		String sid = "";
		try {
			sid = (String)req.getSession().getAttribute("SID");
			if(sid == null) {
				throw new Exception();
			}
		} catch (Exception e) {
			req.setAttribute("isRedirect", true);
			return "/cls/member/login.cls";
		}
		
		SurveyDao sDao = new SurveyDao();
		ArrayList<SurveyVO> list = sDao.getSIList(sid);
		req.setAttribute("LIST", list);

		String view = "survey/SurveyInfo";
		return view;
	}

}
