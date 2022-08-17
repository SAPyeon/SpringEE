package org.sap.controller;

import org.sap.model.BoardVo;
import org.sap.model.MemberVo;
import org.sap.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MemberController {
	@Autowired
	MemberService ms;

	// 회원가입
	@RequestMapping(value = "/member/signup", method = RequestMethod.GET)
	public void signup() {
	}

	@RequestMapping(value = "/member/signup", method = RequestMethod.POST)
	public String signupPost(MemberVo mvo) {
		ms.signup(mvo);
		return "redirect:/member/list";
	}

	// 멤버리스트
	@RequestMapping(value = "/member/list", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("list", ms.list());
		return "/member/list";
	}

	// 회원관리페이지
	@RequestMapping(value = "member/mypage", method = RequestMethod.GET)
	public void mypage(MemberVo mvo, Model model) {
		model.addAttribute("mypage", ms.mypage(mvo));
	}

	// 회원정보수정
	@RequestMapping(value = "/member/modify", method = RequestMethod.POST)
	public String modify(MemberVo mvo, RedirectAttributes rttr) {
	//글 수정
	ms.modify(mvo);
	rttr.addAttribute("id", mvo.getId());
	return "redirect:/member/mypage";
	}
	//회원정보 삭제
	
	// 로그인
	// 로그아웃
}
