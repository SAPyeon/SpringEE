package org.sap.service;

import java.util.ArrayList;

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
}
