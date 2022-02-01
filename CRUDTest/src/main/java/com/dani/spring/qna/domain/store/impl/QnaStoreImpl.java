package com.dani.spring.qna.domain.store.impl;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dani.spring.notice.domain.PageInfo;
import com.dani.spring.qna.domain.Qna;
import com.dani.spring.qna.domain.store.QnaStore;

@Repository
public class QnaStoreImpl implements QnaStore {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int selectListCount() {
		int listCount = sqlSession.selectOne("qnaMapper.selectListCount");
		return listCount;
	}

	@Override
	public ArrayList<Qna> selectAllList(PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		
		ArrayList<Qna> qnaList = (ArrayList)sqlSession.selectList("qnaMapper.selectAllList", null, rowBounds);
		return qnaList;
	}

	@Override
	public int insertQuestion(Qna qna) {
		int result = sqlSession.insert("qnaMapper.insertQuestion", qna);
		return result;
	}

}
