<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시판 목록 리스트</h1>
	<table border="1">
		<tr>
			<td>게시판번호</td>
			<td>제목</td>
			<td>작성일자</td>
			<td>조회수</td>
		</tr>
		<!-- for문 시작 -->
		<c:forEach items="${list}" var="boardlist">
			<tr>
				<td>${boardlist.bno}</td>
				<td><a href="/board/detail?bno=${boardlist.bno}">${boardlist.title}</a></td>
				<td>${boardlist.regdate}</td>
				<td>${boardlist.cnt}</td>
			</tr>
		</c:forEach>
		<!-- for문 끝 -->
	</table>
	<%-- ${paging} --%>
	<!-- prev(이전)이 true이면 이전버튼 활성화 -->
	<c:if test="${paging.prev}">
	<a href="/board/list?pageNum=${paging.startPage-1}&amount=${paging.cri.amount}">이전</a>
	</c:if>
	<!-- begin(1)이 end(10)될 동안 반복 (1이 6이 될 동안 반복) -->
	<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="num">
		<a href="/board/list?pageNum=${num}&amount=${paging.cri.amount}">${num}</a>
	</c:forEach>
	<!-- next(다음)이 true이면 다음버튼 활성화 -->
	<c:if test="${paging.next}">
	<a href="/board/list?pageNum=${paging.endPage+1}&amount=${paging.cri.amount}">다음</a>
	</c:if>
</body>
</html>