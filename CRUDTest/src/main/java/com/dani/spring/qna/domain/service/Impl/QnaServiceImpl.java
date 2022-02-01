package com.dani.spring.qna.domain.service.Impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dani.spring.notice.domain.PageInfo;
import com.dani.spring.qna.domain.Qna;
import com.dani.spring.qna.domain.service.QnaService;
import com.dani.spring.qna.domain.store.QnaStore;

@Service
public class QnaServiceImpl implements QnaService {

	@Autowired
	private QnaStore qStore;

	@Override
	public int getListCount() {
		int listCount = qStore.selectListCount();
		return listCount;
	}

	@Override
	public ArrayList<Qna> printAll(PageInfo pi) {
		ArrayList<Qna> nList = qStore.selectAllList(pi);
		return null;
	}

	@Override
	public int registerQuestion(Qna qna) {
		int result = qStore.insertQuestion(qna);
		return result;
	}

}
