package com.example.demo.emp;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeesRepository extends JpaRepository<Employees, Integer>{
	public List<Employees> findByEmail(String email);
	
	//부서별로 검색 first_name 정렬
//	public List<Employees> findByDepartmentIdOrderByFirstNameAsc(Integer department_id);
//	
//	@Query("select e from Employees e where department_id = ?1 order by e.firstName")
//	public List<Employees> findByDepartmentId(Integer department_id);
}
