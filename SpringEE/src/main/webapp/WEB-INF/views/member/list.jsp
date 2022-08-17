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
<%-- ${list} --%>
	<h1>회원 목록 리스트</h1>
	<table border="1">
		<tr>
			<td>아이디</td>
			<td>이름</td>
			<td>주소</td>
		</tr>
		<!-- for문 시작 -->
		<c:forEach items="${list}" var="memberlist">
			<tr>
				<td><a href="/member/mypage?id=${memberlist.id}">${memberlist.id}</a></td>
				<td>${memberlist.name}</td>
				<td>${memberlist.addr}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>