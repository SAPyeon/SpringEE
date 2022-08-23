package org.sap.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

//import org.apache.commons.io.FilenameUtils;

import org.sap.model.BoardVo;
import org.sap.model.ReviewVo;
import org.sap.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ReviewController {
	@Autowired
	ReviewService res;

	// 리뷰글쓰기 페이지(화면)
	@RequestMapping(value = "/review/write", method = RequestMethod.GET)
	public String write() {
		return "review/write";
	}

	// 리뷰 글쓰기 페이지(insert 이루어 지는 서버)
	@RequestMapping(value = "/review/write", method = RequestMethod.POST)
	public String writePost(ReviewVo rvo) throws IOException {
		// 파일 업로드 처리
		String img_file = null;
		MultipartFile uploadFile = rvo.getUploadFile();
		if (!uploadFile.isEmpty()) {
			String originalFileName = uploadFile.getOriginalFilename();
			//String ext = FilenameUtils.getExtension(originalFileName); // 확장자 구하기
			UUID uuid = UUID.randomUUID(); // UUID 구하기
			//img_file = uuid + "." + ext;
			uploadFile.transferTo(new File("D:\\01-STUDY\\upload\\" + img_file));
		}
		rvo.setImg_file(img_file);
		res.write(rvo);
		return "redirect:/board/list";
	}
}
