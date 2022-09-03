package com.firstgroup.workerWeb.worker.service;

import java.util.List;

import com.firstgroup.workerWeb.command.AmountVO;
import com.firstgroup.workerWeb.command.OfficeHourVO;
import com.firstgroup.workerWeb.command.WorkerVO;

public interface WorkerService {

	/**
	 * 회원가입 메소드, 파라미터 workerVO안의 workerId,workerPassword, name값 필수
	 * @param workerVO User에 대한 정보인 workerId,workerPassword, name, career, gender를 가지고 있음
	 * @return 성공 실패여부를 반환. 성공 == 1, 실패 == 0
	 */
	int signUp(WorkerVO workerVO);
	
	/**
	 * 로그인 메소드, 파라미터 workerVO안에 workerId,workerPassword값 필수
	 * @param workerVO 로그인창에서 입력한 값 workerId,workerPassword를 가지고 있음
	 * @return 파라미터 workerVO안에 담긴 workerId와 workerPassword가 DB와 일치하면 결과를 WorkerVO타입으로 값 전부를 리턴
	 */
	WorkerVO login(WorkerVO workerVO);
	
	/**
	 * 아이디 중복 확인 메소드, workerId값 필수
	 * @param workerId DB에 있는 worker_id컬럼에 workerId값과 중복이 있는지 체크하기 위한 문자열
	 * @return 성공 실패여부를 반환. 중복 값이 있으면 0이외의 값, 중복 값이 없을 경우 0
	 */
	int checkId(String workerId);
	
	/**
	 * 출근 값을 시간으로 남기는 메소드, workerNumber값을 가지고 있는 workerVO값 필수
	 * @param workerVO 어떤 User의 값으로 남길건지를 위해 이용
	 * @return 성공 실패여부를 반환. 성공 == 1, 실패 == 0
	 */
	int workStart(WorkerVO workerVO);
	
	/**
	 * 퇴근 값을 시간으로 남기는 메소드, workerNumber값을 가지고 있는 workerVO값 필수
	 * @param workerVO 어떤 User의 값으로 남길건지를 위해 이용
	 * @return 성공 실패여부를 반환. 성공 == 1, 실패 == 0, 정보 업데이트 성공 == 2
	 */
	int workEnd(WorkerVO workerVO);
	
	/**
	 * 휴일 선택을 위한 메소드, workerNumber값을 가지고 있는 workerVO값 필수, "yyyy-MM-dd"형식으로 된 날짜 문자열 값 date값 필수, 휴일 지정 이유인 reason 값 필수
	 * @param vo 어떤 User의 값으로 남길건지를 위해 이용
	 * @param day 날짜 지정을 위해 사용
	 * @param reason 휴일 지정 이유 값을 위해 사용
	 * @return 성공 실패여부를 반환. 성공 == 1, 실패 == 0
	 */
	int chooseDayOff(WorkerVO vo, String day, String reason);
	
	/**
	 * 한달 단위 출퇴근 기록 값을 가져와 페이지에 전달하는 메소드, year와 month값 필수, workerNumber값을 가지고 있는 workerVO값 필수
	 * @param year 년도 지정을 위해 사용
	 * @param month 월 지정을 위해 사용
	 * @param workerVO 어떤 User의 값으로 남길건지를 위해 이용
	 * @return 선택한 해당 월의 출퇴근 기록들을 List타입의 배열에 담아 값으로 반환
	 */
	public List<OfficeHourVO> getMonthOfficeHour(String year, String month, WorkerVO workerVO);
	
	/**
	 * 한달 단위 급여 값을 계산해 페이지에 전달하는 메소드, year와 month값 필수, workerNumber값을 가지고 있는 workerVO값 필수
	 * @param year 년도 지정을 위해 사용
	 * @param month 월 지정을 위해 사용
	 * @param workerVO 어떤 User의 값으로 남길건지를 위해 이용
	 * @return 선택한 해당 월의 월급을 계산하여 AmountVO값으로 반환
	 */
	public AmountVO getMonthPay(String year, String month, WorkerVO workerVO);
}
