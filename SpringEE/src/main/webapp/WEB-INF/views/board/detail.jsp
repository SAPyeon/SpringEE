<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/resources/js/reply.js"></script>
</head>
<body>
	<form method="post">
		<h1>상세페이지</h1>
		<table>
			<tr>
				<td><input type="hidden" value="${detail.bno}" name="bno"></td>
				<td><input type="text" value="${userid}" name="userid"></td>
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
	<div>
		<label>댓글</label>
	</div>
	<div>
		<textarea rows="5" cols="50" id="reply"></textarea>
		<button type="button" id="btn_add">댓글쓰기</button>
	</div>
	<div>
		<ul id="replyUL">

		</ul>
	</div>
</body>
</html>