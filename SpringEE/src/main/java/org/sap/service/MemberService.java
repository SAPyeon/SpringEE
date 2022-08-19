package org.sap.service;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.sap.model.MemberVo;

public interface MemberService {
	//회원가입 설계
	public void signup(MemberVo mvo);
	//회원목록리스트 설계
	public  ArrayList<MemberVo> list();
	//회원조회 설계
	public MemberVo mypage(MemberVo mvo);
	//회원조회 후 수정 설계
	public void modify(MemberVo mvo);
	//조회된 회원 삭제 설계
	public void remove(MemberVo mvo);
	//로그인 설계
	public MemberVo login(MemberVo mvo, HttpSession session);
	//로그아웃 설계
	public void logout(HttpSession session);
}
