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
		<form action="modifyNotice.di" method="post" enctype="multipart/form-data">
			<input type="hidden" name="noticeNo" value="${notice.noticeNo}">
			<input type="hidden" name="noticeFilePath" value="${notice.noticeFilePath}">
			<table>
				<thead>
					<tr>
						<td>제목</td>
						<td><input type="text" size="50" name="noticeTitle" value="${notice.noticeTitle}"></td>
					</tr>
					<tr>
						<td>작성자</td>
						<td><input type="text" size="50" name="noticeWriter" value="${notice.noticeWriter}" readonly></td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>내용</td>
						<td><textarea rows="7" cols="50" name="noticeContents">${notice.noticeContents}</textarea></td>
					</tr>
					<tr>
						<td>첨부파일</td>
						<td><input type="file" name="reloadFile">${notice.noticeFilePath}</td>
					<tr>
					<tr>
						<td>
							<input type="submit" value="수정하기">
						</td>	
					</tr>
				</tbody>
			</table>
		</form>
		</div>
	</main>
</body>
</html>