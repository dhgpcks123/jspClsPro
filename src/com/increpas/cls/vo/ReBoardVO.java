package com.increpas.cls.vo;

import java.text.*;
import java.sql.*;

public class ReBoardVO {
	private int rno, bno, ano, mno, upno, step;
	private String id, body, sdate, avatar;
	private Date wdate;
	private Time wtime;

	
	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public int getUpno() {
		return upno;
	}

	public void setUpno(int upno) {
		this.upno = upno;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getSdate() {
		return sdate;
	}

	public void setSdate() {
		SimpleDateFormat form1 = new SimpleDateFormat("yyyy/MM/dd ");
		SimpleDateFormat form2 = new SimpleDateFormat("HH:mm");
		this.sdate = form1.format(wdate) + "" + form2.format(wtime);
	}

	public void setSdate(String sdate) {
		this.sdate = sdate;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Date getWdate() {
		return wdate;
	}

	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}

	public Time getWtime() {
		return wtime;
	}

	public void setWtime(Time wtime) {
		this.wtime = wtime;
		setSdate();
	}

	@Override
	public String toString() {
		return "ReBoardVO : rno=" + rno + ", bno=" + bno + ", ano=" + ano + ", mno=" + mno + ", upno=" + upno
				+ ", step=" + step + ", id=" + id + ", body=" + body + ", sdate=" + sdate + ", avatar=" + avatar
				+ ", wdate=" + wdate + ", wtime=" + wtime;
	}
	// VO안에 데이터 들어있나 안들어있나 확인해야 할 때 toString함수를 활용할 수 있지

}
