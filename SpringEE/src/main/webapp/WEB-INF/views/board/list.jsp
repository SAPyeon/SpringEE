<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/resources/js/boardlist.js"></script>
</head>
<body>
	<c:choose>
		<c:when test="${userid == null}">
			<a href="/member/login">로그인하기</a>
		</c:when>
		<c:otherwise>
			<form action="/member/logout" method="post">
				<button>로그아웃</button>
			</form>
			<!-- <a href="/member/logout">로그아웃</a> -->
		</c:otherwise>
	</c:choose>

	<h1>게시판 목록 리스트</h1>
	<a href="/board/write">글쓰기</a>
	<form action="/board/list" id="searchForm">
		<select name="type">
			<option value="T">제목</option>
			<option value="C">게시글</option>
			<option value="TC">제목+게시글</option>
		</select> <input type="text" name="keyword"> <input type="text"
			name="pageNum" value="${paging.cri.pageNum}"> <input
			type="text" name="amount" value="${paging.cri.amount}"> <input
			type="button" value="검색" id="search">
	</form>
	<table border="1">
		<tr>
			<td>게시판번호</td>
			<td>제목</td>
			<td>작성일자</td>
			<td>작성자</td>
			<td>조회수</td>
		</tr>
		<!-- for문 시작 -->
		<c:forEach items="${list}" var="boardlist">
			<tr>
				<td>${boardlist.bno}</td>
				<td><a href="/board/detail?bno=${boardlist.bno}">${boardlist.title}</a></td>
				<td>${boardlist.regdate}</td>
				<td>${boardlist.id}</td>
				<td>${boardlist.cnt}</td>
			</tr>
		</c:forEach>
		<!-- for문 끝 -->
	</table>
	<%-- ${paging} --%>
	<!-- prev(이전)이 true이면 이전버튼 활성화 -->
	<c:if test="${paging.prev}">
		<a
			href="/board/list?type=${paging.cri.type}&keyword=${paging.cri.keyword}&pageNum=${paging.startPage-1}&amount=${paging.cri.amount}">이전</a>
	</c:if>
	<!-- begin(1)이 end(10)될 동안 반복 (1이 6이 될 동안 반복) -->
	<c:forEach begin="${paging.startPage}" end="${paging.endPage}"
		var="num">
		<a
			href="/board/list?type=${paging.cri.type}&keyword=${paging.cri.keyword}&pageNum=${num}&amount=${paging.cri.amount}">${num}</a>
	</c:forEach>
	<!-- next(다음)이 true이면 다음버튼 활성화 -->
	<c:if test="${paging.next}">
		<a
			href="/board/list?type=${paging.cri.type}&keyword=${paging.cri.keyword}&pageNum=${paging.endPage+1}&amount=${paging.cri.amount}">다음</a>
	</c:if>
</body>
</html>