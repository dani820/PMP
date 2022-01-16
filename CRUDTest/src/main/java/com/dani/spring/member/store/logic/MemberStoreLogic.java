package com.dani.spring.member.store.logic;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dani.spring.member.domain.Member;
import com.dani.spring.member.store.MemberStore;

@Repository
public class MemberStoreLogic implements MemberStore {

	// dbcp 에서 연결을 만들어서 꺼내서 쓰기 위해 사용
	// root-context.xml 에서 만든 빈 객체 sqlSession 사용하는 것
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public Member selectOneMember(Member member) {
		// 매개변수에 매치할 매퍼의 이름과 사용할 구문의 id 값 작성해서 매치
		Member loginUser = sqlSession.selectOne("memberMapper.selectOneMember", member);
		return loginUser;
	}

	@Override
	public int checkIdDup(String userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertMember(Member member) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateMember(Member member) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember(String userId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
