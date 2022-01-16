<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/menubar.css" type="text/css">
<script type="text/javascript" src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>
	<nav id="navbar">
		<div class="navbar__logo">
			<img class="navbar__logo__img" src="/resources/imgs/planet.png" alt="logo image" width= 20px height=20px>
			<a href="#">DaIn</a>
		</div>
		<ul class="navbar__menu">
			<li class="navbar__menu__item"><a href="/noticeList.di">공지사항</a></li>
			<li class="navbar__menu__item"><a href="/qnaList.di">Q&A</a></li>
			<li class="navbar__menu__item"><a href="/guestBook.di">방명록</a></li>
		</ul>
		<div class="login__container">
			<c:if test="${empty sessionScope.loginUser}">
				<form id="login__form" action="/login.di" method="POST">
					<div class="login__text">
						<!-- input tag 의 아이디 값을 for 값에 넣음으로써 label 태그와 연결 가능  -->
						<label for="userId">아이디</label>
						<input id="userId" type="text" name="userId">
					</div>
					<div class="login__text">
						<label for="userPw">비밀번호</label>
						<input id="userPw" type="password" name="userPw">
					</div>
					<div class="login__btn">
						<button type="submit">로그인</button>
					</div>
				</form>
			</c:if>
			<c:if test="${!empty sessionScope.loginUser}">
				<div>
					<h3>${loginUser.userName} 님 환영합니다.</h3>
				</div>
			</c:if>
		</div>
	</nav>
</body>
</html>
</html>