<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>리뷰 글쓰기폼</title>

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>

</head>
<body>


<form id="reviewForm" action="review.do"  method="post">


<table>
	
	

	

	<tr>
	<td class="req_writer" id="req_writer">
	 <% int req_writer = (int)session.getAttribute("req_writer"); %>
 			 글쓴이세션값 : <%=req_writer%></td>
	</tr>
				
	<tr >
	<td class="review_receiver" id="review_receiver">
	<%String review_receiver = request.getParameter("review_receiver"); %>
		받는이 : <%=review_receiver %></td>
	</tr>
			
				
	<tr>
		<td>후기</td>
		<td> <input type="text" name="review_text" id="review_text"></td>
	</tr>
				
				<tr>
					<td>평점</td>
					<td><select name="review_score">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
					</select></td>
				</tr>
				
				<tr>
					<td> <input type="submit" name="등록">	</td>
				</tr>



</table>
</form>


</body>
</html>