<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post">
		<h1>마이페이지</h1>
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" value="${mypage.id}" disabled></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="text" value="${mypage.password}"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" value="${mypage.name}"></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" value="${mypage.addr}"></td>
			</tr>
			<tr>
				<td><input type="submit" value="수정" formaction="/member/modify"></td>
				<td><input type="submit" value="삭제" formaction="/member/remove"></td>
			</tr>
		</table>
	</form>
</body>
</html>