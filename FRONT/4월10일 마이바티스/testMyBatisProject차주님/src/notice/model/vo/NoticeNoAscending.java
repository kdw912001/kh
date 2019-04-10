package notice.model.vo;

import java.util.Comparator;

public class NoticeNoAscending implements Comparator{

	@Override
	public int compare(Object obj1, Object obj2) {
		Notice n1 = (Notice)obj1;
		Notice n2 = (Notice)obj2;
		
		return (n1.getNoticeNo() > n2.getNoticeNo())? 1 : ((n1.getNoticeNo() == n2.getNoticeNo())? 0: -1);
	}

}
