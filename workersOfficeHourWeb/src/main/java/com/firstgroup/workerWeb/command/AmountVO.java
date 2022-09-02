package com.firstgroup.workerWeb.command;

import lombok.Data;

@Data
public class AmountVO {
	
	private int totalAmount;
	private int totalWorkTime;
	private String month;
	private int overPay;
	
}
