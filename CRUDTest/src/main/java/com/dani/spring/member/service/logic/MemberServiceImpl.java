package com.dani.spring.member.service.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dani.spring.member.domain.Member;
import com.dani.spring.member.service.MemberService;
import com.dani.spring.member.store.MemberStore;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberStore mStore;

	@Override
	public Member loginMember(Member member) {
		Member mOne = mStore.selectOneMember(member);
		return mOne;
	}

	@Override
	public int checkId(String userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int registerMember(Member member) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyMember(Member member) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember(String userId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
