package com.dani.spring.qna.domain.store;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.dani.spring.notice.domain.PageInfo;
import com.dani.spring.qna.domain.Qna;

public interface QnaStore {

	int selectListCount();
	ArrayList<Qna> selectAllList(PageInfo pi);
	int insertQuestion(Qna qna);
	Qna selectOneQuestion(int qnaNo);
	int updateQuestion(Qna qna);
    Qna printPrivateOne(Map<String, Integer> chkMap);

}	
