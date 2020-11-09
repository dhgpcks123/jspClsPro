package com.increpas.cls.vo;

import java.sql.*;
import java.text.*;

public class ReBoardVO {
	private int bno, b_mno, upno;
	private String id, body, wdate;
	private Date joinDate;
	private Time joinTime;
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public int getB_mno() {
		return b_mno;
	}
	public void setB_mno(int b_mno) {
		this.b_mno = b_mno;
	}
	public int getUpno() {
		return upno;
	}
	public void setUpno(int upno) {
		this.upno = upno;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getWdate() {
		return wdate;
	}
	public void setWdate() {
		SimpleDateFormat form1 = new SimpleDateFormat("yyyy.MM.dd");
		SimpleDateFormat form2 = new SimpleDateFormat("HH:mm");
		this.wdate = form1.format(joinDate)+" "+form2.format(joinTime);
	}
	public void setWdate(String wdate) {
		this.wdate = wdate;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public Time getJoinTime() {
		return joinTime;
	}
	public void setJoinTime(Time joinTime) {
		this.joinTime = joinTime;
		setWdate();
	}
	
	

}
