package org.sap.service;

import java.util.ArrayList;

import org.sap.mapper.ReplyMapper;
import org.sap.model.ReplyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyServiceImpl implements ReplyService{
	@Autowired
	ReplyMapper rm;
	
	//댓글쓰기을 위한 추상메서드를 구현
	public int rewrite(ReplyVo reply) {
		return rm.rewrite(reply);
	}
	//댓글 목록 리스트를 위한 추상메서드를 구현
	public ArrayList<ReplyVo> list(int bno){
		return rm.list(bno);
	}
	//댓글 수정을 위한 추상메서드를 구현
	public int modify(ReplyVo reply) {
		System.out.println(reply);
		return rm.modify(reply);
	}
	//댓글삭제를 위한 추상메서드를 구현
	public int remove(int rno) {
		return rm.remove(rno);
	}
}
