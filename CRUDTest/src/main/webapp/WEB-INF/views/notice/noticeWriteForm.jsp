<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="styleSheet" href="resources/css/notice/noticeWriteForm.css" type="text/css">
<title>공지사항 작성</title>
</head>
<body>
	<jsp:include page="../menubar.jsp"></jsp:include>
	
	<main>
		<div class="frame">
		<form action="noticeWrite.di" method="post" enctype="multipart/form-data">
			<table>
				<thead>
					<tr>
						<td>제목</td>
						<td><input type="text" size="50" name="noticeTitle"></td>
					</tr>
					<tr>
						<td>작성자</td>
						<td><input type="text" size="50" name="noticeWriter" value="${loginUser.userId}" readonly></td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>내용</td>
						<td><textarea rows="7" cols="50" name="noticeContents"></textarea></td>
					</tr>
					<tr>
						<td>첨부파일</td>
						<td><input type="file" size="50" name="uploadFile"></td>
					<tr>
					<tr>
						<td>
							<input type="submit" value="등록">
							<input type="reset" value="취소">
						</td>	
					</tr>
				</tbody>
			</table>
		</form>
		</div>
	</main>
</body>
</html>