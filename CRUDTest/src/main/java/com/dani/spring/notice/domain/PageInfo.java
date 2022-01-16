package com.dani.spring.notice.domain;

public class PageInfo {
	private int currentPage;
	private int boardLimit;
	private int startPage;
	private int endPage;
	private int maxPage;
	private int listCount;
	
	public PageInfo() {}

	public PageInfo(int currentPage, int boardLimit, int startPage, int endPage, int maxPage, int listCount) {
		super();
		this.currentPage = currentPage;
		this.boardLimit = boardLimit;
		this.startPage = startPage;
		this.endPage = endPage;
		this.maxPage = maxPage;
		this.listCount = listCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getBoardLimit() {
		return boardLimit;
	}

	public void setBoardLimit(int boardLimit) {
		this.boardLimit = boardLimit;
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

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public int getListCount() {
		return listCount;
	}

	public void setListCount(int listCount) {
		this.listCount = listCount;
	}

	@Override
	public String toString() {
		return "PageInfo [currentPage=" + currentPage + ", boardLimit=" + boardLimit + ", startPage=" + startPage
				+ ", endPage=" + endPage + ", maxPage=" + maxPage + ", listCount=" + listCount + "]";
	}
	
}
