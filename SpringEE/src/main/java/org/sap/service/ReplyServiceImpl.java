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
	public ArrayList<ReplyVo> list(int bno){
		return rm.list(bno);
	}
	
}
