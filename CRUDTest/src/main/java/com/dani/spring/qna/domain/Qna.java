package com.dani.spring.qna.domain;

import java.sql.Date;

public class Qna {
	private int qnaNo;
	private String qnaTitle;
	private String qnaContent;
	private String qnaWriter;
	private Date qCreateDate;
	private Date qUpdateDate;
	private String originFileName; // 사용자가 올리는 파일명
	private String renameFileName; // 파일명 중복 방지 위해 내부 db 에서 지정하는 파일명
	private String qnaPublicYn;
	private int qnaCount;
	
	public int getQnaNo() {
		return qnaNo;
	}
	public void setQnaNo(int qnaNo) {
		this.qnaNo = qnaNo;
	}
	public String getQnaTitle() {
		return qnaTitle;
	}
	public void setQnaTitle(String qnaTitle) {
		this.qnaTitle = qnaTitle;
	}
	public String getQnaContent() {
		return qnaContent;
	}
	public void setQnaContent(String qnaContent) {
		this.qnaContent = qnaContent;
	}
	public String getQnaWriter() {
		return qnaWriter;
	}
	public void setQnaWriter(String qnaWriter) {
		this.qnaWriter = qnaWriter;
	}
	public Date getqCreateDate() {
		return qCreateDate;
	}
	public void setqCreateDate(Date qCreateDate) {
		this.qCreateDate = qCreateDate;
	}
	public Date getqUpdateDate() {
		return qUpdateDate;
	}
	public void setqUpdateDate(Date qUpdateDate) {
		this.qUpdateDate = qUpdateDate;
	}
	public String getOriginFileName() {
		return originFileName;
	}
	public void setOriginFileName(String originFileName) {
		this.originFileName = originFileName;
	}
	public String getRenameFileName() {
		return renameFileName;
	}
	public void setRenameFileName(String renameFileName) {
		this.renameFileName = renameFileName;
	}
	public String getQnaPublicYn() {
		return qnaPublicYn;
	}
	public void setQnaPublicYn(String qnaPublicYn) {
		this.qnaPublicYn = qnaPublicYn;
	}
	public int getQnaCount() {
		return qnaCount;
	}
	public void setQnaCount(int qnaCount) {
		this.qnaCount = qnaCount;
	}
	
	@Override
	public String toString() {
		return "Qna [qnaNo=" + qnaNo + ", qnaTitle=" + qnaTitle + ", qnaContent=" + qnaContent + ", qnaWriter="
				+ qnaWriter + ", qCreateDate=" + qCreateDate + ", qUpdateDate=" + qUpdateDate + ", originalFileName="
				+ originFileName + ", renameFileName=" + renameFileName	+ ", qnaPublicYn=" + qnaPublicYn + ", qnaCount=" + qnaCount + "]";
	}
	
	
}
