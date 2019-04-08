package review.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import review.model.dao.ReviewDao;
import review.model.vo.Review;
import tipboard.model.vo.TipBoard;

public class ReviewService {

	private ReviewDao rdao = new ReviewDao();
	
	public ReviewService() {}
	
	public int getListCount() {
		Connection conn = getConnection();
		int listCount = rdao.getListCount(conn);
		close(conn);
		return listCount;
	}

	public ArrayList<Review> selectList(int currentPage, int limit) {
		Connection conn = getConnection();
		ArrayList<Review> list = rdao.selectList(conn, currentPage, limit);
		close(conn);
		return list;
	}

	public int insertReview(Review review) {
		Connection conn = getConnection();
		int result = rdao.insertReview(conn, review);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public int deleteReview(int reviewNum) {
		Connection conn = getConnection();
		int result = rdao.deleteReview(conn, reviewNum);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

}
