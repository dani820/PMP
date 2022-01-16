package com.dani.spring.notice.domain;

import java.sql.Date;

public class Notice {
	private int noticeNo;
	private String noticeTitle;
	private String noticeContents;
	private String noticeWriter;
	private Date nCreateDate;
	private Date nUpdateDate;
	private String noticeFilePath;
	
	public Notice() {}
	
	public Notice(int noticeNo, String noticeTitle, String noticeContents, String noticeWriter, Date nCreateDate,
			Date nUpdateDate, String noticeFilePath) {
		super();
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeContents = noticeContents;
		this.noticeWriter = noticeWriter;
		this.nCreateDate = nCreateDate;
		this.nUpdateDate = nUpdateDate;
		this.noticeFilePath = noticeFilePath;
	}
	
	public int getNoticeNo() {
		return noticeNo;
	}
	
	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}
	
	public String getNoticeTitle() {
		return noticeTitle;
	}
	
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	
	public String getNoticeContents() {
		return noticeContents;
	}
	
	public void setNoticeContents(String noticeContents) {
		this.noticeContents = noticeContents;
	}
	
	public String getNoticeWriter() {
		return noticeWriter;
	}
	
	public void setNoticeWriter(String noticeWriter) {
		this.noticeWriter = noticeWriter;
	}
	
	public Date getnCreateDate() {
		return nCreateDate;
	}
	
	public void setCreateDate(Date nCreateDate) {
		this.nCreateDate = nCreateDate;
	}
	
	public Date getnUpdateDate() {
		return nUpdateDate;
	}
	
	public void setUpdateDate(Date nUpdateDate) {
		this.nUpdateDate = nUpdateDate;
	}
	
	public String getNoticeFilePath() {
		return noticeFilePath;
	}
	
	public void setNoticeFilePath(String noticeFilePath) {
		this.noticeFilePath = noticeFilePath;
	}

	@Override
	public String toString() {
		return "Notice [noticeNo=" + noticeNo + ", noticeTitle=" + noticeTitle + ", noticeContents=" + noticeContents
				+ ", noticeWriter=" + noticeWriter + ", nCreateDate=" + nCreateDate + ", nUpdateDate=" + nUpdateDate
				+ ", noticeFilePath=" + noticeFilePath + "]";
	}
	
}
