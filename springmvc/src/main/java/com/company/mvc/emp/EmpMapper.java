package com.company.mvc.emp;

import java.util.List;
import java.util.Map;

public interface EmpMapper {
	public EmpVO getEmp(EmpVO vo);
	public List<EmpVO> getEmpList(EmpVO vo);
	public List<EmpVO> getEmpByDept(String[] dept);
	public void insert(EmpVO vo);
	
	public List<EmpVO> getEmpReqList(EmpReqVO vo);
	public void update(EmpVO vo);
	public void delete(EmpVO vo);
}
