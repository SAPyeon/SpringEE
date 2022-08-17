package org.sap.mapper;

import java.util.ArrayList;

import org.sap.model.BoardVo;
import org.sap.model.CriteriaVo;

public interface BoardMapper {
	// 글쓰기에 해당되는 DB작업 설계
	public void write(BoardVo bvo);

	// 게시판 리스트에 해당하는 DB작업설계
	public ArrayList<BoardVo> list(CriteriaVo cri);

	// 게시판 상세페이지에 해당하는 DB작업설계
	public BoardVo detail(BoardVo bvo);

	// 목록리스트에서 제목을 클릭한 후 상세내용을 조회할 때 조회수도 같이 update하는 DB작업설계
	public void cntup(BoardVo bvo);

	// 상세내용에 해당되는 내용을 수정하는 DB작업설계
	public void modify(BoardVo bvo);

	// 상세내용에 해당되는 내용을 삭제하는 DB작업설계
	public void remove(BoardVo bvo);

	// board테이블에 전체건수에 해당되는 DB설계
	public int total();

}
