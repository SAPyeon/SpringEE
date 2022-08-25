<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/resources/js/uploadAjax.js"></script>
</head>
<body>
	<h1>게시판 글쓰기 화면</h1>
	<form action="/board/write" method="post">

		<div>
			제목 <input type="text" name="title">
		</div>
		<div>
			내용 <input type="text" name="content">
		</div>
		<div>
			아이디<input type="text" name="id" value="${userid}">
		</div>
		<div>
			<input type="file" name="fileName"><br> 
			<input type="file" name="uuid"><br> 
			<input type="file" name="uploadpath"><br> 
			<input type="file" name="image"><br>
		</div>
		<div>
			파일첨부<input type="file" name="uploadFile" multiple>
		</div>
		<div>
			<button type="button" id="uploadBtn">글쓰기</button>
		</div>

		<div id="uploadResult">
			<ul>
				<!-- <img src="/resources/img/10261708_h.jpg"> -->
			</ul>
		</div>
	</form>
</body>
</html>






