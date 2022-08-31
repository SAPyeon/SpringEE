/**
 * 첨부파일 관련 js
 */
$(document).ready(function(){
	//detail.jsp가 시작되자마자(ready이벤트) bno값 가져오기
	var bno = $("input[name='bno']").val();
	$.getJSON("/attachlist", {bno:bno},function(attachlist){
		console.log(attachlist)
		var str="";
		$(attachlist).each(function(i,attach){
			//만약 image결과가 true이면
			if(attach.image){
				//아래를 실행
				var filePath = encodeURIComponent(attach.uploadPath+ "/s_"+attach.uuid + "_" + attach.fileName); //uri주소로 바꿔줌 \\ -> %로
				console.log(filePath)
				str+=`<li><img src = "/display?fileName=${filePath}"></li>`;
			}else{//그렇지 않으면
				//다운로드 할 수 있도록 실행
				var filePath = encodeURIComponent(attach.uploadPath+"/" + attach.uuid + "_" + attach.fileName); //uri주소로 바꿔줌 \\ -> %로
				str = `<li><a href="/download?fileName=${filePath}">${attach.fileName}</a></li>`
			
			}//if문 끝
		})//each문 끝
		$("#uploadResult ul").html(str);
		
	})//getJSON끝
})//document.ready끝



