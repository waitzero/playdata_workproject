package com.firstgroup.workerWeb.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AmountVO {
	
	private int totalAmount;
	private int totalWorkTime;
	private String month;
	private int overPay;
	private int monthPay;
	
}
