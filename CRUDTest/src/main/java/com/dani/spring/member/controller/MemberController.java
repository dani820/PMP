package com.dani.spring.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dani.spring.member.domain.Member;
import com.dani.spring.member.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService mService;
	
	@RequestMapping(value="login.di", method=RequestMethod.POST)
	public String memberLogin(HttpServletRequest request) {
		
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		Member member = new Member(userId, userPw);
//		Member mOne = new Member(member.getUserId(), member.getUserPw());
		Member loginUser = mService.loginMember(member);
		
		if(loginUser != null) {
			System.out.println(loginUser.toString());
//			HttpSession session = request.getSession();
//			session.setAttribute("loginUser", loginUser);
			return "home";
		}else {
//			model.addAttribute("msg", "로그인 실패");
			return "errorPage";
		}
	}
}
