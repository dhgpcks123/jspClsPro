package com.increpas.cls.controller.survey;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.cls.controller.ClsMain;
import com.increpas.cls.dao.SurveyDao;
import com.increpas.cls.vo.SurveyVO;

public class Survey implements ClsMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		
		String sino = req.getParameter("sno");
		SurveyDao sDao = new SurveyDao();
		ArrayList<SurveyVO> list = sDao.getSQList(sino);
		System.out.println(list.size());
		
		req.setAttribute("LIST", list);
		
		String view = "survey/Survey";
		return view;
	}

}
