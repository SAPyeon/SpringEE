/**
 * 댓글 관련 javascript 처리
 */
$(document).ready(function() {
	// detail.jsp가 시작되자마자 bno값을 가져오려면 $(document).ready 아래에 선언
	var bnoValue = $("input[name='bno']").val();
	// alert(bno)

	// detail.jsp가 시작되자마자 댓글목록리스트(list) 함수를 호출
	list(bnoValue);

	// 댓글쓰기버튼을 클릭하면
	$("#btn_add").on("click", function() {
		// 댓글쓰기 버튼을 클릭했을 당시에 댓글내용을 가져올려면 $("#btn_add").on("click",function(){아래에
		// 선언
		var replyValue = $("#reply").val();
		// alert(reply);
		var idValue = $("input[name=userid]").val();
		// 댓글쓰기를 하기 위한 함수 호출
		add({
			bno : bnoValue,
			reply : replyValue,
			id : idValue
		}); // 댓글 쓰기를 하기 위한 함수
		// 호출
	})

	// 댓글 수정버튼을 클릭하면
	// 이미 존재하는 태그에 이벤트를 처리하고
	// 나중에 동적으로 생기는 태그들에 대해서 파라미터 형식으로 지정(이벤트위임)
	$("#chat").on("click", ".update", function() {
		// alert("aaa");
		// 댓글번호와 댓글내용을 수집해서
		var rno = $(this).data("rno"); // this를 쓰지 않으면 update 클래스의 첫번째 값만 불러옴,
		                               //this를 사용하여 사용자가 선택한 값을 불러올 수 있음
		var reply = $("#replycontent" + rno).val(); // 각 id에 rno번호를 부여하여 해당 rno의 댓글내용을 불러옴

		// 댓글수정을 하기 위한 함수 호출(댓글번호,댓글내용)
		modify({
			rno : rno,
			reply : reply
		});
	})
	//댓글삭제버튼을 클릭하면
	$("#chat").on("click",".remove",function(){
		//댓글번호만 수집해서
		var rno = $(this).data("rno");
		//console.log(rno);
		//댓글삭제를 하기 위한 함수 호출(댓글번호)
		//전달값이 하나인 경우 JSON타입으로 데이터를 전달하지 않아도 됨
		//remove({rno : rno});
		remove(rno);
	})
	
}) // document.ready끝

// 함수 선언(댓글쓰기를 하기 위한 함수 선언)
function add(reply) { // add함수 선언 시작
	$.ajax({ // ajax 준비...(비동기식으로 처리)
		type : "post", // method방식 (get, post, put, delete)
		url : "/replies/new",
		data : JSON.stringify(reply),
		// contentType : ajax -> controller로 데이터 전송 시 타입
		// (contentType을 생략하면 web Browser한테 위임)
		contentType : "application/json; charset=utf-8",
		success : function(result) {
			if (result === "success") {
				alert("댓글달기 성공");
				location.reload();
			}
		}
	})
} // add함수 선언 끝

// 댓글을 수정하기 위한 함수 선언
function modify(reply) {// modify함수 선언 시작
	console.log(reply);
	$.ajax({ // ajax 준비...(비동기식으로 처리)
		type : "put", // method방식 (get, post, put, delete)
		url : "/replies/modify",
		data : JSON.stringify(reply),
		// contentType : ajax -> controller로 데이터 전송 시 타입
		// (contentType을 생략하면 web Browser한테 위임)
		contentType : "application/json; charset=utf-8",
		success : function(result) {
			if (result === "success") {
				alert("댓글수정 성공");
				location.reload();
			}
		}
	})
}// modify함수선언 끝

//댓글 삭제를 하기 위한 함수선언
function remove(rno){
	console.log(rno);
	$.ajax({
		type : "delete", // method방식 (get, post, put, delete)
		url : "/replies/remove/"+rno,
		success : function(result) {
			if (result === "success") {
				alert("댓글삭제 성공");
				location.reload();
			}
		}
	})
}//remove함수선언 끝

// 댓글목록리스트를 만들기 위한 함수선언
function list(bno) { // list함수 선언 시작
	// alert(bno);
	$.getJSON("/replies/" + bno + ".json",
				function(data) {
					console.log(data);
					// createElement 사용
					/*const ul = document.querySelector('ul'); 
					for(let i=0; i<data.length; i++){ 
						const li = document.createElement('li'); 
						const div = document.createElement('div');
						const btn = document.createElement('button');
						btn.classList.add('update'); 
						btn.innerText = "수정" ;
						div.innerText = data[i].reply;
						li.innerText = data[i].id; li.append(div);
						li.append(btn);
						ul.appendChild(li);
					}
*/						 
					// 문자열로 받기
					let str = "";
					for (var i = 0; i < data.length; i++) {
						str += `<li>${data[i].id}</li>`
						str += `<li><textarea rows="5" cols="50" id="replycontent${data[i].rno}">${data[i].reply}</textarea></li>`
						str += `<li><button type="button" class="update" data-rno=${data[i].rno}>수정</button>`
						str += `<button type="button" class="remove" data-rno=${data[i].rno}>삭제</button></li>`
					}
					$("#replyUL").html(str)
	});
}// list함수 선언 끝




