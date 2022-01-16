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
			<%-- <c:if test="${!empty nList.size()}"> --%>
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
							<td>1</td>
							<td>2</td>
							<td>2</td>
							<td>2</td>
						</tr>
					</tbody>
				</table>
			<%-- </c:if> --%>
		</div>
	</main>
</body>
</html>