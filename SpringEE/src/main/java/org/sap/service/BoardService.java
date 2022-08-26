package org.sap.service;

import java.util.ArrayList;

import org.sap.model.AttachFileVo;
import org.sap.model.BoardVo;
import org.sap.model.CriteriaVo;

public interface BoardService {
	//글쓰기 설계             (BoardVo : 게시판정보 + 파일업로드 정보)
	public void write(BoardVo bvo);
	//리스트 설계
	public ArrayList<BoardVo> list(CriteriaVo cri);
	//상세페이지 설계
	public BoardVo detail(BoardVo bvo);
	//글 수정 페이지 설계
	public void modify(BoardVo bvo);
	// 글 삭제 페이지 설계
	public void remove(BoardVo bvo);
	//board테이블 전체건수 설계
	public int total(CriteriaVo cri);
	//첨부파일 조회설계
	public ArrayList<AttachFileVo> attachlist(int bno);
	
}
