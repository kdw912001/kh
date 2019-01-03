package test.map;

import java.util.*;

public class TestTreeMap {

	public static void main(String[] args) {
		// TreeMap test
		//자동 정렬기능이 내장된 Map 클래스
		HashMap hmap = new HashMap();
		
		for(int k=1; k<6; k++) {
			hmap.put((int)(Math.random()*100)+1,Math.random());//Auto Boxing
		}
		System.out.println(hmap);
		
		//키에 대한 오름차순정렬 처리를 자동으로 하려면 TreeMap 사용하면 됨
		TreeMap tmap = new TreeMap(hmap);
		System.out.println(hmap);
		
		//키에 대한 내림차순정렬 처리는
		Map descMap = tmap.descendingMap(); //TreeMap으로 할 수 있는데 다형성을 쓰기 위해 최상위 부모 Map사용
		System.out.println(descMap);
	}

}
