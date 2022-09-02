package com.firstgroup.workerWeb.command;


import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OfficeHourVO {

	private int office_hour_id;
	private int worker_number;
	private Timestamp work_start;
	private Timestamp work_end; 
	private String offday;
	
}
