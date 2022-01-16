package com.dani.spring.notice.store.logic;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dani.spring.notice.domain.Notice;
import com.dani.spring.notice.domain.PageInfo;
import com.dani.spring.notice.store.NoticeStore;

@Repository
public class NoticeStoreLogic implements NoticeStore {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public ArrayList<Notice> selectNList(PageInfo pi) {
//		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
//		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		
//		return (ArrayList)sqlSession.selectList("boardMapper.selectAllList", null, rowBounds);
		return null;
	}

}
