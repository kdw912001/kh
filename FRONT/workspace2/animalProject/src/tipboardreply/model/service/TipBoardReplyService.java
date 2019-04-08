package tipboardreply.model.service;

import java.sql.Connection;

import tipboard.model.service.TipBoardService;
import tipboardreply.model.dao.TipBoardReplyDao;
import tipboardreply.model.vo.TipBoardReply;
import static common.JDBCTemplate.*;

public class TipBoardReplyService {
	
	private TipBoardReplyDao tredao = new TipBoardReplyDao();
	
	public TipBoardReplyService() {}
	
	public int deleteTipBoardReply(int tipReplyBoardNum, int tipBoardNum) {
		Connection conn = getConnection();
		int result = tredao.delteTipBoardReply(conn, tipReplyBoardNum, tipBoardNum);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}
	public int insertTipBoardReply(TipBoardReply tboardRe, int tipBoardNum) {
		Connection conn = getConnection();
		int result = tredao.insertBoard(conn, tboardRe, tipBoardNum);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}
	public TipBoardReply selectTipBoardReply(int tipBoardNum) {
		Connection conn = getConnection();
		TipBoardReply tboardRe = tredao.selectBoard(conn, tipBoardNum);
		close(conn);
		return tboardRe;
	}
}
