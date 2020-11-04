package com.increpas.cls.controller.guestBoard;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.cls.controller.ClsMain;

public class GuestBoard implements ClsMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view ="guestBoard/GuestBoard";		
		return view;
	}

}
