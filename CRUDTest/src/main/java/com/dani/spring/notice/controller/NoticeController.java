package com.dani.spring.notice.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dani.spring.common.Pagination;
import com.dani.spring.notice.domain.Notice;
import com.dani.spring.notice.domain.PageInfo;
import com.dani.spring.notice.service.NoticeService;

@Controller
public class NoticeController {
	
	@Autowired
	private NoticeService nService;

	@RequestMapping (value="noticeList.di", method=RequestMethod.GET)
	public String noticeListView(HttpServletRequest request) {
//	public ModelAndView noticeListView(ModelAndView mv, @RequestParam(value="page", required=false) Integer page) {
//		
//		int currentPage = (page != null) ? page : 1;
//		int listCount = nService.getListCount();
//		PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
//		
//		ArrayList<Notice> nList = nService.printAll(pi);
//		
//		if(nList != null) {
//			mv.addObject("nList", nList);
//			mv.addObject("pi", pi);
//			mv.setViewName("notice/noticeList.jsp");
//		}else {
//			mv.addObject("msg", "공지사항 조회 실패");
//			mv.setViewName("errorPage");
//		}
//		
//		return mv;
		return "notice/noticeList";
	}
}
