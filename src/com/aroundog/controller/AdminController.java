package com.aroundog.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.aroundog.model.domain.Admin;
import com.aroundog.model.service.AdminService;
import com.aroundog.model.service.FreeBoardService;
import com.aroundog.model.service.ReportService;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;
	@Autowired
	private FreeBoardService freeBoardService;
	@Autowired
	private ReportService reportService;
	//userservice-->���
	//������ �α��� ��û
	@RequestMapping(value="/admin/login", method=RequestMethod.GET)
	public String adminLogin(Admin admin, HttpServletRequest request) {
		Admin obj=adminService.loginCheck(admin);
		request.getSession().setAttribute("admin", obj);
		return "redirect:/admin/main";
	}
	
	//������ �α��� ������ �̵�
	@RequestMapping(value="/admin/main", method=RequestMethod.GET)
	public String goMain(HttpServletRequest request) {
		//�α��� ������ �ٷ� ȸ�������� ������������ DB���� ȸ�� ���� �ܾ�;���
		List freeBoardList=freeBoardService.selectAll();
		//System.out.println(freeBoardList);
		request.setAttribute("freeBoardList", freeBoardList);
		return "admin/main/main";
	}
	
	//������ ��忡�� ����Ʈ �ҷ�����
	@RequestMapping(value="/users",method=RequestMethod.GET)
	public String userList() {	
		return "admin/user/index";
	}
	@RequestMapping(value="/reports",method=RequestMethod.GET)
	public ModelAndView reportList() {	
		List reportList=reportService.selectAll();//�𵨾غ�� ����Ʈ ��ȯ�ϰ�.. jsp���� ����Ʈ �޾Ƽ� ��� ���!!
		System.out.println("Report���̺��� �������"+reportList.size());
		ModelAndView mav = new ModelAndView("admin/report/index");
		mav.addObject("reportList", reportList);
		return mav;
	}
	@RequestMapping(value="/adopts",method=RequestMethod.GET)
	public String adoptList() {	
		return "admin/adopt/index";
	}
	@RequestMapping(value="/freeboards",method=RequestMethod.GET)
	public String freeBoardList() {	
		List freeBoardList=freeBoardService.selectAll();
		return "admin/freeboard/index";
	}
	@RequestMapping(value="/adoptmanagers",method=RequestMethod.GET)
	public String adoptManagerList() {	
		return "admin/adoptmanager/index";
	}
	

	
}
