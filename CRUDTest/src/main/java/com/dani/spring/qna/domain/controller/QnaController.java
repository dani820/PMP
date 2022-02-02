package com.dani.spring.qna.domain.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
		
		if(!uploadFile.getOriginalFilename().equals("")) {
			String renameFileName = saveFile(uploadFile, request);
			if(renameFileName != null) {
				qna.setOriginFileName(uploadFile.getOriginalFilename());
				qna.setRenameFileName(renameFileName);
			}
		}
		
		int result = 0;
		result = qService.registerQuestion(qna);
		
		if(result <= 0) {
			return "errorPage";
		} else {
			return "redirect:qnaList.di";
		}
	}

	private String saveFile(MultipartFile file, HttpServletRequest request) {
		String root = request.getSession().getServletContext().getRealPath("resources");
		String savePath = root + File.separator + "qnaUpload";
		
		// java.io 패키지의 File 객체
		File folder = new File(savePath);
		
		if(!folder.exists()) {
			folder.mkdir();
		}
		
		// 파일명 변경
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String originalFileName = file.getOriginalFilename();
		// indexOf() 는 왼쪽부터 세서 괄호 안 요소의 인덱스 값을 알려준다.
		// lastIndexOf() 는 탐색 문자열이 마지막으로 등장하는 위치에 대한 index 를 반환한다.
		// 즉 originalFileName.substring(originalFileName.lastIndexOf(".")+1 는
		// 파일의 확장자를 가져오는 구문
		
		// System.currentTimeMillis() 는 오늘 날짜의 시분초까지 포함하여
		// sdf 객체 생성한대로 yyyyMMddHHmmss 형태로 출력된다.
		String renameFileName = sdf.format(new Date(System.currentTimeMillis())) + "." + originalFileName.substring(originalFileName.lastIndexOf(".")+1);
		
		String filePath = folder + File.separator + renameFileName;
		
		try {
			// MultipartFile 로 된 uploadFile 을 file 객체에 넣어 
			// 실제 경로인 filePath 에 넣어주겠다는 의미
			// 이 부분이 존재해야만 파일 등록이 가능하다.
			file.transferTo(new File(filePath));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(savePath + "파일 저장");
		
		// 이클립스 workspace 에 실제 파일 저장하기
		return renameFileName;
	}
	
	@RequestMapping(value="qnaUpdateView.di", method=RequestMethod.GET)
	public String qnaModifyView(Model model, @RequestParam(value="qnaNo") int qnaNo) {
		Qna qOne = qService.printOne(qnaNo);
		
		model.addAttribute("qOne", qOne);
		return "qna/qnaUpdateView";
	}
	
	@RequestMapping(value="qnaModify.di", method=RequestMethod.POST)
	public String qnaModify(HttpServletRequest request, @ModelAttribute Qna qOne, @RequestParam(value="reloadFile", required=false) MultipartFile reloadFile) {
		if(reloadFile != null && !reloadFile.isEmpty()) {
			if(qOne.getOriginFileName() != "") {
				// resources 경로 가져오기 위해 request 객체 파라미터로 넘겨준다.
				deleteFile(qOne.getRenameFileName(), request);
			}
			
			String renameFileName = saveFile(reloadFile, request);
			if(renameFileName != null) {
				qOne.setOriginFileName(reloadFile.getOriginalFilename());
				qOne.setRenameFileName(renameFileName);
			}
		}
		
		int result = qService.modifyQna(qOne);
		if(result <= 0) {
			return "errorPage";
		}else {
			return "redirect:qnaDetailView.di?qnaNo="+qOne.getQnaNo();
		}
		
	}

	private void deleteFile(String fileName, HttpServletRequest request) {
		// 세션에서 context 에 대한 모든 정보를 가지고 있는 서블릿 컨텍스를 통해
		// resources 의 실제 경로를 가져올 수 있다.
		String root = request.getSession().getServletContext().getRealPath("resources");
		String savePath = root + File.separator + "qnaUpload";
		File file = new File(savePath + File.separator + fileName);
		
		// file 객체의 exists 메소드를 통해 해당하는 실제 파일을 지울 수 있다.
		if(file.exists()) {
			file.delete();
		}
		
	}
}
