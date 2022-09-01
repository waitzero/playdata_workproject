package com.firstgroup.workerWeb.worker.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firstgroup.workerWeb.command.WorkerVO;
import com.firstgroup.workerWeb.worker.mapper.WorkerMapper;

@Service("workerService")
public class WorkerServiceImpl implements WorkerService{

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
		if(workerMapper.checkStart(workerVO) == 0) {
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
        
        if(workerMapper.checkEnd(workerVO) == 0) {
        	return workerMapper.workEnd(workerVO);
        } else {
        	return 0;
        }
		
	}
		
	
}
