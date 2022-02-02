<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/css/qna/qnaUpdateView.css">
<title>문의글 수정</title>
<!-- 부트스트랩 -->
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<!-- summernote -->
<!-- <script src="resources/js/summernote/summernote-lite.js"></script>
<script src="resources/js/summernote/lang/summernote-ko-KR.js"></script>
<link rel="stylesheet" href="resources/css/summernote/summernote-lite.css"> -->
</head>
<body>
	<jsp:include page="../menubar.jsp"/>
	
	<main>
		<h1>문의글 수정</h1>
		<div class="form-area">
			<form class="form-horizontal" action="qnaModify.di" method="POST" encType="multipart/form-data">
				<!-- 로직 수행 위해 필요한 파라미터를 사용자에게 보이지 않고 로직에 전달될 수 있도록 함 -->
				<input type="hidden" name="qnaNo" value="${qOne.qnaNo}">
				<!-- 첨부파일 수정 없을 때 원래 저장되어 있는 파일경로 전달 위함 -->
				<input type="hidden" name="originFileName" value="${qOne.originFileName}">
				<input type="hidden" name="renameFileName" value="${qOne.renameFileName}">
				
				<div class="form-group">
					<label for="qnaTitle" class="col-sm-2 control-label">제목</label>
					<div class="col-sm-10">
						<input type="text" id="qnaTitle" name="qnaTitle" value="${qOne.qnaTitle}">
					</div>
				</div>
				<div class="form-group">
					<label for="qnaWriter" class="col-sm-2 control-label">작성자</label>
					<div class="col-sm-10">
						<input type="text" id="qnaWriter" name="qnaWriter" value="${qOne.qnaWriter}" readonly>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<textarea id="summernote" name="qnaContent">${qOne.qnaContent}</textarea>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-2 control-label"></div>
					<div class="col-sm-8 file-area">
						<c:if test="${!empty qOne.originFileName}">
							<input id="fileName" value="${qOne.originFileName}" disabled="disabled">
						</c:if>
						<label for="reloadFile">파일첨부</label>
						<input type="file" size="50" id="reloadFile" name="reloadFile" value="파일선택">
					</div>
				</div>
				<div class="form-group btn-area">
					<div class="col-sm-2"></div>
					<div class="col-sm-8 chkPublic">
						<c:if test="${qOne.qnaPublicYn eq 'Y'}">
							<label><input type="checkbox" name="qnaPublicYn" value="Y" checked>공개</label>
							<label><input type="checkbox" name="qnaPublicYn" value="N">비공개</label>
						</c:if>
						<c:if test="${qOne.qnaPublicYn eq 'N'}">
							<label><input type="checkbox" name="qnaPublicYn" value="Y">공개</label>
							<label><input type="checkbox" name="qnaPublicYn" value="N" checked>비공개</label>
						</c:if>
					</div>
				</div>
				<div class="form-group btn-area">
					<div class="col-sm-offset-2 col-sm-5">
						<button type="submit" class="btn btn-primary">등록</button>
						<button type="reset" class="btn btn-danger">취소</button>
					</div>
				</div>
			</form>		
		</div>
	</main>
	
	<script>
		$(function() {
			$('#file-area > label').on("click", function(e) {
				console.log('click');
				e.preventDefault();
				$('#reloadFile').click();
			});
			
			let fileTarget = $('#reloadFile');
			fileTarget.on('change', function() {
				if(window.FileReader) {
					var fileName = $(this)[0].files[0].name;
				} else {
					var fileName = $(this).val().split('/').pop().split('\\').pop();
				}
				
				$(this).siblings('#fileName').val(fileName);
			});
		});
	</script>
</body>
</html>