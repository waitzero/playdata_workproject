package com.firstgroup.workerWeb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.firstgroup.workerWeb.command.WorkerVO;
import com.firstgroup.workerWeb.worker.service.WorkerService;

@Controller
@RequestMapping("/worker") // 들어갈 주소 (파일 이름)
public class WorkerController {

	@Autowired
	@Qualifier("workerService")
	WorkerService workerService;
	
	@RequestMapping("/signup")
	public String signup() {
		return "worker/signup";
	}

	@RequestMapping("/login")
	public String login() {
		return "worker/login";
	}

	/**
	 * 회원가입하는 메소드 workerVO안에 workerId, workerPassword값과 파라미터로 받는 passwordCheck필수
	 * @param passwordCheck 입력한 passWord값과 passwordCheck값이 같아야 signUp이 이뤄짐
	 * @param workerVO Form으로 보낸 값들을 받기위해 사용
	 * @param RA alert로 브라우저에 띄울 메세지 값을 전달
	 * @return 회원가입 성공시 로그인 페이지 실패시 회원가입 페이지
	 */
	@RequestMapping("/workerSignUp") // 회원 가입 후 form 값과 함께 받을 주소
	public String signUp(@RequestParam("passwordCheck") String passwordCheck, WorkerVO workerVO,
			RedirectAttributes RA) {

		if (workerService.checkId(workerVO.getWorkerId()) != 0) {
			RA.addFlashAttribute("msg", "이미 존재하는 아이디 입니다");
			return "redirect:signup"; // 로그인 페이지
		} else if (!workerVO.getWorkerPassword().equals(passwordCheck)) {
			RA.addFlashAttribute("msg", "비밀번호를 확인하세요");
			return "redirect:signup"; // msg와 함께 회원가입 페이지로 전송
		} else {
			int result = workerService.signUp(workerVO);
			if (result == 1) {

				RA.addFlashAttribute("msg", "회원 가입을 축하드립니다");
				return "redirect:login"; // msg와 함께 로그인 페이지로 전송
			} else {

				RA.addFlashAttribute("msg", "회원 가입에 실패했습니다");
				return "redirect:signup"; // msg와 함께 회원가입 페이지로 전송
			}
		}

	}

	/**
	 * 로그인 메소드, workerVO안에 workerId, workerPassword값과 session에 있는 VO값 필수
	 * @param workerVO Form으로 보낸 값들을 받기위해 사용
	 * @param RA alert로 브라우저에 띄울 메세지 값을 전달
	 * @param session 로그인 성공시 session에 VO 값을 남김
	 * @return 성공시 홈페이지 실패시 로그인 페이지
	 */
	@RequestMapping("/workerLoginForm")
	public String workerLogin(WorkerVO workerVO, RedirectAttributes RA, HttpSession session) {

		WorkerVO vo = workerService.login(workerVO);
		if (vo != null) {
			session.setMaxInactiveInterval(60000);
			session.setAttribute("sessionVO", vo);
			RA.addFlashAttribute("msg", "로그인 성공");
			return "redirect:/officehour/homepage"; // 로그인 성공 후 페이지
		} else {
			RA.addFlashAttribute("msg", "아이디 혹은 비밀번호가 틀렸습니다");
			return "redirect:login";
		}

	}

}
