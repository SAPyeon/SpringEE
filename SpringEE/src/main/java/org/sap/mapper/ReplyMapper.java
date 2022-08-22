package org.sap.mapper;

import java.util.ArrayList;

import org.sap.model.ReplyVo;
//댓글 관련 mapper
public interface ReplyMapper {
	//댓글쓰기를 위한 DB설계
	//return타입이 int일 때, 1이면 insert성공, 0이면 insert실패
	public int rewrite(ReplyVo reply);
	//댓글 목록 리스트를 위한 DB설계
	public ArrayList<ReplyVo> list(int bno);
	//댓글 수정을 위한 DB설계
	public int modify(ReplyVo reply);
	//댓글 삭제를 위한 DB설계
	public int remove(int rno);
}
