package com.increpas.cls.sql;

public class SurveySQL {
	public final int SEL_CURR_LIST	=	1001;
	public final int SEL_QUEST_LIST	=	1002;
	
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		switch(code) {
		case SEL_CURR_LIST:
			buff.append("SELECT ");
			buff.append("	sno, sbody, ");
			buff.append("	(SELECT "); 
			buff.append("            count(*) "); 
			buff.append("        FROM "); 
			buff.append("            surveyQuest, surveyAnswer, member "); 
			buff.append("        WHERE "); 
			buff.append("            sino = sno "); 
			buff.append("            AND sqno = sa_qno "); 
			buff.append("            AND mno = sa_mno "); 
			buff.append("            AND id = ? "); 
			buff.append("    ) cnt ");
			buff.append("FROM ");
			buff.append("	surveyInfo ");
			buff.append("WHERE ");
			buff.append("	sysdate BETWEEN sstart AND send ");
			break;
		case SEL_QUEST_LIST:
			buff.append("SELECT "); 
			buff.append("    sqbody AS qbody, upno, (level-1) step "); 
			buff.append("FROM "); 
			buff.append("    surveyQuest "); 
			buff.append("WHERE "); 
			buff.append("    sino = ? "); 
			buff.append("START WITH "); 
			buff.append("    UPNO IS NULL "); 
			buff.append("CONNECT BY "); 
			buff.append("    PRIOR sqno=upno "); 
			buff.append("ORDER SIBLINGS BY "); 
			buff.append("    SQNO "); 
			break;
			
		}
		
		return buff.toString();
	}
	
	
}
