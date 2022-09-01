package com.firstgroup.workerWeb.worker.service;

import java.time.LocalDate;

import com.firstgroup.workerWeb.command.WorkerVO;

public interface WorkerService {

	int signUp(WorkerVO workerVO);
	WorkerVO login(WorkerVO workerVO);
	int checkId(String worker_id);
	int workStart(WorkerVO workerVO);
	int workEnd(WorkerVO workerVO);

}
