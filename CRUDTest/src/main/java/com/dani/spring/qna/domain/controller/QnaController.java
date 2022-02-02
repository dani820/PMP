package com.dani.spring.qna.domain.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.dani.spring.common.Pagination;
import com.dani.spring.member.domain.Member;
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
		
		for(Qna q : qnaList) {
			System.out.println("q : " + q.getQnaNo());
			
		}
		
		if(qnaList.size() > 0) {
			model.addAttribute("pi", pi);
			model.addAttribute("qnaList", qnaList);
			
			return "qna/qnaList";
		}else {
			return "errorPage";
		}
	}
	
	@RequestMapping(value="qnaDetailView.di", method=RequestMethod.GET)
	public String qnaDetailView(Model model, @RequestParam("qnaNo") int qnaNo) {
		Qna qOne = qService.printOne(qnaNo);
		
		if(qOne == null) {
			return "errorPage";
		} else {
			model.addAttribute("qOne", qOne);
			return "qna/qnaDetailView";
		}
		
	}
	
	@RequestMapping(value="qnaWriteView.di", method=RequestMethod.GET)
	public String qnaWriteView() {
		return "qna/qnaWriteView";
	}
	
	@RequestMapping(value="qnaRegister.di", method=RequestMethod.POST)
	public String qnaRegister(HttpServletRequest request, @ModelAttribute Qna qna, @RequestParam(value="uploadFile", required=false) MultipartFile uploadFile) {
		
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("loginUser");
		qna.setQnaWriter(member.getUserId());
		
		if(!uploadFile.getOriginalFilename().equals("")) {
			String filePath = saveFile(uploadFile, request);
			if(filePath != null) {
				qna.setQnaFilePath(filePath);
			}
		}
		
		int result = 0;
		result = qService.registerQuestion(qna);
		
		if(result < 0) {
			return "errorPage";
		} else {
			return "redirect:qnaList.di";
		}
	}

	private String saveFile(MultipartFile uploadFile, HttpServletRequest request) {
		String root = request.getSession().getServletContext().getRealPath("resources");
		String savePath = root + File.separator + "qnaUpload";
		
		File folder = new File(savePath);
		
		if(!folder.exists()) {
			folder.mkdir();
		}
		
		String filePath = folder + File.separator + uploadFile.getOriginalFilename();
		
		try {
			// MultipartFile 로 된 uploadFile 을 file 객체에 넣어 
			// 실제 경로인 filePath 에 넣어주겠다는 의미
			// 이 부분이 존재해야만 파일 등록이 가능하다.
			uploadFile.transferTo(new File(filePath));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(savePath + "파일 저장");
		
		// 이클립스 workspace 에 실제 파일 저장하기
		return filePath;
	}
	
	@RequestMapping(value="qnaUpdateView.di", method=RequestMethod.GET)
	public String qnaModifyView(Model model, @RequestParam(value="qnaNo") int qnaNo) {
		Qna qOne = qService.printOne(qnaNo);
		
		model.addAttribute("qOne", qOne);
		return "qna/qnaUpdateView";
	}
	
	@RequestMapping(value="qnaModify.di", method=RequestMethod.POST)
	public String qnaModify(HttpServletRequest request, @RequestParam(value="reloadFile", required=false) MultipartFile reloadFile) {
		
		
		return "redirect:qnaList.di";
	}
}
