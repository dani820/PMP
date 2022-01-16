<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="styleSheet" href="resources/css/notice/noticeList.css" type="text/css">
<title>공지사항</title>
</head>
<body>
	<jsp:include page="../menubar.jsp"/>
	
	<main>
		<div class="frame">
		<h1>공지사항</h1>
			<c:if test="${!empty nList.size()}">
				<table class="notice__table">
					<thead>
						<tr>
							<td>No</td>
							<td>제목</td>
							<td>작성자</td>
							<td>날짜</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${nList}" var="notice" varStatus="status">
						<c:set var="num" value="${pi.listCount - ((pi.currentPage-1) * 5) - status.index }"/>
						<tr>
							<td>${num}</td>
							<td>${notice.noticeTitle}</td>
							<td>${notice.noticeWriter}</td>
							<td>${notice.nUpdateDate}</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
				<table class="notice__table__page">
					<tbody>
						<tr>
							<c:url var="before" value="noticeList.di">
								<c:param name="page" value="${pi.currentPage - 1}"></c:param>
							</c:url>
							<c:if test="${pi.currentPage <= 1}">
								[이전]&nbsp;
							</c:if>
							<c:if test="${pi.currentPage > 1}">
								<a href="${before}">[이전]</a>&nbsp;
							</c:if>
							
							<c:forEach var="p" begin="${pi.startPage}" end="${pi.endPage}">
								<c:url var="pagination" value="noticeList.di">
									<c:param name="page" value="${p}"></c:param>
								</c:url>
								<c:if test="${p eq pi.currentPage}">
									<font color="red" size="5">[${p}]</font>
								</c:if>
								<c:if test="${p ne pi.currentPage}">
									<a href="${pagination}">${p}</a>&nbsp;
								</c:if>
							</c:forEach>
							
							<c:url var="after" value="noticeList.di">
								<c:param name="page" value="${pi.currentPage + 1}"></c:param> 
							</c:url>
							<c:if test="${pi.currentPage >= pi.maxPage}">
								[다음]&nbsp;
							</c:if>
							<c:if test="${pi.currentPage < pi.maxPage}">
								<a href="${after}">[다음]</a>&nbsp;
							</c:if>
						</tr>
					</tbody>
				</table>
			</c:if>
			<c:if test="${empty nList.size()}">
				<table class="notice__table">
					<thead>
						<tr>
							<td>No</td>
							<td>제목</td>
							<td>작성자</td>
							<td>날짜</td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td colspan="4">내용없음</td>
						</tr>
					</tbody>
				</table>
			</c:if>
			
			<c:if test="${loginUser.userId == 'admin'}">
				<button onclick="location.href='noticeWrite.di'">공지쓰기</button>
			</c:if>
		</div>
	</main>
</body>
</html>