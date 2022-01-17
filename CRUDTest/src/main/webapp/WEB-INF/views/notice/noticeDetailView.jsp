<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="styleSheet" href="resources/css/notice/noticeWriteForm.css" type="text/css">
<title>공지사항 상세보기</title>
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
						<td>${notice.noticeTitle }</td>
					</tr>
					<tr>
						<td>작성자</td>
						<td>${notice.noticeWriter }</td>
					</tr>
					<tr>
						<td>작성날짜</td>
						<td>${notice.nCreateDate }</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>내용</td>
						<td>${notice.noticeContents}</td>
					</tr>
					<tr>
						<td>첨부파일</td>
						<td>${notice.noticeFilePath }</td>
					<tr>
					<tr>
						<td>
							<button onclick="location.href='modifyNoticeView.di?noticeNo=${notice.noticeNo}'">수정하기</button>
							<button onclick="location.href='noticeDelete.di?noticeNo=${notice.noticeNo}'">삭제하기</button>
						</td>	
					</tr>
				</tbody>
			</table>
		</form>
		</div>
	</main>
</body>
</html>