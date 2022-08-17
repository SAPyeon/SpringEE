package org.sap.service;

import java.util.ArrayList;

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
}
