package com.increpas.cls.sql;

public class MemberSQL {
	public final int SEL_LOGIN_CNT = 1001;
	public final int SEL_ID_CNT = 1002;
	public final int SEL_AVT_ALL = 1003;
	
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
			buff.append(" SELECT");
			buff.append(" 	ano, afile AS sname, gen, "); //별칭 꼭 줘야합니다!!
			buff.append(" FROM");
			buff.append(" 	avatar");
			break;
		}
		
		return buff.toString();
	}
	
}
