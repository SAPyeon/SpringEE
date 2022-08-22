package org.sap.model;

import org.springframework.web.multipart.MultipartFile;

public class ReviewVo {
	private int idx;
	private String id;
	private int estimate;
	private String pname;
	private String img_file;
	private int cnt;
	private String r_content;
	private String r_title;
	private String r_regdate;
	private MultipartFile uploadFile;
	
	public String getR_title() {
		return r_title;
	}
	public void setR_title(String r_title) {
		this.r_title = r_title;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getEstimate() {
		return estimate;
	}
	public void setEstimate(int estimate) {
		this.estimate = estimate;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getImg_file() {
		return img_file;
	}
	public void setImg_file(String img_file) {
		this.img_file = img_file;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public String getR_content() {
		return r_content;
	}
	public void setR_content(String r_content) {
		this.r_content = r_content;
	}
	public String getR_regdate() {
		return r_regdate;
	}
	public void setR_regdate(String r_regdate) {
		this.r_regdate = r_regdate;
	}
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	@Override
	public String toString() {
		return "ReviewVo [idx=" + idx + ", id=" + id + ", estimate=" + estimate + ", pname=" + pname + ", img_file="
				+ img_file + ", cnt=" + cnt + ", r_content=" + r_content + ", r_title=" + r_title + ", r_regdate="
				+ r_regdate + ", uploadFile=" + uploadFile + "]";
	}
	
	
}
