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

	/**
	 * viewtime페이지로 이동할때 session에 VO값이 있는지 확인하는 메소드, 
	 * session에 VO 값이 없으면 로그인 페이지로 이동함 페이지 접속시 session값 필수를 위해 사용 
	 * @param session
	 * @param RA alert로 브라우저에 띄울 메세지 값을 전달
	 * @return session에 VO값이 있으면 viewtime페이지로 이동, 값이 없으면 login페이지로 이동
	 */
	@RequestMapping("/viewtime")
	public String viewtime(RedirectAttributes RA,HttpSession session) {
		if (session.getAttribute("sessionVO") != null) {
			return "officehour/viewtime";
		} else {
			RA.addFlashAttribute("msg", "로그인이 필요합니다");
			return "redirect:/worker/login";
		}
	}

	/**
	 * viewmoney페이지로 이동할때 session에 VO값이 있는지 확인하는 메소드, 
	 * session에 VO 값이 없으면 로그인 페이지로 이동함 페이지 접속시 session값 필수를 위해 사용
	 * @param session
	 * @param RA alert로 브라우저에 띄울 메세지 값을 전달
	 * @return session에 VO값이 있으면 viewmoney페이지로 이동, 값이 없으면 login페이지로 이동
	 */
	@RequestMapping("/viewmoney")
	public String viewmoney(RedirectAttributes RA, HttpSession session) {
		if (session.getAttribute("sessionVO") != null) {
			return "officehour/viewmoney";
		} else {
			RA.addFlashAttribute("msg", "로그인이 필요합니다");
			return "redirect:/worker/login";
		}
	}

	@RequestMapping("/sick")
	public String sick() {
		return "officehour/sick";
	}

	@RequestMapping("/vacation")
	public String vacation() {
		return "officehour/vacation";
	}

	@RequestMapping("/popdown")
	public void popDown() {
	}

	/**
	 * homepage로 이동할때 session에 VO값이 있는지 확인하는 메소드, session에 VO 값이 없으면 로그인 페이지로 이동함 홈페이지 접속시 session값 필수를 위해 사용 
	 * @param session
	 * @param RA alert로 브라우저에 띄울 메세지 값을 전달
	 * @return session에 VO값이 있으면 homepage로 이동, 값이 없으면 login페이지로 이동
	 */
	@RequestMapping("/homepage")
	public String homepage(RedirectAttributes RA, HttpSession session) {
		if (session.getAttribute("sessionVO") != null) {
			return "officehour/homepage";
		} else {
			RA.addFlashAttribute("msg", "로그인이 필요합니다");
			return "redirect:/worker/login";
		}
	}

	/**
	 * 출근 버튼을 눌렀을 때 DB로 버튼 누른 시간 전송 (INSERT), session값 필수
	 * @param RA alert로 브라우저에 띄울 메세지 값을 전달
	 * @param session 로그인 돼있는 VO값을 가져오기 위해 사용
	 * @return
	 */
	@RequestMapping("/workStart")
	public String workStart(RedirectAttributes RA, HttpSession session) {

		WorkerVO vo = (WorkerVO) session.getAttribute("sessionVO");
		int result = workerService.workStart(vo);
		if (result == 1) {
			RA.addFlashAttribute("msg", "출근 등록 완료했습니다 오늘 하루 힘내세요!");
			return "redirect:homepage";
		} else {
			RA.addFlashAttribute("msg", "출근 등록에 실패했습니다 관리자에게 문의해주세요");
			return "redirect:homepage";
		}
	}

	/**
	 * 퇴근 버튼을 눌렀을 때 DB로 버튼 누른 시간 전송 (UPDATE), session값 필수
	 * @param RA alert로 브라우저에 띄울 메세지 값을 전달
	 * @param session 로그인 돼있는 VO값을 가져오기 위해 사용
	 * @return
	 */
	@RequestMapping("/workEnd")
	public String workEnd(RedirectAttributes RA, HttpSession session) {

		WorkerVO vo = (WorkerVO) session.getAttribute("sessionVO");
		int result = workerService.workEnd(vo);
		if (result == 1) {
			RA.addFlashAttribute("msg", "퇴근 완료했습니다 수고 많으셨습니다!");
			return "redirect:homepage";
		} else if (result == 2) {
			RA.addFlashAttribute("msg", "퇴근 정보를 업데이트 했습니다");
			return "redirect:homepage";
		} else {
			RA.addFlashAttribute("msg", "퇴근 등록에 실패했습니다 관리자에게 문의해주세요");
			return "redirect:homepage";
		}
	}

	/**
	 * 휴일을 정할 수 있는 메소드, Form으로 "yyyy-MM-dd"형식의 날짜를 date라는 이름으로 전달할 것. 휴일 지정 이유인 reason 값 필수, session값 필수
	 * @param day 휴일로 지정할 날짜
	 * @param reason 휴일 사유
	 * @param RA alert로 브라우저에 띄울 메세지 값을 전달
	 * @param session 로그인 돼있는 VO값을 가져오기 위해 사용
	 * @return 팝업창 닫을 수 있는 페이지
	 */
	@RequestMapping("/chooseDayOff")
	public String chooseDayOff(@RequestParam("date") String day, @RequestParam("reason") String reason,
			RedirectAttributes RA, HttpSession session) {
		WorkerVO vo = (WorkerVO) session.getAttribute("sessionVO");

		int result = workerService.chooseDayOff(vo, day, reason);
		if (result == 1) {
			RA.addFlashAttribute("msg", "휴일 등록이 정상적으로 완료됐습니다");
			return "redirect:popdown";
		} else {
			RA.addFlashAttribute("msg", "휴일 등록에 실패했습니다. 관리자에게 문의해주세요");
			return "redirect:popdown";
		}

	}

	/**
	 * 로그아웃, session값 필수
	 * @param RA alert로 브라우저에 띄울 메세지 값을 전달
	 * @param session 로그인 돼있는 VO값을 가져오기 위해 사용
	 * @return 로그인 페이지로 보냄
	 */
	@RequestMapping("/logout")
	public String logout(RedirectAttributes RA, HttpSession session) {

		session.invalidate();
		RA.addFlashAttribute("msg", "로그아웃 완료 됐습니다");
		return "redirect:/worker/login";
	}

	/**
	 * 한달 단위 출퇴근 기록 값을 가져와 페이지에 전달하는 메소드,year와 month값 필수, session값 필수
	 * @param year 조회하고자 하는 년도
	 * @param month 조회하고자 하는 달
	 * @param session 로그인 돼있는 VO값을 가져오기 위해 사용
	 * @param model 결과값 페이지에 전달
	 * @return 출퇴근 기록 목록 페이지
	 */
	@RequestMapping("/viewMonthTime")
	public String workerHourView(@RequestParam("year") String year, @RequestParam("month") String month,
			HttpSession session, Model model) {
		WorkerVO workerVO = (WorkerVO) session.getAttribute("sessionVO");
		List<OfficeHourVO> list = workerService.getMonthOfficeHour(year, month, workerVO);
		model.addAttribute("list", list);
		model.addAttribute("mon", month);

		return "officehour/viewtime";
	}

	/**
	 * 한달 단위 급여 값을 계산해 페이지에 전달하는 메소드,year와 month값 필수, session값 필수
	 * @param year 조회하고자 하는 년도
	 * @param month 조회하고자 하는 달
	 * @param session 로그인 돼있는 VO값을 가져오기 위해 사용
	 * @param model 결과값 페이지에 전달
	 * @return 월급 조회 페이지
	 */
	@RequestMapping("/viewMonthMoney")
	public String workerHourAmount(@RequestParam("year") String year, @RequestParam("month") String month,
			HttpSession session, Model model) {
		WorkerVO workerVO = (WorkerVO) session.getAttribute("sessionVO");
		AmountVO vo = workerService.getMonthPay(year, month, workerVO);
		model.addAttribute("vo", vo);
		model.addAttribute("mon", month);

		return "officehour/viewmoney";
	}
}
