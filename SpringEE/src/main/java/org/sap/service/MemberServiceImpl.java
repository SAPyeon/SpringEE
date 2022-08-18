package org.sap.service;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.sap.mapper.MemberMapper;
import org.sap.model.MemberVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberMapper mm;

	public void signup(MemberVo mvo) {
		mm.signup(mvo);
	}

	public ArrayList<MemberVo> list() {
		return mm.list();
	}

	public MemberVo mypage(MemberVo mvo) {
		return mm.mypage(mvo);
	}

	public void modify(MemberVo mvo) {
		mm.modify(mvo);
	}

	public void remove(MemberVo mvo) {
		mm.remove(mvo);
	}

	public MemberVo login(MemberVo mvo, HttpSession session) {
		MemberVo name = mm.login(mvo);
		if (name != null) { // 세션 변수 저장
			session.setAttribute("userid", mvo.getId());
			session.setAttribute("name", name);
		}
		System.out.println(session.getAttribute("userid"));
		System.out.println(session.getAttribute("name"));
		return name;
	}
}
