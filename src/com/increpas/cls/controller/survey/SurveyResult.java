package com.increpas.cls.controller.survey;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.cls.controller.ClsMain;

public class SurveyResult implements ClsMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "survey/SurveyResult";
		
		return view;
	}

}
