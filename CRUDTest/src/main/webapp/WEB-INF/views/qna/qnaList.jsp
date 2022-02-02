<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QnA</title>
<!-- 부트스트랩 -->
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- CSS -->
<link rel="stylesheet" href="resources/css/qna/qnaList.css">
</head>
<body>
	<jsp:include page="../menubar.jsp"/>
	
	<main>
	
	<h1>Q&A</h1>
			<table class="table table-striped" style="text-align: center;">
				<thead>
					<tr>
						<th class="col-sm-1" style="text-align: center;">글번호</th>
						<th class="col-sm-7" style="text-align: center;">제목</th>
						<th class="col-sm-1" style="text-align: center;">작성자</th>
						<th class="col-sm-1" style="text-align: center;">작성일</th>
						<th class="col-sm-1" style="text-align: center;">조회수</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${qnaList}" var="qna" varStatus="status">
					<c:set var="num" value="${pi.listCount - ((pi.currentPage - 1) * 5) - status.index}"/>
						<tr>
							<td>${num}</td>
							<td>
								<c:url var="qDetail" value="qnaDetailView.di">
									<c:param name="qnaNo" value="${qna.qnaNo}"></c:param>
								</c:url>
								<a href="${qDetail}">${qna.qnaTitle}</a>
							</td>
							<td>${qna.qnaWriter}</td>
							<td>${qna.qUpdateDate}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>	
			<div class="paging">
				<!-- 이전 -->
				<c:url var="before" value="qnaList.di">
					<c:param name="page" value="${pi.currentPage - 1}"></c:param>
				</c:url>
				<c:if test="${pi.currentPage <= 1}">
					&lt;	
				</c:if>
				<c:if test="${pi.currentPage > 1}">
					<a href="${before}">&lt;</a>
				</c:if>
				
				<c:forEach var="p" begin="${pi.startPage}" end="${pi.endPage}">
					<c:url var="pagination" value="qnaList.di">
						<c:param name="page" value="${p}"></c:param>
					</c:url>
					<c:if test="${p eq pi.currentPage}">
						${p}
					</c:if>
					<c:if test="${p ne pi.currentPage}">
						<a href="${pagination}">${p}</a>&nbsp;
					</c:if>
				</c:forEach>
				
				<!-- 다음 -->
				<c:url var="after" value="qnaList.di">
					<c:param name="page" value="${pi.currentPage}"></c:param>
				</c:url>
				<c:if test="${pi.currentPage >= pi.maxPage}">
					&gt;
				</c:if>
				<c:if test="${pi.currentPage < pi.maxPage}">
					<a href="${after}">&gt;</a>&nbsp;
				</c:if>
			</div>
			<div class="btn-area">
				<a class="btn btn-primary writeBtn" href="qnaWriteView.di" role="button">글쓰기</a>
			</div>
	</main>
</body>
</html>