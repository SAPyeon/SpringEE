package org.sap.model;

public class PageVo {
	// 시작번호
	private int startPage;
	// 끝번호
	private int endPage;
	// 이전버튼
	private boolean prev;
	// 다음버튼
	private boolean next;
	// CriteriaVo포함
	private CriteriaVo cri;
	// board테이블의 전체건수를 저장
	private int total;

	// 생성자(매개변수가 두개인 생성자)
	public PageVo(CriteriaVo cri, int total) {
		this.cri = cri;
		this.total = total;

		// 시작번호, 끝번호, 이전버튼, 다음버튼 계산
		// 끝번호 식 : 현재페이지 /10 (올림)*10
		this.endPage = (int) (Math.ceil(cri.getPageNum() / 10.0)) * 10;
		// 시작번호 식 : 끝번호 -9
		this.startPage = this.endPage - 9;
		// 제일 마지막 페이지번호는 전체건수를 고려해야 함.
		// 제일 마지막 끝번호 식 : 전체건수(올림)/페이지당 게시물 갯수
		int realEnd = (int) (Math.ceil((total * 1.0) / cri.getAmount()));
		// 예시 : 123개 => 123*1.0=123.0 => 123.0/10 = 12.3 => 12.3 올림 = 13
		// 13(realEnd) <20(endPage)면
		// realEnd가 적용되게 함
		if (realEnd < endPage) {
			this.endPage = realEnd;
		}
		// startPage가 1보다 크면 이전버튼 활성화
		this.prev = this.startPage > 1;

		// endPage가 realEnd보다 작으면
		this.next = this.endPage < realEnd;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public CriteriaVo getCri() {
		return cri;
	}

	public void setCri(CriteriaVo cri) {
		this.cri = cri;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "PageVo [startPage=" + startPage + ", endPage=" + endPage + ", prev=" + prev + ", next=" + next
				+ ", cri=" + cri + ", total=" + total + "]";
	}

}
