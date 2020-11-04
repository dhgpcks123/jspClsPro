package com.increpas.cls.dao;

import java.sql.*;
import java.util.*;

import db.*;
import com.increpas.cls.sql.*;
import com.increpas.cls.vo.*;

public class MemberDAO {
	ClsDBCP db;
	Connection con;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	MemberSQL mSQL;
	
	public MemberDAO() {
		db = new ClsDBCP();
		mSQL = new MemberSQL();
		
		
	}
	
	// 로그인 데이터베이스 작업 전담 처리함수
	public int getLoginCnt(String sid, String spw) {
		int cnt = 0;
		// 할 일
		// 1. 커넥션 얻어오고
		con = db.getCon();
		// 2. 질의명령 가져오고
		String sql = mSQL.getSQL(mSQL.SEL_LOGIN_CNT);
		// 3. PreparedStatement 가져오고
		
		pstmt = db.getPSTMT(con, sql);
		try {
		// 4. 질의 명령 완성하고
			pstmt.setString(1, sid);
			pstmt.setString(2, spw);
		// 5. 질의 명령 보내고 결과 받고
			rs = pstmt.executeQuery();
		// 6. 결과 꺼내고
			rs.next();
			cnt = rs.getInt("cnt");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		
		// 7 . 데이터 반환하고
		return cnt;
	}

	//아이디 체크 데이터베이스 전담 처리함수
	public int getIdCnt(String id) {
		int cnt = 0 ;
		
		// 할 일
		// 1. 커넥션 얻어와
		con = db.getCon();
		// 2. 질의명령 가져오고
		String sql = mSQL.getSQL(mSQL.SEL_ID_CNT);
		// 3. 스테이트먼트 가져오고
		pstmt = db.getPSTMT(con, sql);
		try {
		// 4. 질의명령 완성하고
			pstmt.setString(1, id);
		// 5. 질의명령 보내고 결과 받고
			rs = pstmt.executeQuery();
			
		// 6. 결과 꺼내고
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
	
	
	//아바타 데이터 가져오기 전담 처리함수
	public ArrayList<AvatarVO> getAvtAll(){
		ArrayList<AvatarVO> list = new ArrayList<AvatarVO>();
		// 할일
		// 1. 커넥션 얻어오고
		con = db.getCon();
		// 2. 질의명령 가져오고
		String sql = mSQL.getSQL(mSQL.SEL_AVT_ALL);
		// 3. Statement 얻어오고
		stmt = db.getSTMT(con);
		// 4. 질의명령 보내서 결과 받고
		try {
			rs = stmt.executeQuery(sql);
			// 4.1 list에 VO를 하나씩 완성해서 채워준다.
			//	질의명령 결과가 여러개의 아바타 정보를 조회를 할 것이기 때문에
			//	여러개의 데이터가 만들어진다.
			while(rs.next()) {
				AvatarVO aVo = new AvatarVO();
				aVo.setAno(rs.getInt("ano"));
				aVo.setSavename(rs.getString("sname"));
				aVo.setGen(rs.getString("gen"));
				
				list.add(aVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(stmt);
			db.close(con);
		}
		
		// 5. 리스트 반환해주고
		
		return list;
	}
	
	public int addMemb(MemberVO mVO) {
		int cnt = 0;
		// 할일
		// 1. Connection
		con = db.getCon();
		// 2. 질의명령
		String sql = mSQL.getSQL(mSQL.ADD_MEMB);
		// 3. PreparedStatement
		pstmt = db.getPSTMT(con, sql);
		// 4. 질의명령 완성하고
		try {
			pstmt.setString(1, mVO.getId());
			pstmt.setString(2, mVO.getPw());
			pstmt.setString(3, mVO.getName());
			pstmt.setString(4, mVO.getMail());
			pstmt.setString(5, mVO.getGen());
			pstmt.setInt(6, mVO.getAvt());
			// 5. 질의명령 보내고 결과받고
			cnt = pstmt.executeUpdate();
			// 반환값 cnt의 의미는 변경된 데이터의 수를 의미한다.
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		
		
		// 6. 결과 반환해주고
		return cnt;
	}
	
	//회원 정보 반환해주는 함수
	public MemberVO getMembAll(String id) {
		MemberVO mVO = new MemberVO();
		MemberSQL mSQL = new MemberSQL();
		con = db.getCon();
		String sql = mSQL.getSQL(mSQL.SEL_INFO_ALL);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				mVO.setMno(rs.getInt("mno"));
				mVO.setId(rs.getString("id"));
				mVO.setName(rs.getString("name"));
				mVO.setMail(rs.getString("mail"));
				mVO.setGen(rs.getString("gen"));
				mVO.setJoinDate(rs.getDate("joindate"));
				mVO.setJoinTime(rs.getTime("joindate"));
				mVO.setSname(rs.getNString("sname"));
			};
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return mVO;
	}
	
}
