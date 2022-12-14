/**
 * 
 */
$(document).ready(function(){
	// 첨부파일 공격에 대비하기 위한 업로드 파일 확장자 제한(함수)
	// 함수선언
	// 정규식을 이용하여 확장자 제한
	var reg = new RegExp("(.*)\.(exe|zip|alz)$")
	// 최대크기를 설정하여 그 이상이면 제한
	var maxSize = 5242880; // 5MB
	// 파일이름, 파일크기
	function checkExtension(fileName,fileSize){
		// 파일크기 제한
		// 실제파일의 크기 > 최대 크기
		if(fileSize >= maxSize){
			alert("파일 사이즈 초과");
			return false;
		}
		// 확장자 제한
		// 실제파일명의 확장자와 정규식 비교
		// 정규식이면
		if(reg.test(fileName)){
			alert("해당 종류의 파일은 업로드 할 수 없습니다.");
			return false;
		}
		return true;
	}// checkExtension함수 선언 끝
	
	// 파일전송버튼(id="uploadBtn")을 클릭하면
	$("#uploadBtn").on("click",function(e){
		e.preventDefault();
		// alert('hi')
		// 파일 업로드 관련 로직 처리
		// .jsp의 form태그를 대체(FormData함수)
		var formData = new FormData();
		var inputFile = $("input[name='uploadFile']");
		// console.log(inputFile);
		var files = inputFile[0].files;
		// console.log(files);
		for(var i=0; i<files.length; i++){
			// 함수 호출(checkExtension)
			if(!checkExtension(files[i].name, files[i].size)){
				return false;
			}
			// .jsp의 파일선택을 통해 선택한 파일들을 form태그에 추가
			formData.append("uploadFile",files[i]);			
		}// for문 끝
		
		// ajax를 통해서 uploadController에 파일 관련 데이터 전송
		$.ajax({
			type : "POST",
			url : "/uploadAjaxAction",
			data : formData, // 데이터를 formData메서드를 사용함
			contentType: false, // 자바에서 충돌을 방지하기 위해 contentType과 processData를 false로 함
			processData: false,
			dataType:"json",
			success:function(result){
				console.log(result);
				var str = "";
				var input = "";
				$(result).each(function(i,obj){
					// console.log(obj.uploadPath)
					input += `<input type="text" name="attach[${i}].fileName" value="${obj.fileName}"><br>`;
					input += `<input type="text" name="attach[${i}].uuid" value="${obj.uuid}"><br>`;
					input += `<input type="text" name="attach[${i}].image" value="${obj.image}"><br>`;
					input += `<input type="text" name="attach[${i}].uploadPath" value="${obj.uploadPath}"><br>`;
					console.log(input)
					// 만약 image결과가 true면
					if(obj.image){
						// 아래를 실행 (uri주소로 바꿔줌 \\->%로)
						var filePath = encodeURIComponent(obj.uploadPath+"/s_" + obj.uuid + "_" + obj.fileName); 																												// 
						console.log(filePath)
						str+=`<li><img src = "/display?fileName=${filePath}"></li>`;	
					}else{// 그렇지 않으면
						// 다운로드 할 수 있도록 실행 (uri주소로 바꿔줌 \\->%로)
						var filePath = encodeURIComponent(obj.uploadPath+"/" + obj.uuid + "_" + obj.fileName); 
						str = `<li><a href="/download?fileName=${filePath}">${obj.fileName}</a></li>`
					}										
				})		
				$("#uploadResult ul").html(str);
				$("#form").append(input).submit();	
				
			}
		})// ajax끝
		
	})// 클릭이벤트 끝	
	
	const remove = document.createElement('button');
	const arr = new Array();	
	let index = 0;
	$("#upload").on("change",function(){	
		var inputFile = $("input[name='uploadFile']");
		var files = inputFile[0].files;
		for(var i=0; i<files.length; i++){
			// 함수 호출(checkExtension)
			if(!checkExtension(files[i].name, files[i].size)){
				return false;
			}		
			$('#blah').empty();
			//console.log(files[i])
			arr[i] = files[i];
    	    console.log(arr[i])				
			var reader = new FileReader();
            reader.onload = function (e) {
            		const li = document.createElement('li'); //li만들기
                	const img = document.createElement('img');//img만들기
                	img.setAttribute('src',e.target.result);
                	const remove = document.createElement('button');//삭제버튼만들기
            	 	remove.setAttribute('type','button');
            	 	remove.classList.add('remove');
            	 	remove.innerText = "x";
                	li.append(img);//img태그 li에  붙이기
                	li.append(remove);//삭제버튼 li에 붙이기
                	$('#blah').append(li);
            	    $(".remove").on("click", function(e){
            	    	const re = e.target.parentNode;
            	    	re.remove();
            		})
  			}
            reader.readAsDataURL(files[i]);
            index++
		}// for문 끝		
		console.log(index);
	})//체인지이벤트 끝
	
	
	
	
	
})// document.ready 끝







