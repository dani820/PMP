package com.dani.spring.qna.domain.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.dani.spring.notice.domain.PageInfo;
import com.dani.spring.qna.domain.Qna;

public interface QnaService {

	int getListCount();
	ArrayList<Qna> printAll(PageInfo pi);
	int registerQuestion(Qna qna);
	Qna printOne(int qnaNo);
	int modifyQna(Qna qna);

}
