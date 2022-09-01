package com.firstgroup.workerWeb.command;

import com.google.protobuf.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OfficeHourVO {

	int office_hour_id;
	int worker_number;
    Timestamp work_start;
    Timestamp work_end; 
	
}
