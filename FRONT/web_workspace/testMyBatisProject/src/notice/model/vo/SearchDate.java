package notice.model.vo;

import java.sql.Date;

public class SearchDate {/*서버에서 클래스끼리 주고받으므로 직렬화할 필요 없음*/
	private Date begin;
	private Date end;
	
	public SearchDate() {}

	public SearchDate(Date begin, Date end) {
		super();
		this.begin = begin;
		this.end = end;
	}

	public Date getBegin() {
		return begin;
	}

	public void setBegin(Date begin) {
		this.begin = begin;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	@Override
	public String toString() {
		return begin + ", " + end;
	}
	
}
