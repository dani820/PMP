package com.dani.spring.notice.store;

import java.util.ArrayList;

import com.dani.spring.notice.domain.Notice;
import com.dani.spring.notice.domain.PageInfo;

public interface NoticeStore {

	ArrayList<Notice> selectNList(PageInfo pi);

}
