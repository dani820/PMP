package com.dani.spring.qna.domain;

import java.sql.Date;

public class Qna {
	private int qnaNo;
	private String qnaTitle;
	private String qnaContent;
	private String qnaWriter;
	private Date qCreateDate;
	private Date qUpdateDate;
	private String qnaOriginalFileName;
	private String qnaRenameFileName;
	private String qnaFilePath;
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
	public String getQnaOriginalFileName() {
		return qnaOriginalFileName;
	}
	public void setQnaOriginalFileName(String qnaOriginalFileName) {
		this.qnaOriginalFileName = qnaOriginalFileName;
	}
	public String getQnaRenameFileName() {
		return qnaRenameFileName;
	}
	public void setQnaRenameFileName(String qnaRenameFileName) {
		this.qnaRenameFileName = qnaRenameFileName;
	}
	public String getQnaFilePath() {
		return qnaFilePath;
	}
	public void setQnaFilePath(String qnaFilePath) {
		this.qnaFilePath = qnaFilePath;
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
				+ qnaWriter + ", qCreateDate=" + qCreateDate + ", qUpdateDate=" + qUpdateDate + ", qnaOriginalFileName="
				+ qnaOriginalFileName + ", qnaRenameFileName=" + qnaRenameFileName + ", qnaFilePath=" + qnaFilePath
				+ ", qnaPublicYn=" + qnaPublicYn + ", qnaCount=" + qnaCount + "]";
	}
	
	
}
