package com.example.demo.emp.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmpVO {
	private String employeeId;
	private String firstName;
	private String lastName;
	private String email;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date hireDate;
	private String jobId;
	private String salary;
	private String departmentId;
	private Double commissionPct;
	
}
