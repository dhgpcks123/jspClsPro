package com.increpas.cls.sql;

public class ReBoardSQL {
	public final int SEL_RBD_ALL	=1001;
	public final int ADD_RBD	= 3001;
	public final int SEL_RBD_TCNT	= 1002;
	public final int SEL_RBD_ROW	= 1003;
	
	
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		switch(code) {
			case ADD_RBD :
				buff.append("INSERT INTO reboard(bno, b_mno, body) ");
				buff.append("VALUES( ");
				buff.append("	(SELECT NVL(MAX(bno)+1, 10000) FROM reboard),  ");
				buff.append("   (SELECT mno FROM member WHERE isshow='Y' AND id= ? ), ");
				buff.append("    ? ");
				buff.append(") ");
	
				break;
			case SEL_RBD_ALL :
				buff.append("SELECT ");
				buff.append("	bno, id, body, wdate ");
				buff.append("FROM ");
				buff.append("	reboard, member "); // b_mno랑 id있는 테이블이랑 연결해서 SELECT문 작성해야합니다
				buff.append("WHERE ");
				buff.append("	reboard.isshow='Y' ");
				buff.append("	AND b_mno=mno ");
				buff.append("ORDER BY ");
				buff.append("	bno desc ");
				break;
			case SEL_RBD_TCNT :
				buff.append("SELECT ");
				buff.append("	COUNT(*) total ");
				buff.append("FROM ");
				buff.append("	reboard"); // b_mno랑 id있는 테이블이랑 연결해서 SELECT문 작성해야합니다
				buff.append("WHERE ");
				buff.append("	reboard.isshow='Y' ");
				break;
			case SEL_RBD_ROW:
					
				break;
		}
		return buff.toString();
	
	}
}
