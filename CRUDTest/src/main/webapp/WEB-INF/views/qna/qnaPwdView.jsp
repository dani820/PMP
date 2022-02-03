<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/css/qna/qnaWriteView.css">
<title>문의글 비밀번호 확인</title>
<!-- 부트스트랩 -->
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>
	<jsp:include page="../menubar.jsp"/>
	
	<main>
		<h1>문의글 비밀번호 확인</h1>
		<div class="form-area">
			<form class="form-horizontal" action="qnaChkPwd.di" method="POST">
				<input type="hidden" name="qnaNo" value="${qnaNo}">
				<div class="form-group">
					<h3>비밀번호를 입력해주세요.</h3>
				</div>
				<div class="form-group">
					<input type="password" id="qnaPwd" name="qnaPwd">
				</div>
				<div class="form-group btn-area">
					<button type="submit" class="btn btn-primary">확인</button>
					<button type="button" class="btn btn-danger" onclick="location:href='qnaList.di'">취소</button>
				</div>
			</form>		
		</div>
	</main>
</body>
</html>