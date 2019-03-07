package board.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Board implements Serializable {
	private static final long serialVersionUID = 3333L;
	
	private int boardNum;
	private String boardWriter;
	private String boardTitle;
	private String boardContent;
	private String boardOriginalFileName;
	private String boardRenameFileName;
	private int boardRef;  //참조하는 원글번호, 원글일 때는 자기번호
	private int boardReplyRef; //참조하는 댓글번호, 원글일때는 0, 원글의 댓글일때는 자기번호
	private int boardReplyLev; //원글 0, 원글의 댓글 1, 댓글의 댓글 2
	private int boardReplySeq; //댓글의 순번
	private int boardReadCount;  //조회수
	private Date boardDate;
	
	public Board() {}

	public Board(int boardNum, String boardWriter, String boardTitle, String boardContent, String boardOriginalFileName,
			String boardRenameFileName, int boardRef, int boardReplyRef, int boardReplyLev, int boardReplySeq,
			int boardReadCount, Date boardDate) {
		super();
		this.boardNum = boardNum;
		this.boardWriter = boardWriter;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardOriginalFileName = boardOriginalFileName;
		this.boardRenameFileName = boardRenameFileName;
		this.boardRef = boardRef;
		this.boardReplyRef = boardReplyRef;
		this.boardReplyLev = boardReplyLev;
		this.boardReplySeq = boardReplySeq;
		this.boardReadCount = boardReadCount;
		this.boardDate = boardDate;
	}

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public String getBoardWriter() {
		return boardWriter;
	}

	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getBoardOriginalFileName() {
		return boardOriginalFileName;
	}

	public void setBoardOriginalFileName(String boardOriginalFileName) {
		this.boardOriginalFileName = boardOriginalFileName;
	}

	public String getBoardRenameFileName() {
		return boardRenameFileName;
	}

	public void setBoardRenameFileName(String boardRenameFileName) {
		this.boardRenameFileName = boardRenameFileName;
	}

	public int getBoardRef() {
		return boardRef;
	}

	public void setBoardRef(int boardRef) {
		this.boardRef = boardRef;
	}

	public int getBoardReplyRef() {
		return boardReplyRef;
	}

	public void setBoardReplyRef(int boardReplyRef) {
		this.boardReplyRef = boardReplyRef;
	}

	public int getBoardReplyLev() {
		return boardReplyLev;
	}

	public void setBoardReplyLev(int boardReplyLev) {
		this.boardReplyLev = boardReplyLev;
	}

	public int getBoardReplySeq() {
		return boardReplySeq;
	}

	public void setBoardReplySeq(int boardReplySeq) {
		this.boardReplySeq = boardReplySeq;
	}

	public int getBoardReadCount() {
		return boardReadCount;
	}

	public void setBoardReadCount(int boardReadCount) {
		this.boardReadCount = boardReadCount;
	}

	public Date getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return this.boardNum + ", " + this.boardTitle
			+ ", " + this.boardWriter + ", "
			+ this.boardContent + ", "
			+ this.boardDate + ", "
			+ this.boardOriginalFileName + ", "
			+ this.boardRenameFileName + ", "
			+ this.boardRef + ", "
			+ this.boardReplyLev + ", "
			+ this.boardReplyRef + ", "
			+ this.boardReplySeq + ", "
			+ this.boardReadCount;
	}
}
