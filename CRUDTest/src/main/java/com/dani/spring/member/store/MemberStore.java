package com.dani.spring.member.store;

import com.dani.spring.member.domain.Member;

public interface MemberStore {
	public Member selectOneMember(Member member);
	public int checkIdDup(String userId);
	public int insertMember(Member member);
	public int updateMember(Member member);
	public int deleteMember(String userId);
}
