<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <header>
  <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <a class="navbar-brand" href="<c:url value='/index.do'/>"><img src="<c:url value='/img/logo.png'/>" class="logo_img" style="width: 50px; height: 50px;" ></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarCollapse">
      <ul class="navbar-nav mr-auto">
      <c:if test="${empty loginInfo}">
        <li class="nav-item active">
          <a class="nav-link" href="<c:url value='/member/loginForm.do'/>">로그인</a>
        </li>
       </c:if>
       <c:if test="${not empty loginInfo}">
        <li class="nav-item active">
          <a class="nav-link" id="logout" href="<c:url value='/member/logout.do'/>">로그아웃</a>
          
        </li>
       </c:if>
        <li class="nav-item">
          <a class="nav-link" href="<c:url value='/board/boarding.do'/>">대여게시판</a>
        </li>
          <li class="nav-item">
          <a class="nav-link" href="<c:url value="/board/posting.do"/>">글쓰기</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="<c:url value="/message/messageBox.do"/>">쪽지함</a>
        </li>
        <li class="nav-item"><a class="nav-link"
					href="<c:url value='/member/mypage.do'/>">마이페이지</a></li>
      </ul>
      <form class="form-inline mt-2 mt-md-0"
				action="${pageContext.request.contextPath}/board/searchrequest.do"
				method="get" >
				<input class="form-control mr-sm-2" type="text" name="Search" 
					placeholder="Search" aria-label="Search">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			</form>
    </div>
  </nav>
</header>
  <script>
  function logoutWithKakao() {
      Kakao.Auth.logout(function() {
          alert('로그아웃되었습니다.');
      });
          sessionStorage.removeItem('loginInfo');
  }
</script>