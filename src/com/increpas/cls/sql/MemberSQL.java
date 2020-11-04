package com.increpas.cls.sql;

public class MemberSQL {
	public final int SEL_LOGIN_CNT = 1001;
	public final int SEL_ID_CNT = 1002;
	public final int SEL_AVT_ALL = 1003;
	public final int SEL_INFO_ALL = 1004;
	public final int ADD_MEMB = 3001;
	
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		switch(code) {
		case SEL_LOGIN_CNT :
			buff.append(" SELECT");
			buff.append(" 	COUNT(*) cnt"); //별칭 꼭 줘야합니다!!
			buff.append(" FROM");
			buff.append(" 	member");
			buff.append(" WHERE");
			buff.append(" 	id=?");
			buff.append(" 	AND pw=?");
			break;
		case SEL_ID_CNT :
			buff.append("SELECT ");
			buff.append(" 	COUNT(*) cnt "); //별칭 꼭 줘야합니다!!
			buff.append("FROM ");
			buff.append(" 	member ");
			buff.append("WHERE ");
			buff.append(" 	id = ? ");
			break;
		case SEL_AVT_ALL :
			buff.append("SELECT ");
			buff.append("	ano, afile AS sname, gen ");
			buff.append("FROM ");
			buff.append("	avatar ");
			break;
		case ADD_MEMB :
			buff.append("INSERT INTO ");
			buff.append("	member(mno, id, pw, name, mail, gen, avt) ");
			buff.append("VALUES( ");
			buff.append("	 ( ");
			buff.append("	 SELECT NVL(MAX(mno) +1, 1001) FROM member ");
			buff.append("	 ), ");
			buff.append("	 ?, ?, ?, ?, ?, ? ");
			buff.append(") ");
			break;
		case SEL_INFO_ALL :
			buff.append("SELECT ");
			buff.append("	m.mno, m.id, m.pw, m.name, m.mail, m.gen, m.joindate, at.afile As sname ");
			buff.append("FROM ");
			buff.append("	member m, avatar at ");
			buff.append("WHERE ");
			buff.append("	m.avt=at.ano");
			buff.append("	AND id=? ");
			break;
		}
		
		return buff.toString();
	}
	
}
