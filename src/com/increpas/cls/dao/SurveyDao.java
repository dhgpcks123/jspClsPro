package com.increpas.cls.dao;
import java.util.*;
import java.sql.*;

import db.*;
import com.increpas.cls.sql.*;
import com.increpas.cls.vo.*;

public class SurveyDao {
	private ClsDBCP db;
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private SurveySQL sSQL;
	
	public SurveyDao() {
		db = new ClsDBCP();
		sSQL = new SurveySQL();
	}
	
	//진행중인 설문 조회 전담 처리함수
	public ArrayList<SurveyVO> getSIList(String id){
		ArrayList<SurveyVO> list = new ArrayList<SurveyVO>();
		con = db.getCon();
		String sql = sSQL.getSQL(sSQL.SEL_CURR_LIST);
		pstmt = db.getPSTMT(con, sql);
		
		try {
		
			pstmt.setString(1, id);
			System.out.println("셋팅 아이디" + id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				SurveyVO sVO = new SurveyVO();
				sVO.setSno(rs.getInt("sno"));
				sVO.setSbody(rs.getString("sbody"));
				sVO.setCnt(rs.getInt("cnt"));
				
				list.add(sVO);
			}
			
		} catch (Exception e) {
			db.close(rs);
			db.close(stmt);
			db.close(con);
		}
		return list;
	}
	
	//응답문항 리스트 가져오는 함수를 만든다
	public ArrayList<SurveyVO> getSQList(String sino){
		ArrayList<SurveyVO> list = new ArrayList<SurveyVO>();
		con = db.getCon();
		String sql = sSQL.getSQL(sSQL.SEL_QUEST_LIST);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, sino);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				SurveyVO sVO = new SurveyVO();
				sVO.setQbody(rs.getString("qbody"));
				sVO.setUpno(rs.getInt("upno"));	
				sVO.setStep(rs.getInt("step"));
				
				list.add(sVO);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		
		return list;
	}
	
}
