package org.sap.mapper;

import java.util.ArrayList;

import org.sap.model.AttachFileVo;

public interface BoardAttachMapper {
	//글쓰기할 당시에 첨부파일 DB작업설계
	public void insert(AttachFileVo attach);
	//해당게시물의 첨부파일 조회
	public ArrayList<AttachFileVo> attachlist(int bno);
	//해당게시물 첨부파일 삭제
	public void remove(int bno);
}
