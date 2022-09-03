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
public class WorkerVO {

	private int workerNumber;
	private String workerId;
	private String workerPassword;
	private String name;
	private int career;
	private String gender;
    
}
