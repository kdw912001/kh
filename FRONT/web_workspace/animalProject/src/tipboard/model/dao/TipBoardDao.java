package tipboard.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import notice.model.vo.Notice;

import static common.JDBCTemplate.*;

import tipboard.model.vo.TipBoard;

public class TipBoardDao {

	public int getListCount(Connection conn) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select count(*) from tipboard";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		
		return listCount;
	}

	public ArrayList<TipBoard> selectList(Connection conn, int currentPage, int limit) {
			ArrayList<TipBoard> list = new ArrayList<TipBoard>();
			Statement stmt = null;
			ResultSet rset = null;
			
			//해당 페이지에 출력할 목록의 시작행과 끝행 계산
			int startRow = (currentPage -1) * limit + 1;
			int endRow = startRow + limit - 1;
			
			String query = "select * from tipboard order by tipboard_no desc";
			
			try {
				stmt = conn.createStatement();
				
				rset = stmt.executeQuery(query);
				System.out.println(2);
				while(rset.next()) {
					System.out.println(1);
					TipBoard tboard = new TipBoard();
					tboard.setTipBoardNo(rset.getInt("tipboard_no"));
					tboard.setTipBoardTitle(rset.getString("tipboard_title"));
					tboard.setTipBoardContent(rset.getString("tipboard_content"));
					tboard.setTipBoardDate(rset.getDate("tipboard_date"));
					tboard.setTipBoardOriginFile(rset.getString("tipboard_originfile"));
					tboard.setTipBoardViews(rset.getInt("tipboard_views"));
					tboard.setTipBoardRecommend(rset.getInt("tipboard_recommend"));
					tboard.setUserId(rset.getString("user_id"));
					tboard.setTipBoardDelete(rset.getString("tipboard_delete"));
					tboard.setTipBoardReFile(rset.getString("tipboard_refile"));
					System.out.println(tboard);
					list.add(tboard);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(stmt);
			}
			
			return list;
	}

	public int addReadCount(Connection conn, int tipBoardNum) {
		// TODO Auto-generated method stub
		return 0;
	}

	public TipBoard selectBoard(Connection conn, int tipBoardNum) {
		// TODO Auto-generated method stub
		return null;
	}

	public int insertBoard(Connection conn, TipBoard tboard) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateTipBoard(Connection conn, TipBoard tboard) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<TipBoard> selectDateList(Connection conn, Date begin, Date end, int currentPage, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<TipBoard> selectTitleList(Connection conn, String title, int currentPage, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<TipBoard> selectWriterList(Connection conn, String writer, int currentPage, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	public int deleteTipBoard(Connection conn, int tipBoardNum) {
		// TODO Auto-generated method stub
		return 0;
	}

}
