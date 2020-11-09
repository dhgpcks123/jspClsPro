package com.increpas.cls.dao;

import java.sql.*;
import java.util.*;

import com.increpas.cls.sql.*;
import com.increpas.cls.util.PageUtil;
import com.increpas.cls.vo.*;

import db.ClsDBCP;

public class ReBoardDao {
	private ClsDBCP db;
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private ReBoardSQL rSQL;
	
	public ReBoardDao() {
		db = new ClsDBCP();
		rSQL = new ReBoardSQL();
	}

	public int addRBoard(ArrayList<HashMap<String, String>> list) {
		int cnt = 0;
		//con
			con = db.getCon();
		//sql
			String sql = rSQL.getSQL(rSQL.ADD_RBD);
		//pstmt
			try {
				for(int i = 0 ; i <list.size(); i++) {
					pstmt = db.getPSTMT(con, sql);
					//질의명령 완성하고
					pstmt.setString(1, list.get(i).get("id"));
					pstmt.setString(2, list.get(i).get("body"));
					cnt += pstmt.executeUpdate();
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				db.close(pstmt);
				db.close(con);
			}
		//결과 값 반환하고
		return cnt;
	}
	//방명록 리스트 가져오기 전담처리함수
	public ArrayList<ReBoardVO> getBoardList() {
		ArrayList<ReBoardVO> list = new ArrayList<ReBoardVO>();
		ReBoardVO rVO;
		
		con = db.getCon();
		String sql = rSQL.getSQL(rSQL.SEL_RBD_ALL);
		
		stmt = db.getSTMT(con);
		try {
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				rVO = new ReBoardVO();
				
				rVO.setBno(rs.getInt("bno"));
				rVO.setId(rs.getString("id"));
				rVO.setBody(rs.getString("body"));
				rVO.setJoinDate(rs.getDate("wdate"));
				rVO.setJoinTime(rs.getTime("wdate"));
				
				list.add(rVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.close(rs);
			db.close(stmt);
			db.close(con);
		}
		
		
		return list;
		
	}
	
	//방명록 리스트 가져오기 전담처리함수
	public ArrayList<ReBoardVO> getBoardList(PageUtil page) {
		ArrayList<ReBoardVO> list = new ArrayList<ReBoardVO>();
		ReBoardVO rVO;
		
		con = db.getCon();
		String sql = rSQL.getSQL(rSQL.SEL_RBD_ROW);
		
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1, page.getStartCont());
			pstmt.setInt(2, page.getEndCont());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				rVO = new ReBoardVO();
				
				rVO.setBno(rs.getInt("bno"));
				rVO.setId(rs.getString("id"));
				rVO.setBody(rs.getString("body"));
				rVO.setJoinDate(rs.getDate("wdate"));
				rVO.setJoinTime(rs.getTime("wdate"));
				
				list.add(rVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.close(rs);
			db.close(stmt);
			db.close(con);
		}
		
		
		return list;
		
	}
	
	//총 갯수 구하는 함수
	public int getTotal() {
		int total = 0;
		con = db.getCon();
		stmt = db.getSTMT(con);
		String sql = rSQL.getSQL(rSQL.SEL_RBD_TCNT);
		try {
			rs = stmt.executeQuery(sql);
			total = rs.getInt("cnt");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.close(rs);
			db.close(stmt);
			db.close(con);
		}
		return total;
	}
	
	
}
