package com.company.app.emp.mapper;

import java.util.List;

import com.company.app.emp.service.DeptVO;
import com.company.app.emp.service.EmpReqVO;
import com.company.app.emp.service.EmpVO;

public interface EmpMapper {
	public EmpVO getEmp(EmpVO vo);
	public List<EmpVO> getEmpList(EmpVO vo);
	public List<EmpVO> getEmpByDept(String[] dept);
	public int insert(EmpVO vo);
	
	public List<EmpVO> getEmpReqList(EmpReqVO vo);
	public int update(EmpVO vo);
	public int delete(EmpVO vo);
	
	public List<EmpVO> getEmpDept();
	public List<DeptVO> getDeptEmp();
}
