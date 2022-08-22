<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>리뷰쓰기</h1>
	<form action="/review/write" method="post">
		<table>
			<tr>
				<td>평점</td>
				<td><input type="text" name="estimate"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="r_title"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><input type="text" name="r_content"></td>
			</tr>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" value="${userid}"></td>
			</tr>
			<tr>
				<td>제품이름</td>
				<td><input type="text" name="pname" ></td>
			</tr>
			<tr>
				<td>이미지</td>
				<td><input type="file" name="img_file" ></td>
			</tr>
			<tr>
				<td colspan="2"><button>글쓰기</button></td>
			</tr>
		</table>
	</form>




</body>
</html>