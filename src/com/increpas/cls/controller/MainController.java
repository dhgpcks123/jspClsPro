package com.increpas.cls.controller;

import javax.servlet.http.*;

import com.increpas.cls.controller.member.*;

public class MainController implements ClsMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		req.setAttribute("isRedirect", false);
		String view = "/main";
		return view;
	}
}
