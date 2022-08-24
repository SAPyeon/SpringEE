package org.sap.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import org.sap.model.AttachFileVo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import net.coobird.thumbnailator.Thumbnailator;

@Controller
public class UploadController {
	@RequestMapping(value = "/uploadForm", method = RequestMethod.GET)
	public void uploadForm() {

	}

	@RequestMapping(value = "/uploadFormAction", method = RequestMethod.POST)
	public void uploadFormPost(MultipartFile[] uploadFile) {

		// 폴더 경로
		String uploadFolder = "D:\\01-STUDY\\upload";

		// for(배열명:변수명)

		for (MultipartFile multipartFile : uploadFile) {
			System.out.println(multipartFile.getOriginalFilename());// 파일의 실제네임
			System.out.println(multipartFile.getSize()); // 파일 크기

			// 파일저장
			// 어느폴더에, 어떤파일이름으로
			File saveFile = new File(uploadFolder, multipartFile.getOriginalFilename());

			// 파일을 전송(transferTo)
			try { // transferTo() 메서드에 예외가 있으면
				multipartFile.transferTo(saveFile);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	// ajax사용
	@RequestMapping(value = "/uploadAjax", method = RequestMethod.GET)
	public void uploadAjax() {

	}

	// 년/ 월/ 일 폴더를 생성하는 메서드를 선언
	private String getFolder() {

		// 현재 날짜 추출 ("Thu Aug 24 09:23:12 KST 2022" 포맷으로 날짜 추출)
		Date date = new Date();

		// Thu Aug 24 09:23:12 KST 2022 -> 2022-08-24 포맷으로 변경
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // MM은 대문자, mm은 분(minute)을 의미함

		// 현재날짜와 날짜형식을 연결
		String str = sdf.format(date); // 2022-08-24 형식을 str문자에 저장
		System.out.println("Format적용날짜 = " + str.toString());
		// 2022-08-24 -> 2022\08\24로 변경
		return str.replace("-", "\\");

	}
	
	// 내가 올리고자 하는 파일이 이미지 파일인지 아닌지 구분하는 메서드 선언
	public boolean checkImageType(File file){
		//probeContentType(파일경로) : 파일경로에 있는 파일타입을 알아내는 메서드
		try {
			String contentType = Files.probeContentType(file.toPath());
			System.out.println("contentType="+contentType);
			// 파일타입이 image이면 true, 그 이외에는 false
			return contentType.startsWith("image");
		}catch(IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	
	@RequestMapping(value = "/uploadAjaxAction", method = RequestMethod.POST)
	public ResponseEntity<ArrayList<AttachFileVo>> uploadAjaxPost(MultipartFile[] uploadFile) {
		
		// AttachFileVo 클래스 포함
		ArrayList<AttachFileVo> list = new ArrayList();
		
		// 폴더 경로
		String uploadFolder = "D:\\01-STUDY\\upload";
		
		// 서버 업로드 경로와 getFolder 메서드의 날짜문자열을 이어서 하나의 폴더 생성
		File uploadPath = new File(uploadFolder, getFolder());

		// 폴더생성(D:\\01-STUDY\\upload\\현재날짜)
		if (uploadPath.exists() == false) {// uploadPath가 존재하지 않으면
			uploadPath.mkdirs(); // 부모디렉토리를 포함해 모든 디렉토리 생성
		}

		// for(배열명:변수명)
		for (MultipartFile multipartFile : uploadFile) {
			
			//AttachFileVo 클래스의 새로운 주소를 반복적으로 생성하여
			//ArrayList에 저장
			AttachFileVo attachVo = new AttachFileVo();
			
			
			System.out.println(multipartFile.getOriginalFilename());// 파일의 실제네임
			System.out.println(multipartFile.getSize()); // 파일 크기

			// UUID 적용(UUID_multipartFile.getOriginalFilename());
			UUID uuid = UUID.randomUUID();
			System.out.println("UUID=" + uuid.toString());
			
			//AttachFileVo의 uploadPath 변수에 저장()
			attachVo.setUploadPath(getFolder());
			
			//AttachFileVo의 fileName 변수에 저장()
			attachVo.setFileName(multipartFile.getOriginalFilename());
			//AttachFileVo의 uuid 변수에 저장()
			attachVo.setUuid(uuid.toString());
			
			// 파일저장
			// 어느폴더에, 어떤파일이름으로
			File saveFile = new File(uploadPath, uuid.toString() + "_" + multipartFile.getOriginalFilename());
			System.out.println(saveFile);
			
			// 파일을 전송(transferTo)
			try { // transferTo() 메서드에 예외가 있으면
				
				multipartFile.transferTo(saveFile); //서버로 원본파일 전송
				//내가 서버에 올리고자 하는 파일이 이미지이면,
				if(checkImageType(saveFile)) {
					//AttachFileVo의 image 변수에 저장()
					attachVo.setImage(true);					
					System.out.println("abcd");
					//파일 생성
					FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath, "s_" + uuid.toString() + "_" + multipartFile.getOriginalFilename()));
					//섬네일형식의 파일 생성
					System.out.println("111111");
					//System.out.println(multipartFile.getInputStream());
					Thumbnailator.createThumbnail(multipartFile.getInputStream(),thumbnail, 100, 100);
					System.out.println("222222");
					thumbnail.close();
					System.out.println("33333");
					
				}//if문(checkImageType메서드) 끝
				
				//AttachVo에 저장된 데이터를 배열에 추가
				list.add(attachVo);
				System.out.println(list);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}//trycatch문 끝
			
		}//for문 끝
		return new ResponseEntity<>(list, HttpStatus.OK);
		
	}//ajaxpost메서드 끝
}
