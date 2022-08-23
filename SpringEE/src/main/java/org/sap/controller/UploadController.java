package org.sap.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

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

	@RequestMapping(value = "/uploadAjaxAction", method = RequestMethod.POST)
	public void uploadAjaxPost(MultipartFile[] uploadFile) {
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

}
