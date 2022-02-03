<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/css/qna/qnaWriteView.css">
<title>문의글 작성</title>
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
		<h1>문의글 작성</h1>
		<div class="form-area">
			<form class="form-horizontal" action="qnaRegister.di" method="POST" encType="multipart/form-data">
				<div class="form-group">
					<label for="qnaTitle" class="col-sm-2 control-label">제목</label>
					<div class="col-sm-10">
						<input type="text" id="qnaTitle" name="qnaTitle">
					</div>
				</div>
				<div class="form-group">
					<label for="qnaWriter" class="col-sm-2 control-label">작성자</label>
					<div class="col-sm-10">
						<input type="text" id="qnaWriter" name="qnaWriter" value="${loginUser.userId}" readonly>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<textarea id="summernote" name="qnaContent"></textarea>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-2 control-label"></div>
					<div class="col-sm-8 file-area">
						<input id="fileName" value="파일선택" disabled="disabled">
						<label for="uploadFile">파일첨부</label>
						<input type="file" size="50" id="uploadFile" name="uploadFile" value="파일선택">
					</div>
				</div>
				<div class="form-group btn-area">
					<div class="col-sm-2"></div>
					<div class="col-sm-8 chkPublic">
						<label><input type="checkbox" name="qnaPublicYn" value="Y" onclick="chkOnlyOne(this)" checked>공개</label>
						<label><input type="checkbox" name="qnaPublicYn" value="N" onclick="chkOnlyOne(this)">비공개</label>
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
		function chkOnlyOne(chk) {
			var obj = document.getElementsByName("qnaPublicYn");
			
			for(var i = 0; i < obj.length; i++) {
				if(obj[i] != chk) {
					obj[i].checked = false;
				}
			}
		}
	</script>
	<script>
		$(function() {
			$('#file-area > label').on("click", function(e) {
				console.log('click');
				e.preventDefault();
				$('#uploadFile').click();
			});
			
			let fileTarget = $('#uploadFile');
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