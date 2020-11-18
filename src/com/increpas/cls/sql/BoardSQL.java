package com.increpas.cls.sql;

public class BoardSQL {
	public final int SEL_BOARD_LIST		= 1001;
	public final int SEL_BOARD_PAGE		= 1002;
	public final int SEL_BOARD_CNT		= 1003;
	public final int SEL_MEMB_LIST		= 1004;
	public final int SEL_MEMB_BODY		= 1005;
	public final int SEL_DETAIL_IMG		= 1006;
	
	public final int UPD_BOARD_CLICK	= 2001;

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
			buff.append("    bno, rno, body, id, bno, title, bdate, bclick, NVL(cnt, 0) CNT "); 
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
			buff.append("    ), ");
			buff.append("        (SELECT ");
			buff.append("   	     fbno, COUNT(*) cnt ");
			buff.append("        FROM ");
			buff.append("        	 fileinfo ");
			buff.append("        GROUP BY ");
			buff.append("        	 fbno) ");
			buff.append("WHERE ");
			buff.append("    rno BETWEEN ? AND ? ");
			buff.append("    AND bno = fbno(+) ");
			buff.append("ORDER BY ");
			buff.append("    rno ");
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
		case SEL_DETAIL_IMG:
			buff.append("SELECT");
			buff.append("    id, bno, title, body, bdate, bclick, oriname, savename, dir ");
			buff.append("FROM ");
			buff.append("    board, fileinfo, member ");
			buff.append("WHERE ");
			buff.append("    fbno(+) = bno ");
			buff.append("    AND bno = ? ");
			buff.append("    AND bmno = mno ");
			break;
			
		case UPD_BOARD_CLICK:
			buff.append("UPDATE  board "); 
			buff.append("SET "); 
			buff.append("    bclick =(SELECT MAX(bclick)+1 FROM board WHERE bno=? ) "); 
			buff.append("WHERE "); 
			buff.append("    bno=? ");
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
		case ADD_FILE:
			buff.append("INSERT INTO" ); 
			buff.append("    fileinfo(fno, fbno, dir, oriname, savename, len) "); 
			buff.append("VALUES( "); 
			buff.append("    (SELECT NVL(MAX(fno)+1, 1000001) FROM fileinfo), "); 
			buff.append("    ( "); 
			buff.append("        SELECT "); 
			buff.append("            max(bno) "); 
			buff.append("        FROM "); 
			buff.append("            board, member "); 
			buff.append("        WHERE "); 
			buff.append("            bmno = mno "); 
			buff.append("            AND id = ? "); 
			buff.append("    ), '/img/upload/', ?, ?, ? "); 
			buff.append(") ");
			break;
			
			
		}
		
		return buff.toString();
	}
	
}
