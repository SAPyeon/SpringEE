package org.sap.mapper;

import java.util.ArrayList;

import org.sap.model.MemberVo;

public interface MemberMapper {
	//회원가입 DB설계
	public void signup(MemberVo mvo);
	//회원목록리스트 DB설계
	public ArrayList<MemberVo> list();
	//회원조회 DB설계
	public MemberVo mypage(MemberVo mvo);
	//회원정보 수정 DB설계
	public void modify(MemberVo mvo);
	//회원정보 삭제 DB설계
	public void remove(MemberVo mvo);
	//로그인정보 DB설계
	public MemberVo login(MemberVo mvo);
}
