package com.firstgroup.workerWeb.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.firstgroup.workerWeb.command.AmountVO;
import com.firstgroup.workerWeb.command.OfficeHourVO;
import com.firstgroup.workerWeb.command.WorkerVO;
import com.firstgroup.workerWeb.worker.service.WorkerService;

@Controller
@RequestMapping("/officehour")
public class OfficeHourController {

	@Autowired
	@Qualifier("workerService")
	WorkerService workerService;
	
	@RequestMapping("/viewtime")
	public void viewtime() {
	}
	
	@RequestMapping("/viewmoney")
	public void viewmoney() {
	}
	
	@RequestMapping("/sick")
	public String sick() {
		return"officehour/sick";
	}
	@RequestMapping("/vacation")
	public String vacation() {
		return"officehour/vacation";
	}
	
	@RequestMapping("/popdown")
	public void popdown() {}
	
	
	@RequestMapping("/homepage")
	public String homepage(HttpSession session) {
		
		if(session.getAttribute("sessionVO") != null) {
			return "officehour/homepage";
		} else {
			return "redirect:/worker/login";
		}
		
	}
	
	@RequestMapping("/work_start")
	public String work_start(RedirectAttributes RA, HttpSession session) {
		
		WorkerVO vo = (WorkerVO)session.getAttribute("sessionVO");
		
		int result = workerService.workStart(vo);
		
		if(result == 1) {
			RA.addFlashAttribute("msg", "출근 등록 완료했습니다 오늘 하루 힘내세요!");		
			return "redirect:homepage";
		} else {
			RA.addFlashAttribute("msg", "출근 등록에 실패했습니다 관리자에게 문의해주세요");
			return "redirect:homepage";
		}
	}
	
	@RequestMapping("/work_end")
	public String work_end(RedirectAttributes RA, HttpSession session) {
		
		WorkerVO vo = (WorkerVO)session.getAttribute("sessionVO");
		
		int result = workerService.workEnd(vo);
		
		if(result == 1) {
			RA.addFlashAttribute("msg", "퇴근 완료했습니다 수고 많으셨습니다!");		
			return "redirect:homepage";
		} else if(result == 2) {
			RA.addFlashAttribute("msg", "퇴근 정보를 업데이트 했습니다");
			return "redirect:homepage";
		}else {
			RA.addFlashAttribute("msg", "퇴근 등록에 실패했습니다 관리자에게 문의해주세요");
			return "redirect:homepage";
		}
	}
	
	@RequestMapping("/chooseDayOff")
	public String chooseDayOff(@RequestParam("date") String day,
							   @RequestParam("reason") String reason,
							   RedirectAttributes RA, HttpSession session) {
		WorkerVO vo = (WorkerVO)session.getAttribute("sessionVO");
		
		int result = workerService.chooseDayOff(vo,day,reason);
		if(result == 1) {
			RA.addFlashAttribute("msg", "휴일 등록이 정상적으로 완료됐습니다");
			return "redirect:popdown";
		} else {
			RA.addFlashAttribute("msg", "이미 출근 하신거같은데..");	
			return "redirect:popdown";
		}
		
	}
	
	@RequestMapping("/logout")
	public String logout(RedirectAttributes RA, HttpSession session) {
		
		session.invalidate();
		
		RA.addFlashAttribute("msg", "로그아웃 완료 됐습니다");		
		
		return "redirect:/worker/login";
	}
	
	@RequestMapping("/viewMonthTime")	
	public String workerHour_view(@RequestParam("year") String year,
								  @RequestParam("month") String month ,
								  HttpSession session,
								  Model model){
		WorkerVO workerVO = (WorkerVO)session.getAttribute("sessionVO");
		List<OfficeHourVO> list = workerService.getMonthOfficeHour(year, month, workerVO);
		model.addAttribute("list", list);
		model.addAttribute("mon",month);
	
		return "officehour/viewtime";
	}
	
		
	@RequestMapping("/viewMonthMoney")	
	public String workerHour_amount(@RequestParam("year") String year,
								  @RequestParam("month") String month,
								  HttpSession session,
								  Model model){
		WorkerVO workerVO = (WorkerVO)session.getAttribute("sessionVO");		
		AmountVO vo = workerService.getMonthPay(year, month, workerVO);
		
		model.addAttribute("vo", vo);
		return "officehour/viewmoney";
	}
}
