package org.sap.model;
// pageNum(페이지번호)과 amount(한 페이지당 게시물 갯수)값을 전달하는 Model
public class CriteriaVo {
	private int pageNum; // 페이지 번호
	private int amount; //한 페이지당 게시물 갯수 
	
	//생성자
	public CriteriaVo() {
		this(1,10);
	}
	public CriteriaVo(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "CriteriaVo [pageNum=" + pageNum + ", amount=" + amount + "]";
	}
	
}
