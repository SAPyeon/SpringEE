/**
 * 
 */
$(document).ready(function(){
	//첨부파일 공격에 대비하기 위한 업로드 파일 확장자 제한(함수)
	//함수선언
	//정규식을 이용하여 확장자 제한
	var reg = new RegExp("(.*)\.(exe|zip|alz)$")
	//최대크기를 설정하여 그 이상이면 제한
	var maxSize = 5242880; //5MB
	//                    파일이름, 파일크기
	function checkExtension(fileName,fileSize){
		// 파일크기 제한
		// 실제파일의 크기 > 최대 크기
		if(fileSize >= maxSize){
			alert("파일 사이즈 초과");
			return false;
		}
		//확장자 제한
		//실제파일명의 확장자와 정규식 비교
		//정규식이면
		if(reg.test(fileName)){
			alert("해당 종류의 파일은 업로드 할 수 없습니다.");
			return false;
		}
		return true;
	}//checkExtension함수 선언 끝
	
	
	//파일전송버튼(id="uploadBtn")을 클릭하면
	$("#uploadBtn").on("click",function(e){
		e.preventDefault();
		//alert('hi')
		//파일 업로드 관련 로직 처리
		//.jsp의 form태그를 대체(FormData함수)
		var formData = new FormData();
		var inputFile = $("input[name='uploadFile']");
		//console.log(inputFile);
		var files = inputFile[0].files;
		// console.log(files);

		for(var i=0; i<files.length; i++){
			//함수 호출(checkExtension)
			if(!checkExtension(files[i].name, files[i].size)){
				return false;
			}
			//.jsp의 파일선택을 통해 선택한 파일들을 form태그에 추가
			formData.append("uploadFile",files[i]);
			
		}//for문 끝
		
		//ajax를 통해서 uploadController에 파일 관련 데이터 전송
		$.ajax({
			type : "POST",
			url : "/uploadAjaxAction",
			data : formData, // 데이터를 formData메서드를 사용함
			contentType: false, //자바에서 충돌을 방지하기 위해 contentType과 processData를 false로 함
			processData: false,
			dataType:"json",
			success:function(result){
				console.log(result);
				var str = "";
				$(result).each(function(i,obj){
					//console.log(obj.uploadPath)
					//만약 image결과가 true면
					if(obj.image){
						//아래를 실행
						var filePath = encodeURIComponent(obj.uploadPath+"/" + obj.uuid + "_" + obj.fileName); //uri주소로 바꿔줌 \\ -> %로
						console.log(filePath)
						str+=`<li><img src = "/display?fileName=${filePath}"></li>`;	
					}else{//그렇지 않으면
						//다운로드 할 수 있도록 실행
						var filePath = encodeURIComponent(obj.uploadPath+"/" + obj.uuid + "_" + obj.fileName); //uri주소로 바꿔줌 \\ -> %로
						str = `<li><a href="/download?fileName=${filePath}">${obj.fileName}</a></li>`
					}										
				})
				
				$("#uploadResult ul").html(str);
					
			}
		})//ajax끝
		
	})//클릭이벤트 끝
	
})//document.ready 끝