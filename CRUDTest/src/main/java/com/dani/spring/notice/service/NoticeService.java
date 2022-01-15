package com.dani.spring.notice.service;

import java.util.ArrayList;

import com.dani.spring.notice.domain.Notice;
import com.dani.spring.notice.domain.PageInfo;

public interface NoticeService {

	int getListCount();
	ArrayList<Notice> printAll(PageInfo pi);

}
