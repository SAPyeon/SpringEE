<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시판 글쓰기 화면</h1>
	<form action="/board/write" method="post">
		<table>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><input type="text" name="content"></td>
			</tr>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id"  value="${userid}"></td>
			</tr>
			<tr>
				<td colspan="2"><button>글쓰기</button></td>
			</tr>
		</table>
	</form>
</body>
</html>






