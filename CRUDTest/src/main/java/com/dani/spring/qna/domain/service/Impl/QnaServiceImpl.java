package com.dani.spring.qna.domain.service.Impl;

import java.util.ArrayList;
import java.util.Map;

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
		return nList;
	}

	@Override
	public int registerQuestion(Qna qna) {
		int result = qStore.insertQuestion(qna);
		return result;
	}

	@Override
	public Qna printOne(int qnaNo) {
		Qna qOne = qStore.selectOneQuestion(qnaNo);
		return qOne;
	}

	@Override
	public int modifyQna(Qna qna) {
		int result = qStore.updateQuestion(qna);
		return result;
	}

    @Override
    public Qna printPrivateOne(Map<String, Integer> chkMap) {
        Qna qOne = qStore.printPrivateOne(chkMap);
        return qOne;
    }

}
