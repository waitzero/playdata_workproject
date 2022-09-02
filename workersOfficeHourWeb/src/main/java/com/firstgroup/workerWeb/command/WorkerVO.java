package com.firstgroup.workerWeb.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkerVO {

	private int worker_number;
	private String worker_id;
	private String worker_password;
	private String name;
	private int career;
	private String gender;
    
}
