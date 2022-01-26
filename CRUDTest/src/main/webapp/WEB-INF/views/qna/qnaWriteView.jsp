<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/css/qna/qnaWriteView.css">
<!-- jQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- summernote -->
<script src="resources/js/summernote/summernote-lite.js"></script>
<script src="resources/js/summernote/lang/summernote-ko-KR.js"></script>
<link rel="stylesheet" href="resources/css/summernote/summernote-lite.css">
<title>문의글 작성</title>
</head>
<body>
	<jsp:include page="../menubar.jsp"/>
	
	<main>
		<h1>문의글 작성</h1>
		<div class="form-area">
			<div class="title-area">
				<input type="text" name="qnaTitle" placeholder="제목">
			</div>
			<div class="writer-area">
				<input type="text" name="qnaWriter" value="${loginUser.userId}" readonly>
			</div>
			<div class="text-area">
				<textarea class="summernote" name="qnaContent"></textarea>
			</div>
		</div>		
	</main>
	<script>
		$('.summernote').summernote({
			placeholder: '문의글 작성',
			minHeight: 370,
			maxHeight: null,
			focus: true,
			lang: 'ko-KR'
		});
</script>
</body>
</html>