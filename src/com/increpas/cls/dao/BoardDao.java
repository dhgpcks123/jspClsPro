package com.increpas.cls.dao;

import db.*;
import com.increpas.cls.sql.*;
import com.increpas.cls.util.PageUtil;
import com.increpas.cls.vo.*;

import java.util.*;
import java.sql.*;


public class BoardDao {
	private ClsDBCP db;
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	ResultSet rs;
	BoardSQL bSQL;
	
	public BoardDao() {
		db = new ClsDBCP();
		bSQL = new BoardSQL();
	}
	
	// 게시판 리스트 가져오기 전담 처리함수
	public ArrayList<BoardVO> getBoardList(){
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		con = db.getCon();
		String sql = bSQL.getSQL(bSQL.SEL_BOARD_LIST);
		stmt =db.getSTMT(con);
		try {
			rs = pstmt.executeQuery(sql);
			
			while(rs.next()) {
				BoardVO bVO = new BoardVO();
				bVO.setBno(rs.getInt("bno"));
				bVO.setTitle(rs.getString("title"));
				bVO.setBody(rs.getString("body"));
				bVO.setId(rs.getString("id"));
				bVO.setClick(rs.getInt("bclick"));
				bVO.setWdate(rs.getDate("bdate"));
				bVO.setWtime(rs.getTime("bdate"));
				list.add(bVO);
				
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
	public ArrayList<BoardVO> getBoardList(PageUtil page){
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		con = db.getCon();
		String sql = bSQL.getSQL(bSQL.SEL_BOARD_PAGE);
		pstmt =db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1, page.getStartCont());
			pstmt.setInt(2, page.getEndCont());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardVO bVO = new BoardVO();
				bVO.setBno(rs.getInt("bno"));
				bVO.setTitle(rs.getString("title"));
				bVO.setBody(rs.getString("body"));
				bVO.setId(rs.getString("id"));
				bVO.setClick(rs.getInt("bclick"));
				bVO.setWdate(rs.getDate("bdate"));
				bVO.setWtime(rs.getTime("bdate"));
				bVO.setCnt(rs.getInt("cnt"));
				
				list.add(bVO);
				
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

	// 게시판 글 작성 데이터베이스 작업 전담 처리함수
	public int addBoard(BoardVO bVO) {
		int cnt = 0;
		con = db.getCon();
		String sql = bSQL.getSQL(bSQL.ADD_BOARD);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, bVO.getId());
			pstmt.setString(2, bVO.getTitle());
			pstmt.setString(3, bVO.getBody());
			
			cnt = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		
		return cnt;
	}
	
	// 회원 아이디 리스트 가져오기 전담 처리함수
	public ArrayList<String> getIdList(){
		ArrayList<String> list = new ArrayList<String>();
		con = db.getCon();
		String sql = bSQL.getSQL(bSQL.SEL_MEMB_LIST);
		stmt = db.getSTMT(con);
		try {
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				list.add(rs.getString("id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			db.close(rs);
			db.close(stmt);
			db.close(con);
		}
		return list;
	}
	
	//전체 페이지수 totalCount반환해주는 함수
	public int getTotalCnt() {
		int cnt = 0;
		con = db.getCon();
		String sql = bSQL.getSQL(bSQL.SEL_BOARD_CNT);
		stmt = db.getSTMT(con);
		try {
			rs = stmt.executeQuery(sql);
			rs.next();
			cnt = rs.getInt("cnt");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(stmt);
			db.close(con);
		}
		
		return cnt;
		
	}
	
	
	//bno받아서 detail뿌려주는 함수
	public ArrayList<BoardVO> getDetail(int bno){
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		con = db.getCon();
		String sql = bSQL.getSQL(bSQL.SEL_MEMB_BODY);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1, bno);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardVO bVO = new BoardVO();
				bVO.setBno(rs.getInt("bno"));
				bVO.setTitle(rs.getString("title"));
				bVO.setBody(rs.getString("body"));
				bVO.setWdate(rs.getDate("bdate"));
				bVO.setWtime(rs.getTime("bdate"));
				bVO.setId(rs.getString("id"));
				bVO.setClick(rs.getInt("bclick"));
				
				list.add(bVO);
			};
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		
		return list;
	}
	
	// 파일정보 입력 전담 처리함수
	public int addFile(FileVO fVO) {
		int cnt = 0;
		con = db.getCon();
		String sql = bSQL.getSQL(bSQL.ADD_FILE);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, fVO.getId());
			pstmt.setString(2, fVO.getOriname());
			pstmt.setString(3, fVO.getSavename());
			pstmt.setLong(4, fVO.getLen());
			
			cnt = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	
	// 파일정보 입력 전담 처리함수2
	public int addFile(ArrayList<FileVO> list) {
		int cnt = 0;
		// 위에서 만든 단일파일 업로드 함수를 재사용하기로 한다.
		for(FileVO fVO : list) {
			cnt += addFile(fVO);
		}
		
		return cnt;
	}
	
	// 상세보기 정보 보기 전담 처리함수
	public HashMap<String, Object> getDetailIMG(int bno) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		FileVO fVO = null;
		BoardVO bVO = null;
		
		con = db.getCon();
		String sql = bSQL.getSQL(bSQL.SEL_DETAIL_IMG);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			rs.next();
			
			fVO = new FileVO();
			bVO = new BoardVO();
			
			bVO.setId(rs.getString("id"));
			bVO.setBno(rs.getInt("bno"));
			bVO.setTitle(rs.getString("title"));
			bVO.setBody(rs.getString("body").replaceAll("\r\n",  "<br>"));
			bVO.setClick(rs.getInt("bclick"));
			map.put("BoardVO", bVO);
			
			fVO.setOriname(rs.getString("oriname"));
			fVO.setSavename(rs.getString("savename"));
			fVO.setDir(rs.getString("dir"));
			
			map.put("FileVO", fVO);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		
		
		return map;
	}
	
	//cnt 업데이트 해주는 함수
	public int getUpCnt(int bno) {
		int cnt = 0;
		con = db.getCon();
		String sql = bSQL.getSQL(bSQL.UPD_BOARD_CLICK);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1, bno);
			pstmt.setInt(2, bno);
			
			cnt = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		
		return cnt;
	}
	
	
	// 게시판 수정 전담 처리함수 doc DynamicQuery.txt 참고
	public int editBoard(BoardVO bVO) {
		int cnt = 0;
		con = db.getCon();
		String sql = ProcSql(bSQL.getSQL(bSQL.EDIT_BOARD), bVO);
		pstmt = db.getPSTMT(con, sql);
		try {
			// 글 번호 채워주고
			pstmt.setInt(1, bVO.getBno());
			
			cnt = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		
		return cnt;
	}
	
	
	// 게시글 수정 질의명령 전담 처리함수
	public String ProcSql(String sql, BoardVO bVO) {
		if(bVO.getTitle() != null && bVO.getBody() == null) {
			sql = sql.replaceAll("###", "title =" +bVO.getTitle()+"'");
		} else if(bVO.getTitle() == null && bVO.getBody() != null) {
			sql = sql.replaceAll("###", "body ="+bVO.getBody()+"'");
		} else if(bVO.getTitle() != null && bVO.getBody() != null) {
			sql = sql.replaceAll("###", "title ="+bVO.getTitle()+", body ="+bVO.getBody()+"'");
		}
		
		return sql;
	}
}






















