<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/css/qna/qnaDetailView.css">
<title>문의글 보기</title>
<!-- 부트스트랩 -->
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>
	<jsp:include page="../menubar.jsp"/>
	
	<main>
		<h1>문의글 보기</h1>
		<c:if test="${qOne.qnaPublicYn eq 'Y'}">
			<div class="question-container">
				<div class="question-header">
					<div class="q-title-area">
						<h3>${qOne.qnaTitle}</h3>
					</div>
					<div class="q-writer-area">
						<h5>${qOne.qnaWriter}</h5>
					</div>
					<div class="q-date-area">
						<span>${qOne.qUpdateDate}</span>
					</div>
					<div class="q-hit-area">
					
					</div>
				</div>
				<div class="question-content">
					<div class="q-text-area">
						<p>${qOne.qnaContent}</p>
					</div>
					<div class="q-file-area">
						<p>${qOne.qnaFilePath}</p>
					</div>
				</div>
			</div>
			<div class="question-btn">
				<button type="button" class="btn btn-default" onclick="location.href='qnaUpdateView.di?qnaNo=${qOne.qnaNo}'">수정</button>
				<button type="button" class="btn btn-default" onclick="location.href='qnaList.di'">목록</button>
			</div>
		</c:if>
	</main>
</body>
</html>