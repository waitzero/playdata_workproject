package com.firstgroup.workerWeb.command;


import java.time.LocalDateTime;

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
public class OfficeHourVO {

	private int officeHourId;
	private int workerNumber;
	private LocalDateTime workStart;
	private LocalDateTime workEnd; 
	private String offday;
	
}
