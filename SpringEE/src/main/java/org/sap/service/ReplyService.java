package org.sap.service;

import java.util.ArrayList;

import org.sap.model.ReplyVo;

//댓글관련 서비스
public interface ReplyService {
	//댓글쓰기를 위한 설계
	public int rewrite(ReplyVo reply);
	//댓글목록리스트를 위한 설계
	public ArrayList<ReplyVo> list(int bno);
}
