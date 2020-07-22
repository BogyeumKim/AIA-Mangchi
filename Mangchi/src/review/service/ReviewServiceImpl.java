package review.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.ConnectionProvider;
import review.dao.ReviewDao;
import review.model.Review;
import service.Service;

public class ReviewServiceImpl implements Service {

	
	
	ReviewDao dao;
	
	
	@Override
	public String getViewPage(HttpServletRequest req, HttpServletResponse resp) {
		
		
		int resultCnt =0;

		Connection conn = null;
		
		int review_idx =0;
		
		// 아래3개필수
		int req_idx =7; //test용
		//int review_receiver=7; // test용
		int review_writer =2; // test용
		
		//int req_idx =Integer.parseInt(req.getParameter("req_idx")); // 게시글 idx
		//int review_receiver = Integer.parseInt(req.getParameter("review_receiver")); // 리뷰당하는사람
		//int review_writer = Integer.parseInt(req.getParameter("review_writer")); // 리뷰쓰는사람[게시글올린사람]
		
		int review_score = Integer.parseInt(req.getParameter("review_score"));
		String review_text = req.getParameter("review_text");
		
		
		
		
		try {
			conn = ConnectionProvider.getConnection();
			
			Review review = new Review();
			
			review.setReq_idx(req_idx); // 게시글번호 
			//review.setReview_receiver(review_receiver);
			review.setReview_writer(review_writer);
			review.setReview_score(review_score);
			review.setReview_text(review_text);
			
			
			
			Review review2 = new Review();
			
			review2.setReview_idx(review_idx);
			
			dao = ReviewDao.getInstance();
			
			resultCnt=dao.insertReview(conn,review);
			resultCnt=dao.selectReview(conn,review2);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return "/WEB-INF/views/reviews/review.jsp";
	}

}
