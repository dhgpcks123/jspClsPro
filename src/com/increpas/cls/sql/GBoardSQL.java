package com.increpas.cls.sql;

public class GBoardSQL {
	public final int SEL_ALL_GBD	= 1001;
	public final int SEL_ID_CNT		= 2001;
	public final int ADD_GBD	= 3001;
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		switch(code) {
		case ADD_GBD:
			buff.append("INSERT INTO guestboard(gno, g_mno, body) ");
			buff.append("VALUES( " );
			buff.append("	(SELECT NVL(MAX(gno)+1, 1001) FROM guestboard), " );
			buff.append("	(SELECT mno FROM member WHERE isshow= 'Y' AND id=? ), " );
			buff.append("	? " );
			buff.append(") ");
			break;
		case SEL_ALL_GBD:
			buff.append("SELECT "); 
			buff.append("	gno, id, body, wdate, afile avatar "); 
			buff.append("FROM "); 
			buff.append("	guestboard, member, avatar "); 
			buff.append("WHERE "); 
			buff.append("	g_mno = mno "); 
			buff.append("	AND avt = ano "); 
			buff.append("	AND guestboard.isshow = 'Y' "); 
			buff.append("	AND member.isshow = 'Y' "); 
			buff.append("ORDER BY "); 
			buff.append("	wdate DESC "); 
			break;
		case SEL_ID_CNT:
			buff.append("SELECT "); 
			buff.append("	COUNT(*) cnt "); 
			buff.append("FROM "); 
			buff.append("	guestboard, member "); 
			buff.append("WHERE "); 
			buff.append("	g_mno = mno "); 
			buff.append("	AND id = ? "); 
			break;
		}
		
		return buff.toString();
	}
	
	
	
}
