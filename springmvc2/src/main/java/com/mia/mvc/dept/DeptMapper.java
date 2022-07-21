package com.mia.mvc.dept;

import java.util.List;

public interface DeptMapper {
	public List<DeptVO> getDeptList();
	public DeptVO getDept(DeptVO dept);
}
