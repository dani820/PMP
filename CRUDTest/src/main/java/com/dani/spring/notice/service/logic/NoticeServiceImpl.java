package com.dani.spring.notice.service.logic;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dani.spring.notice.domain.Notice;
import com.dani.spring.notice.domain.PageInfo;
import com.dani.spring.notice.service.NoticeService;
import com.dani.spring.notice.store.NoticeStore;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeStore nStore;
	
	@Override
	public int getListCount() {
		return 0;
	}

	@Override
	public ArrayList<Notice> printAll(PageInfo pi) {
		ArrayList<Notice> nList = nStore.selectNList(pi);
		return nList;
	}

}