package com.dani.spring.common;

import com.dani.spring.notice.domain.PageInfo;

public class Pagination {
	public static PageInfo getPageInfo(int currentPage, int listCount) {
		PageInfo pi = null;
		int pageLimit = 10;
		int boardLimit = 5;
		int maxPage;
		int startPage;
		int endPage;
		
		maxPage = (int)((double)listCount / boardLimit + 0.9);
		startPage = ((int)((double)currentPage / pageLimit + 0.9) - 1) * pageLimit + 1;
		endPage = startPage + pageLimit - 1;
		
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		pi = new PageInfo(currentPage, boardLimit, startPage, endPage, maxPage, listCount);
		
		return pi;
	}

}
