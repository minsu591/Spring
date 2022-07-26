package com.company.app.emp.service;

import java.util.List;

public interface EmpService {
	public EmpVO getEmp(EmpVO vo);
	public List<EmpVO> getEmpList(EmpVO vo);
	public List<EmpVO> getEmpByDept(String[] dept);
	public int insert(EmpVO vo);
	
	public List<EmpVO> getEmpReqList(EmpReqVO vo);
	public int update(EmpVO vo);
	public int delete(EmpVO vo);
}
