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
	
	public ArrayList<SurveyVO> getQuestList(int sno){
		ArrayList<SurveyVO> list = new ArrayList<SurveyVO>();
		
		con = db.getCon();
		String sql = sSQL.getSQL(sSQL.SEL_QUEST_LIST);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1, sno);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				SurveyVO sVO = new SurveyVO();
				sVO.setSbody(rs.getString("sbody"));
				sVO.setSno(rs.getInt("sno"));
				sVO.setQno(rs.getInt("qno"));
				sVO.setUpno(rs.getInt("upno"));
				sVO.setQbody(rs.getString("qbody"));
				
				list.add(sVO);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return list;
	}
	
	// 설문응답 데이터베이스 작업 전담 처리함수
		public int addAnswer(ArrayList<SurveyVO> list) {
			int cnt = 0;
			con = db.getCon();
			String sql = sSQL.getSQL(sSQL.ADD_ANSWER);
			
			try {
				for(int i = 0 ; i < list.size() ; i++ ) {
					pstmt = db.getPSTMT(con, sql);
					pstmt.setString(1, list.get(i).getId());
					pstmt.setInt(2, list.get(i).getQno());
					
					cnt += pstmt.executeUpdate();
					db.close(pstmt);
				}
			} catch(Exception e){
				db.close(pstmt);
				e.printStackTrace();
			} finally {
				db.close(con);
			}
			return cnt;
		}
	
	// 설문 결과 조회 전담 처리함수
	public ArrayList<SurveyVO> getResult(int sno){
		ArrayList<SurveyVO> list = new ArrayList<SurveyVO>();
		con = db.getCon();
		String sql = sSQL.getSQL(sSQL.SEL_ANSWER_RESULT);
		
		pstmt = db.getPSTMT(con, sql);
		
		try {
			pstmt.setInt(1, sno);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				SurveyVO sVO = new SurveyVO();
				sVO.setSbody(rs.getString("sbody"));
				sVO.setQno(rs.getInt("qno"));
				sVO.setQbody(rs.getString("qbody"));
				sVO.setSno(rs.getInt("sno"));
				sVO.setUpno(rs.getInt("upno"));
				sVO.setCnt(rs.getInt("cnt"));
				sVO.setPer(rs.getDouble("per"));
				
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
