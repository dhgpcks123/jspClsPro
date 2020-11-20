package com.increpas.cls.sql;

public class DynamicQueryTest {

	public DynamicQueryTest() {
		BoardSQL bSQL = new BoardSQL();
		String sql = bSQL.getSQL(bSQL.EDIT_BOARD);
		System.out.println("1#### edit sql : "+sql);
		
		//타이틀을 수정하는 경우
		sql = sql.replaceAll("###", "title = ?");
		System.out.println("2#### edit sql : "+sql);
		
		//타이틀과 본문 모두를 수정하는 경우
		String sql1 = bSQL.getSQL(bSQL.EDIT_BOARD);
		sql1 = sql1.replaceAll("###", "title = ?, body = ?");
		System.out.println("3#### edit sql1 : "+sql1);
	}
	
	public static void main(String[] args) {
		new DynamicQueryTest();
	}
}
