package com.dani.spring.qna.domain.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dani.spring.common.Pagination;
import com.dani.spring.notice.domain.PageInfo;
import com.dani.spring.qna.domain.Qna;
import com.dani.spring.qna.domain.service.QnaService;

@Controller
public class QnaController {
	
	@Autowired
	private QnaService qService;

	@RequestMapping(value="qnaList.di", method=RequestMethod.GET)
	public String qnaListView(Model model, @RequestParam(value="page", required=false) Integer page) {
		int currentPage = (page != null) ? page : 1;
		int listCount = qService.getListCount();
		PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
		
		ArrayList<Qna> qnaList = qService.printAll(pi);
		
		if(qnaList.size() > 0) {
			model.addAttribute("pi", pi);
			model.addAttribute("qnaList", qnaList);
			
			return "qna/qnaList";
		}else {
			return "errorPage";
		}
	}
}
