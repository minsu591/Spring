package com.company.app.emp.service;

import java.util.List;

import lombok.Data;

@Data
public class DeptVO {
	private Integer departmentId;
	private String department_name;
	private Integer manager_id;
	private Integer location_id;
	
	//해당 부서의 부서원들 리스트를 가져오기
	List<EmpVO> emp;
}
