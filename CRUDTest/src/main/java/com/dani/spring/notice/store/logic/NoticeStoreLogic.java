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
	public int selectListCount() {
		int listCount = sqlSession.selectOne("noticeMapper.selectListCount");
		return listCount;
	}
	
	@Override
	public ArrayList<Notice> selectNList(PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		
		return (ArrayList)sqlSession.selectList("noticeMapper.selectAllList", null, rowBounds);
	}

	@Override
	public int insertNotice(Notice notice) {
		int result = sqlSession.insert("noticeMapper.insertNotice", notice);
		return result;
	}

	@Override
	public Notice selectOne(int noticeNo) {
		Notice notice = sqlSession.selectOne("noticeMapper.selectOne", noticeNo);
		return notice;
	}

	@Override
	public int updateNotice(Notice notice) {
		return sqlSession.update("noticeMapper.updateOne", notice);
	}

	@Override
	public int deleteOne(int noticeNo) {
		return sqlSession.delete("noticeMapper.deleteOne", noticeNo);
	}


}
