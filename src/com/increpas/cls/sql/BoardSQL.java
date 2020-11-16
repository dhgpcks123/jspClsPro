package com.increpas.cls.sql;

public class BoardSQL {
	public final int SEL_BOARD_LIST		= 1001;
	public final int SEL_BOARD_PAGE		= 1002;
	public final int SEL_BOARD_CNT		= 1003;
	public final int SEL_MEMB_LIST		= 1004;
	public final int SEL_MEMB_BODY		= 1005;
	
	public final int ADD_BOARD			= 3001;
	public final int ADD_FILE			= 3002;
	
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		
		switch(code) {
		case SEL_BOARD_LIST:
			buff.append("SELECT ");
			buff.append("	bno, title, body, id, bdate, bclick ");
			buff.append("FROM ");
			buff.append("	board, member ");
			buff.append("WHERE ");
			buff.append("	isshow = 'Y' ");
			buff.append("	AND bmno = mno ");
			break;
		case SEL_BOARD_CNT:
			buff.append("SELECT ");
			buff.append("    COUNT(*) cnt "); 
			buff.append("FROM "); 
			buff.append("    board "); 
			buff.append("WHERE "); 
			buff.append("    bisshow = 'Y' "); 
			break;
		case SEL_BOARD_PAGE:
			buff.append("SELECT ");
			buff.append("    * "); 
			buff.append("FROM( ");
			buff.append("    SELECT ");
			buff.append("        rownum rno, b.* ");
			buff.append("    FROM ");
			buff.append("        (SELECT ");
			buff.append("           id, bmno, bno, title, bdate, bclick, body ");
			buff.append("        FROM ");
			buff.append("            board, member ");
			buff.append("        WHERE ");
			buff.append("        	 bisshow='Y' ");
			buff.append("        	 AND mno = bmno ");
			buff.append("        ORDER BY ");
			buff.append("            bno DESC) b ");
			buff.append("    ) ");
			buff.append("WHERE ");
			buff.append("    rno BETWEEN ? AND ? ");
			break;
		case SEL_MEMB_LIST:
			buff.append("SELECT ");
			buff.append("	id ");
			buff.append("FROM ");
			buff.append("	member ");
			buff.append("WHERE ");
			buff.append("	isshow = 'Y' ");
			break;
		case SEL_MEMB_BODY:
	 		buff.append("SELECT");
			buff.append("    bno, title, body, bdate, id, bclick ");
			buff.append("FROM ");
			buff.append("    board, member ");
			buff.append("WHERE ");
			buff.append("    bmno = mno ");
			buff.append("    AND bno = ? ");
			break;
		case ADD_BOARD:
			buff.append("INSERT INTO ");
			buff.append(" 	board(bno, bmno, title, body) ");
			buff.append("VALUES( ");
			buff.append(" (SELECT NVL(MAX(bno) + 1, 10001) FROM board), ");
			buff.append(" (SELECT mno FROM member WHERE id = ? ), ");
			buff.append(" ?, ? ");
			buff.append(" ) ");
			break;
		}
		
		return buff.toString();
	}
	
}
