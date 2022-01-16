package com.dani.spring.member.service;

import com.dani.spring.member.domain.Member;

public interface MemberService {
	public Member loginMember(Member member);
	public int checkId(String userId);
	public int registerMember(Member member);
	public int modifyMember(Member member);
	public int deleteMember(String userId);
}
