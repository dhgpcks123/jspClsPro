package com.increpas.cls.controller.survey;

import java.util.ArrayList;

import javax.servlet.http.*;

import com.increpas.cls.controller.ClsMain;
import com.increpas.cls.dao.SurveyDao;
import com.increpas.cls.util.SessionUtil;
import com.increpas.cls.vo.SurveyVO;

public class Survey implements ClsMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		// 세션 검사하고
//		SessionUtil.procSession(req, resp);
		String sid = (String) req.getSession().getAttribute("SID");
		if(sid == null) {
			req.setAttribute("isRedirect", true);
			return "/cls/member/login.cls";
		}
		
		String view = "survey/Survey";
		
		// 파라미터 꺼내고
		String strno = req.getParameter("sno");
		int sno = 0 ;
		try {
			sno = Integer.parseInt(strno);
			SurveyDao sDao = new SurveyDao();
			ArrayList<SurveyVO> list = sDao.getQuestList(sno);
			
			req.setAttribute("LIST", list);
		} catch(Exception e) {
			req.setAttribute("isRedirect", true);
			view = "/cls/survey/surveyInfo.cls";
		}
		
		return view;
	}
}
