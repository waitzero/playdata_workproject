package com.firstgroup.workerWeb.worker.service;

import java.util.List;

import com.firstgroup.workerWeb.command.AmountVO;
import com.firstgroup.workerWeb.command.OfficeHourVO;
import com.firstgroup.workerWeb.command.WorkerVO;

public interface WorkerService {

	int signUp(WorkerVO workerVO);
	WorkerVO login(WorkerVO workerVO);
	int checkId(String worker_id);
	int workStart(WorkerVO workerVO);
	int workEnd(WorkerVO workerVO);
	int chooseDayOff(WorkerVO vo, String day, String reason);
	public List<OfficeHourVO> getMonthOfficeHour(String year, String month, WorkerVO workerVO);
	public AmountVO getMonthPay(String year, String month, WorkerVO workerVO);
}
