package board.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.ConnectionProvider;
import request.dao.RequestDao;
import request.model.Request;
import request.model.RequestListView;
import service.Service;

public class RequestListBoardServiceImpl implements Service {

	RequestDao dao;
	
	
	@Override
	public String getViewPage(HttpServletRequest req, HttpServletResponse resp) {
		
			Connection conn = null;
			RequestListView listview = null;
			
			final int COUNT_PER_PAGE = 3;
		
			try {

				conn = ConnectionProvider.getConnection();

				dao = RequestDao.getInstance();	
				List<Request> requestList = null;
				
				int requestTotalCount = dao.selectTotalCount(conn);
				
				int pageNumber = 1;
				String page = req.getParameter("page");
				
				if (page != null) {
					try {
						pageNumber = Integer.parseInt(page);
					} catch (NumberFormatException e) {
						
					}
				}

				int startRow = 0;
				
				if (requestTotalCount > 0) {

					// ���� ��, ������ ��
					startRow = (pageNumber - 1) * COUNT_PER_PAGE ;
					
					requestList = dao.selectAllrequest(conn,startRow, COUNT_PER_PAGE);
					// System.out.println("requestList: "+requestList);

				} else {
					pageNumber = 0;
					requestList = Collections.emptyList();
				}

				listview = new RequestListView(requestTotalCount, pageNumber, requestList, COUNT_PER_PAGE, startRow); 
				
		
				System.out.println("requestList: "+requestList);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {

				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}

			req.setAttribute("listView", listview);
			
		
		return "/WEB-INF/views/board/requestList.jsp";
	}

}
