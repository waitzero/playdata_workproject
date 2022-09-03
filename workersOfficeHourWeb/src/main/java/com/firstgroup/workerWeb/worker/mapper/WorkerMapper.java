package com.firstgroup.workerWeb.worker.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.firstgroup.workerWeb.command.AmountVO;
import com.firstgroup.workerWeb.command.OfficeHourVO;
import com.firstgroup.workerWeb.command.WorkerVO;

public interface WorkerMapper {

	/**
	 * 회원가입 메소드, 파라미터 workerVO안의 workerId,workerPassword, name값 필수 (SELECT)
	 * @param workerVO User에 대한 정보인 workerId,workerPassword, name, career, gender를 가지고 있음
	 * @return 성공 실패여부를 반환. 성공 == 1, 실패 == 0
	 */
	int signUp(WorkerVO workerVO);
	
	/**
	 * 로그인 메소드, 파라미터 workerVO안에 workerId,workerPassword값 필수 (SELECT)
	 * @param workerVO 로그인창에서 입력한 값 workerId,workerPassword를 가지고 있음
	 * @return 파라미터 workerVO안에 담긴 workerId와 workerPassword가 DB와 일치하는 값이 있으면 결과를 WorkerVO타입으로 값 전부를 리턴
	 */
	WorkerVO login(WorkerVO workerVO);
	
	/**
	 * 아이디 중복 확인 메소드, workerId값 필수
	 * @param workerId DB에 있는 worker_id컬럼에 workerId값과 중복이 있는지 체크하기 위한 문자열
	 * @return 성공 실패여부를 반환. 중복 값이 있으면 0이외의 값, 중복 값이 없을 경우 0
	 */
	int checkId(String worker_id);
	
	/**
	 * 출근 값을 시간으로 남기는 메소드, workerNumber값을 가지고 있는 workerVO값 필수
	 * @param workerVO 어떤 User의 값으로 남길건지를 위해 이용
	 * @return 성공 실패여부를 반환. 성공 == 1, 실패 == 0
	 */	
	int workStart(WorkerVO workerVO);
	
	/**
	 * 퇴근 값을 시간으로 남기는 메소드, workerNumber값 필수, 메소드 실행 당시 시간과 날짜인 today값 필수
	 * @param workerNumber 어떤 User의 값으로 남길건지를 위해 이용
	 * @param today 넣고자 하는 날짜와 시간 값
	 * @return 성공 실패여부를 반환. 성공 == 1, 실패 == 0
	 */
	int workEnd(@Param("workerNumber") String workerNumber,@Param("today") String today);
	
	/**
	 * 이미 당일 출근 값이 있는지 확인하는 메소드, workerNumber값 필수, 메소드 실행 당시 시간과 날짜인 today값 필수
	 * @param workerNumber 어떤 User의 값을 찾을건지 정해주기 위해 이용
	 * @param today 넣고자 하는 날짜와 시간 값
	 * @return 값이 있는지 여부를 확인 및 결과를 반환. 값이 존재 == 1, 값이 없음 == 0
	 */
	int checkStart(@Param("workerNumber") String workerNumber,@Param("today") String today);
	
	/**
	 * 당일 출근 값을 가진 데이터가 있는지 확인하는 메소드, workerNumber값 필수, 메소드 실행 당시 시간과 날짜인 today값 필수
	 * @param workerNumber 어떤 User의 값을 찾을건지 정해주기 위해 이용
	 * @param today 넣고자 하는 날짜와 시간 값
	 * @return 값이 있는지 여부를 확인 및 결과를 반환. 값이 존재 == 1, 값이 없음 == 0
	 */
	int checkEnd(@Param("workerNumber") String workerNumber,@Param("today") String today);
	
	/**
	 * 당일 출근 건에 퇴근 값이 있는지 확인하는 메소드, workerNumber값 필수, 메소드 실행 당시 시간과 날짜인 today값 필수
	 * @param workerNumber 어떤 User의 값을 찾을건지 정해주기 위해 이용
	 * @param today 넣고자 하는 날짜와 시간 값
	 * @return 값이 있는지 여부를 확인 및 결과를 반환. 값이 존재 == 1, 값이 없음 == 0
	 */
	int realCheckEnd(@Param("workerNumber") String workerNumber,@Param("today") String today);
	
	/**
	 * 휴일 선택을 위한 메소드, workerNumber값 필수, day 값 필수
	 * @param workerNumber 어떤 User의 값으로 남길건지를 위해 이용
	 * @param day 넣고자 하는 날짜 값
	 * @param reason 휴일로 지정하고자 하는 이유 
	 * @return 성공 실패여부를 반환. 성공 == 1, 실패 == 0
	 */
	int chooseDayOff(@Param("workerNumber") String workerNumber,@Param("day") String day,@Param("reason") String reason);
	
	/**
	 * 당일 출근건에 당일 퇴근 값까지 가진 데이터의 퇴근 데이터를 업데이트하는 메소드, workerNumber값 필수, today값 필수
	 * @param workerNumber 어떤 User의 값으로 남길건지를 위해 이용
	 * @param today 넣고자 하는 날짜와 시간 값
	 * @return 성공 실패여부를 반환. 성공 == 1, 실패 == 0
	 */
	int updateEnd(@Param("workerNumber") String workerNumber,@Param("today") String today);
	
	/**
	 * 한달 단위 출퇴근 기록 값을 반환하는 메소드, year와 month값 필수, workerNumber 필수
	 * @param year 조회하고자 하는 년도
	 * @param month 조회하고자 하는 월
	 * @param workerNumber 조회하고자 하는 User번호
	 * @return 선택한 해당 월의 출퇴근 기록들을 List타입의 배열에 담아 값으로 반환
	 */
	List<OfficeHourVO> getMonthOfficeHour(@Param("year") String year,@Param("month")String month,@Param("workerNumber") String workerNumber);
	
	/**
	 * 한달 단위 급여 값을 반환하는 메소드, year와 month값 필수, workerNumber 필수
	 * @param year 조회하고자 하는 년도
	 * @param month 조회하고자 하는 월
	 * @param workerNumber 조회하고자 하는 User번호
	 * @return 선택한 해당 월의 월급을 계산하여 AmountVO값으로 반환
	 */
	AmountVO getMonthPay(@Param("year") String year,@Param("month") String month,@Param("workerNumber") String workerNumber);
}
