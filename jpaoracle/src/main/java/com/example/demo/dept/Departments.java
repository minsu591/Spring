package com.example.demo.dept;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Departments {
	@Id
	@Column(name="department_id")
	private Integer departmentId;
	private String department_name;
	private Integer manager_id;
	private Integer location_id;
}
