package com.firstgroup.workerWeb.worker.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firstgroup.workerWeb.command.AmountVO;
import com.firstgroup.workerWeb.command.OfficeHourVO;
import com.firstgroup.workerWeb.command.WorkerVO;
import com.firstgroup.workerWeb.worker.mapper.WorkerMapper;

@Service("workerService")
public class WorkerServiceImpl implements WorkerService {

	@Autowired
	WorkerMapper workerMapper;

	@Override
	public int signUp(WorkerVO workerVO) {
		return workerMapper.signUp(workerVO);
	}

	@Override
	public WorkerVO login(WorkerVO workerVO) {
		return workerMapper.login(workerVO);
	}

	@Override
	public int checkId(String worker_id) {
		return workerMapper.checkId(worker_id);
	}

	@Override
	public int workStart(WorkerVO workerVO) {
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		Date now = new Date();
		String today = sdf1.format(now);

		if (workerMapper.checkStart(Integer.toString(workerVO.getWorkerNumber()), today) == 0) {
			return workerMapper.workStart(workerVO);
		} else {
			return 0;
		}
	}

	@Override
	public int workEnd(WorkerVO workerVO) {

		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		Date now = new Date();
		String today = sdf1.format(now);

		if (workerMapper.checkEnd(Integer.toString(workerVO.getWorkerNumber()), today) != 0
				&& workerMapper.realCheckEnd(Integer.toString(workerVO.getWorkerNumber()), today) == 0) {
			workerMapper.workEnd(Integer.toString(workerVO.getWorkerNumber()), today);
			return 1;
		} else if (workerMapper.checkEnd(Integer.toString(workerVO.getWorkerNumber()), today) != 0
				&& workerMapper.realCheckEnd(Integer.toString(workerVO.getWorkerNumber()), today) != 0) {
			workerMapper.updateEnd(Integer.toString(workerVO.getWorkerNumber()), today);
			return 2;
		} else {
			return 0;
		}

	}

	@Override
	public int chooseDayOff(WorkerVO vo, String day, String reason) {

		if (workerMapper.checkStart(Integer.toString(vo.getWorkerNumber()), day) == 0) {
			return workerMapper.chooseDayOff(Integer.toString(vo.getWorkerNumber()), day, reason);
		} else {
			return 0;
		}
	}

	@Override
	public List<OfficeHourVO> getMonthOfficeHour(String year, String month, WorkerVO workerVO) {
		return workerMapper.getMonthOfficeHour(year, month, Integer.toString(workerVO.getWorkerNumber()));
	}

	@Override
	public AmountVO getMonthPay(String year, String month, WorkerVO workerVO) {

		List<OfficeHourVO> list = workerMapper.getMonthOfficeHour(year, month,
				Integer.toString(workerVO.getWorkerNumber()));

		AmountVO vo = new AmountVO();

		int totalWorkTime = 0;
		int payJunior = 10000;
		int paySenior = 15000;
		int payPro = 20000;
		int realPay = 0;

		int monthPay = 0;
		int overPay = 0;

		for (OfficeHourVO item : list) {
			int workTime = item.getWorkEnd().getHour() - item.getWorkStart().getHour();
			totalWorkTime += workTime;
		}

		if (workerVO.getCareer() > 10) {
			realPay = payPro;
		} else if (workerVO.getCareer() < 4) {
			realPay = payJunior;
		} else {
			realPay = paySenior;
		}

		if (totalWorkTime <= 160) {
			monthPay = realPay * totalWorkTime;
		} else {
			monthPay = realPay * 160;
			overPay = (int) ((realPay * (totalWorkTime - 160)) * 1.5);
		}

		vo.setTotalWorkTime(totalWorkTime);
		vo.setMonth(month);
		vo.setOverPay(overPay);
		vo.setMonthPay(monthPay);
		vo.setTotalAmount(monthPay + overPay);

		return vo;
	}
}
