package com.increpas.cls.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

import com.increpas.cls.sql.GBoardSQL;
import com.increpas.cls.vo.*;
import com.increpas.cls.util.*;

import db.ClsDBCP;

public class GBoardDao {
	private ClsDBCP db;
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private GBoardSQL gSQL;

	public GBoardDao() {
		db = new ClsDBCP();
		gSQL = new GBoardSQL();
		
	}

	
	public int addGBoard(String id, String body) {
		int cnt = 0;
		// con
			con = db.getCon();
		// sql
			String sql = gSQL.getSQL(gSQL.ADD_GBD);
		// pstmt
			try {
				pstmt = db.getPSTMT(con, sql);
				// 질의명령 완성하고
				pstmt.setString(1, id);
				pstmt.setString(2, body);
				System.out.println("### id : "+ id);
				System.out.println("### body : "+ body);
				// 보내고 결과받고
				cnt = pstmt.executeUpdate();
				System.out.println("### 반환cnt : "+ cnt);
				
			}catch(Exception e){
				e.printStackTrace();
			}finally {
				db.close(pstmt);
				db.close(con);
			}
		//결과 값 반환하고
		return cnt;
	}
	
	
	// 방명록 등록 데이터베이스작업 전담처리함수
	public int addGBoard(ArrayList<HashMap<String, String>> list) {
		int cnt = 0;
		// con
			con = db.getCon();
		// sql
			String sql = gSQL.getSQL(gSQL.ADD_GBD);
		// pstmt
			try {
				for(int i = 0 ; i< list.size(); i ++) {
					pstmt = db.getPSTMT(con, sql);
					// 질의명령 완성하고
					pstmt.setString(1, list.get(i).get("id"));
					pstmt.setString(2, list.get(i).get("body"));
					// 보내고 결과받고
					cnt += pstmt.executeUpdate();
					db.close(pstmt);
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally {
				db.close(con);
			}
		//결과 값 반환하고
		return cnt;
	}

	//방명록 리스트 꺼내오기 전담 처리함수
	public ArrayList<GuestBoardVO> getGBoardList(){
		ArrayList<GuestBoardVO> list = new ArrayList<GuestBoardVO>();
		con = db.getCon();
		stmt = db.getSTMT(con);
		
		String sql = gSQL.getSQL(gSQL.SEL_ALL_GBD);
		try {
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				GuestBoardVO gVO = new GuestBoardVO();
				gVO.setGno(rs.getInt("gno"));
				gVO.setId(rs.getString("id"));
				gVO.setBody(rs.getString("body"));
				gVO.setAvatar(rs.getString("avatar"));
				gVO.setWdate(rs.getDate("wdate"));
				gVO.setWtime(rs.getTime("wdate"));
			
				list.add(gVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(stmt);
			db.close(con);
		}
		
		return list;
	}
	
	//방명록 게시글 리스트 꺼내오기 전담 처리함수
	public ArrayList<GuestBoardVO> getGBoardList(PageUtil page){
		ArrayList<GuestBoardVO> list = new ArrayList<GuestBoardVO>();
		con = db.getCon();
		
		String sql = gSQL.getSQL(gSQL.SEL_GBD_ROW);
		pstmt = db.getPSTMT(con, sql);
		try {
			
			//질의 명령 완성하고
			pstmt.setInt(1, page.getStartCont());
			pstmt.setInt(2, page.getEndCont());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				GuestBoardVO gVO = new GuestBoardVO();
				
				gVO.setRno(rs.getInt("rno"));
				gVO.setGno(rs.getInt("gno"));
				gVO.setId(rs.getString("id"));
				gVO.setBody(rs.getString("body"));
				gVO.setAvatar(rs.getString("avatar"));
				gVO.setWdate(rs.getDate("wdate"));
				gVO.setWtime(rs.getTime("wdate"));
				
				list.add(gVO);
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
	
	//글 작성여부 카운트
	public int getIdCnt(String id) {
		// 반환값 변수
		int cnt = 0;
		
		//connection
		con = db.getCon();
		//q
		String sql = gSQL.getSQL(gSQL.SEL_ID_CNT);
		pstmt = db.getPSTMT(con, sql);
		try {
			//pstmt
			pstmt.setString(1, id);
			//rs
			rs = pstmt.executeQuery();
			//결과는 한 행
			rs.next();
			cnt = rs.getInt("cnt");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		
		return cnt;
	}
	
	// 총 게시물 가져오기 전담 처리함수
	public int getTotal() {
		int total = 0;
		//con
		con = db.getCon();
		//sql
		String sql = gSQL.getSQL(gSQL.SEL_GBD_TCNT);
		//stmt
		stmt = db.getSTMT(con);
		//완성하고보내서
		try {
			
			rs = stmt.executeQuery(sql);
			rs.next();
			total = rs.getInt("total");
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(stmt);
			db.close(con);
		}
		
		//반환하고
		return total;
	}
	
	
}
