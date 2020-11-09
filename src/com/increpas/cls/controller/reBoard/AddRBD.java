package com.increpas.cls.controller.reBoard;

import javax.servlet.http.*;
import java.util.*;
import com.increpas.cls.controller.ClsMain;
import com.increpas.cls.dao.ReBoardDao;

public class AddRBD implements ClsMain {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		
		String view="/cls/reBoard/reBoardList.cls";
		ReBoardDao rDao = new ReBoardDao();
		ArrayList<HashMap<String, String>> list = getList();
		int cnt = rDao.addRBoard(list);
		System.out.println("### 데이터 입력 수 : "+ cnt);
		req.setAttribute("isRedirect", true);
		
		return view;
	}

	public ArrayList<HashMap<String, String>> getList(){
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map1 = new HashMap<String, String>();
		map1.put("id", "euns");
		map1.put("body", "내가 일등이다~~~!!");
		HashMap<String, String> map2 = new HashMap<String, String>();
		map2.put("id", "joo");
		map2.put("body", "더미데이터를 속하는 영광을~");
		HashMap<String, String> map3 = new HashMap<String, String>();
		map3.put("id", "jiwoo");
		map3.put("body", "안 보고코딩할 수 있으면 좋겟다");
		HashMap<String, String> map4 = new HashMap<String, String>();
		map4.put("id", "jjang");
		map4.put("body", "어렵다 어려오..");
		HashMap<String, String> map5 = new HashMap<String, String>();
		map5.put("id", "dhgpcks");
		map5.put("body", "제발 지우지 마세요~~");
		
		HashMap<String, String> map6 = new HashMap<String, String>();
		map1.put("id", "euns");
		map1.put("body", "이번엔 6등");
		HashMap<String, String> map7 = new HashMap<String, String>();
		map2.put("id", "joo");
		map2.put("body", "영차영차 더미데이터를 늘리자");
		HashMap<String, String> map8 = new HashMap<String, String>();
		map3.put("id", "jiwoo");
		map3.put("body", "페이지 밑에 숫자넣어서 페이지이동시켜");
		HashMap<String, String> map9 = new HashMap<String, String>();
		map4.put("id", "jjang");
		map4.put("body", "ㅠㅠㅠㅠㅠㅠㅠㅠㅠ괜찮아");
		HashMap<String, String> map10 = new HashMap<String, String>();
		map5.put("id", "dhgpcks");
		map5.put("body", "잘될거야~");
		
		HashMap<String, String> map11 = new HashMap<String, String>();
		map1.put("id", "euisan");
		map1.put("body", "안녕하세요 케케케");
		HashMap<String, String> map12 = new HashMap<String, String>();
		map2.put("id", "sun");
		map2.put("body", "더미데이터 쌓기");
		HashMap<String, String> map13 = new HashMap<String, String>();
		map3.put("id", "hh");
		map3.put("body", "ㅎㅎ 한훈입니다. 25자이상 쌓기를 할 예정입니다"
				+ "그래야 이게 데이터 확인이 되거든요! 25자 이상이 됐을까요?"
				+ "혹시 모르니 한 줄을 더 쌓도록 하겠습니다~ 과연 25자 이상은 어떻게 처리할까요~~");
		HashMap<String, String> map14 = new HashMap<String, String>();
		map4.put("id", "smkim");
		map4.put("body", "I'm smkim");
		HashMap<String, String> map15 = new HashMap<String, String>();
		map5.put("id", "jieun");
		map5.put("body", "중도하차합니다~ @.@ 너무 어려워요 여기도 25자 이상 쌓아보도록 할게요"
				+ "영차영차영차 글씨가 더 쌓이도록 합니다. 얼마나 쌓아야 25자가 될까요?"
				+ "영어랑 한긍리랑 또 다르니 잘 모르겠지만 이 정도면 되지 않을까요?");
		
		list.add(map1);
		list.add(map2);
		list.add(map3);
		list.add(map4);
		list.add(map5);
		list.add(map6);
		list.add(map7);
		list.add(map8);
		list.add(map9);
		list.add(map10);
		list.add(map11);
		list.add(map12);
		list.add(map13);
		list.add(map14);
		list.add(map15);
		
		return list;
	}
	
}

