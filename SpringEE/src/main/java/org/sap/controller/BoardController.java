package org.sap.controller;

import org.sap.model.BoardVo;
import org.sap.model.CriteriaVo;
import org.sap.model.PageVo;
import org.sap.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BoardController {
	@Autowired
	BoardService bs;
	
	@RequestMapping(value = "/board/list", method = RequestMethod.GET)
	// 게시판 목록 리스트
	public String list(Model model, CriteriaVo cri) {
	//list.jsp 실행할 때 select된 결과를 가져가라.
	model.addAttribute("list", bs.list(cri));
	//list.jsp 실행할 때 PageVo에 저장되어 있는 데이터를 가져와라
	//                           생성자호출(매개변수가 두개인 생성자)
	//board테이블(게시판테이블)에 전체 건수(select해서)를 아래에 59대신에 대입
	int total = bs.total(cri);
	//model.addAttribute("paging",new PageVo(cri,59));
	model.addAttribute("paging",new PageVo(cri,total));
	return "board/list";
	}
	
	// 게시판 상세 페이지
	@RequestMapping(value="/board/detail", method = RequestMethod.GET)
	//public void detail(int bno){}로도 가능
	public void detail(BoardVo bvo, Model model) {
	model.addAttribute("detail", bs.detail(bvo));
	}
	
	// 게시판 글쓰기 페이지(화면)
	@RequestMapping(value = "/board/write", method = RequestMethod.GET)
	public String write() {
		return "board/write";
	}
	// 게시판 글쓰기 페이지(insert 이루어 지는 서버)
	@RequestMapping(value = "/board/write", method = RequestMethod.POST)
	public String writePost(BoardVo bvo) {
	// 비즈니스 영역 연결한 후 BoardService에 있는 write메소드를 호출
	bs.write(bvo);
	return "redirect:/board/list"; // model.addAttribute가 있는 /board/list 실행
	}
	
	//RedirectAttributes 포함하여 작성
	@RequestMapping(value = "/board/modify", method = RequestMethod.POST)
	public String modify(BoardVo bvo, RedirectAttributes rttr) {
	//글 수정
	bs.modify(bvo);
	rttr.addAttribute("bno",bvo.getBno());
	// detail.jsp에서 수정된 결과를 확인하기 위한 화면이동
	return "redirect:/board/detail";
	}
	
	//게시판 글 삭제하기
	@RequestMapping(value="/board/remove", method= RequestMethod.POST)
	public String remove(BoardVo bvo) {
	bs.remove(bvo);
	return "redirect:/board/list";
	}
	
}

