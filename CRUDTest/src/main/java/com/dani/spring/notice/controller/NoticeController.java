package com.dani.spring.notice.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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
//	public String noticeListView(HttpServletRequest request) {
	public ModelAndView noticeListView(ModelAndView mv, @RequestParam(value="page", required=false) Integer page) {
		
		int currentPage = (page != null) ? page : 1;
		int listCount = nService.getListCount();
		PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
		
		ArrayList<Notice> nList = nService.printAll(pi);
		
		if(nList != null) {
			mv.addObject("nList", nList);
			mv.addObject("pi", pi);
			mv.setViewName("notice/noticeList");
		}else {
			mv.addObject("msg", "공지사항 조회 실패");
			mv.setViewName("errorPage");
		}
		
		return mv;
//		return "notice/noticeList";
	}
	
	@RequestMapping(value="noticeWriteView.di", method=RequestMethod.GET)
	public String noticeWriteView() {
		return "notice/noticeWriteForm";
	}
	
	@RequestMapping (value="noticeWrite.di", method=RequestMethod.POST)
	public String registerNotice(@ModelAttribute Notice notice, @RequestParam(value="uploadFile", required=false) MultipartFile uploadFile, HttpServletRequest request, Model model) {
		if(!uploadFile.getOriginalFilename().equals("")) {
			String filePath = saveFile(uploadFile, request);
			if(filePath != null) {
				notice.setNoticeFilePath(uploadFile.getOriginalFilename());
			}
		}
		
		int result = 0;
		result = nService.registerNotice(notice);
		if(result > 0) {
			return "redirect:noticeList.di";
		}else {
			model.addAttribute("msg", "공지사항 등록 실패");
			return "errorPage";
		}
	}

	public String saveFile(MultipartFile uploadFile, HttpServletRequest request) {
//		depreacated > 더 이상 사용되지 않음
//		request.getRealPath("resources");
//		ServletContext().getRealPath("resources") 로 대체
		String root = request.getSession().getServletContext().getRealPath("resources");
		String savePath = root + "/noticeUpload";
		
		File folder = new File(savePath);
		
		if(!folder.exists()) {
			folder.mkdir();
		}
		
		String filePath = folder + "/" + uploadFile.getOriginalFilename();
		
		try {
			uploadFile.transferTo(new File(filePath));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return filePath;
	}
	
	@RequestMapping(value="noticeDetailView.di", method=RequestMethod.GET)
	public String noticeDetailView(@RequestParam("noticeNo") int noticeNo, Model model) {
		Notice notice = nService.printOne(noticeNo);
		
		if(notice != null) {
			model.addAttribute("notice", notice);
			return "notice/noticeDetailView";
		}else {
			model.addAttribute("msg", "공지사항 상세조회 실패");
			return "errorPage";
		}
	}
	
	@RequestMapping(value="modifyNoticeView.di", method=RequestMethod.GET)
	public String modifyNoticeView(@RequestParam("noticeNo") int noticeNo, Model model) {
		System.out.println("modify view noticeNo : " + noticeNo);
		Notice noticeOne = nService.printOne(noticeNo);
		model.addAttribute("notice", noticeOne);
		
		return "notice/noticeModifyForm";
	}
	
	@RequestMapping(value="modifyNotice.di", method=RequestMethod.POST)
	public String modifyNotice(@ModelAttribute Notice notice, @RequestParam(value="reloadFile", required=false) MultipartFile reloadFile, HttpServletRequest request, Model model) {
		if(reloadFile != null && !reloadFile.isEmpty()) {
			if(notice.getNoticeFilePath() != null) {
				deleteFile(notice.getNoticeFilePath(), request);
			}
			
			String savePath = saveFile(reloadFile, request);
			
			if(savePath != null) {
				notice.setNoticeFilePath(reloadFile.getOriginalFilename());
			}
		}else {
			
		}
		
		int result = nService.modifyNotice(notice);
		
		if(result > 0) {
			return "redirect:noticeDetailView.di?noticeNo=" + notice.getNoticeNo();
		}else {
			return "errorPage";
		}
	}

	public void deleteFile(String fileName, HttpServletRequest request) {
		String root = request.getSession().getServletContext().getRealPath("resources");
		String deletePath = root + "/noticeUpload";
		
		File deleteFile = new File(deletePath + "/" + fileName);
		
		if(deleteFile.exists()) {
			deleteFile.delete();
		}
	}
	
	@RequestMapping(value="deleteNotice.di", method=RequestMethod.GET)
	public String deleteNotice(@RequestParam("noticeNo") int noticeNo, HttpServletRequest request) {
		Notice notice = nService.printOne(noticeNo);
		int result = nService.deleteOne(noticeNo);
		
		if(result > 0) {
			if(notice.getNoticeFilePath() != null) {
				deleteFile(notice.getNoticeFilePath(), request);
			}
			return "redirect:noticeList.di";
		}else {
			return "errorPage";
		}
	}
}
