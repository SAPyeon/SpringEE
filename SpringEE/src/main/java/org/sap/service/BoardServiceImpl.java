package org.sap.service;

import java.util.ArrayList;

import org.sap.mapper.BoardMapper;
import org.sap.model.BoardVo;
import org.sap.model.CriteriaVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardMapper bm;

	// BoardService에서 설계되어진 write추상메서드를 구현
	public void write(BoardVo bvo) {
		// BoardMapper에 있는 write메서드를 호출
		// 메서드의 매개변수를 통해 BoardVo를 호출
		// BoardMapper의 write메서드를 사용
		bm.write(bvo);
	}

	public ArrayList<BoardVo> list(CriteriaVo cri) {
		// System.out.println(cri);
		return bm.list(cri);
	}
	@Transactional
	public BoardVo detail(BoardVo bvo) {	
		//상세페이지 조회할 때 조회수 +1을 update
		bm.cntup(bvo);
		return bm.detail(bvo);
	}

	public void modify(BoardVo bvo) {
		bm.modify(bvo);
	}

	// BoardService에서 설계되어진 remove 추상메서드를 구현
	public void remove(BoardVo bvo) {
		bm.remove(bvo);
	}

	public int total(CriteriaVo cri) {
		return bm.total(cri);
	}
}
