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
		<h1>상세페이지</h1>
		<table>
			<tr>
				<td><input type="text" value="${detail.bno}" name="bno" hidden></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" value="${detail.title}" name="title"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="10px" cols="20px" name="content">${detail.content}</textarea></td>
			</tr>
			<tr>
				<td><input type="submit" value="수정" formaction="/board/modify"></td>
				<td><input type="submit" value="삭제" formaction="/board/remove"></td>
				<td><a href="/board/list">목록으로</a></td>
			</tr>
		</table>
	</form>
</body>
</html>