package org.sap.controller;

import javax.servlet.http.HttpSession;

import org.sap.model.BoardVo;
import org.sap.model.MemberVo;
import org.sap.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
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
		return "redirect:/member/login";
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
		// 글 수정
		ms.modify(mvo);
		rttr.addAttribute("id", mvo.getId());
		return "redirect:/member/mypage";
	}

	// 회원정보 삭제
	@RequestMapping(value = "/member/remove", method = RequestMethod.POST)
	public String remove(MemberVo mvo) {
		// 글 수정
		ms.remove(mvo);
		return "redirect:/member/list";
	}

	// 로그인
	@RequestMapping(value = "/member/login", method = RequestMethod.GET)
	public void login(MemberVo mvo, HttpSession session) {
		ms.login(mvo, session);
	}

	@RequestMapping(value = "/member/login", method = RequestMethod.POST)
	public ModelAndView loginPost(@ModelAttribute MemberVo mvo, HttpSession session) {
		MemberVo name = ms.login(mvo, session);
		ModelAndView mav = new ModelAndView();
		if (name != null) { // 로그인 성공 시
			mav.setViewName("/home"); // 뷰의 이름
			mav.addObject("message", "success"); //뷰로 이동할 때 가져갈 변수 message에 success값을 넣음
		} else { // 로그인 실패 시
			mav.setViewName("member/login");
			mav.addObject("message", "error");
		}
		return mav;
	}

	// 로그아웃
	@RequestMapping(value = "/member/logout", method = RequestMethod.POST)
	public ModelAndView logout(HttpSession session, ModelAndView mav) {
		ms.logout(session);
		mav.setViewName("member/login");
		mav.addObject("message", "logout");
		return mav;
	}

}
