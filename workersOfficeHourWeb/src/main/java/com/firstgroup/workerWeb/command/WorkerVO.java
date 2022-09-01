package com.firstgroup.workerWeb.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkerVO {

	int worker_number;
	String worker_id;
	String worker_password;
    String name;
    int career;
    String gender;
    
}
