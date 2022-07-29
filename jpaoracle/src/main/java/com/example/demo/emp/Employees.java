package com.example.demo.emp;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.example.demo.dept.Departments;

import lombok.Data;

@Entity
@Data
public class Employees {
	@Id
	@Column(name="employee_id")
	private Integer employeeId;
	@Column(name="first_name")
	private String firstName;
	@Column(name= "last_name",length=25, nullable = false)
	private String lastName;
	@Column(length=25, unique = true, nullable = false)
	private String email;
	@Column(name="phone_number")
	private String phoneNumber;
	@Column(name = "hire_date", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date hireDate;
	@Column(name="job_id",length=10, nullable = false)
	private String jobId;
	private Double salary;
	@Column(name="commission_pct")
	private Double commissionPct;
	@Column(name="manager_id")
	private Integer managerId;
	//@Column(name="department_id")
	//private Integer departmentId;
	
	@ManyToOne
	@JoinColumn(name="department_id")
	Departments departments;
	
}
