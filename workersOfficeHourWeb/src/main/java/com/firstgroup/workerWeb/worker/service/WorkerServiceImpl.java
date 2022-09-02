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
		
		if(workerMapper.checkStart(Integer.toString(workerVO.getWorker_number()), today) == 0) {
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
        
        if(workerMapper.checkEnd(Integer.toString(workerVO.getWorker_number()), today) != 0 &&
        	workerMapper.realCheckEnd(Integer.toString(workerVO.getWorker_number()), today) == 0) {
        	workerMapper.workEnd(Integer.toString(workerVO.getWorker_number()), today);
        	return 1;
        } else if (workerMapper.checkEnd(Integer.toString(workerVO.getWorker_number()), today) != 0 &&
        		workerMapper.realCheckEnd(Integer.toString(workerVO.getWorker_number()), today) != 0){
        	workerMapper.updateEnd(Integer.toString(workerVO.getWorker_number()), today);
        	return 2;
        } else {
        	return 0;
        }
		
	}

	@Override
	public int chooseDayOff(WorkerVO vo, String day, String reason) {
		
		if(workerMapper.checkStart(Integer.toString(vo.getWorker_number()), day) == 0) {
			return workerMapper.chooseDayOff(Integer.toString(vo.getWorker_number()),day,reason);
		} else {
			return 0;
		}
	}
		
	@Override
	public List<OfficeHourVO> getMonthOfficeHour(String year, String month, WorkerVO workerVO) {
		return workerMapper.getMonthOfficeHour(year,month,Integer.toString(workerVO.getWorker_number()));
	}
	


	@Override
	public AmountVO getMonthPay(String year, String month, WorkerVO workerVO) {
		
		List<OfficeHourVO> list = workerMapper.getMonthOfficeHour(year, month, Integer.toString(workerVO.getWorker_number()));
		
		int totalWorkTime = 0;
		int pay1 = 10000;
		int pay2 = 15000;
		int pay3 = 20000;
		
		int monthPay = 0;
		
		for(OfficeHourVO vo : list) {
			
			int workTime = vo.getWork_end().getHours() - vo.getWork_start().getHours();
			totalWorkTime += workTime;
		}
		if (workerVO.getCareer() > 10) {
			monthPay += totalWorkTime * pay3;
		} else if (workerVO.getCareer() < 4) {
			monthPay += totalWorkTime * pay1;
		} else {
			monthPay += totalWorkTime * pay2;
		}
		
		AmountVO vo = new AmountVO();
		vo.setTotalAmount(monthPay);
		vo.setTotalWorkTime(totalWorkTime);
		vo.setMonth(month);
		
		return vo;
	}
}
