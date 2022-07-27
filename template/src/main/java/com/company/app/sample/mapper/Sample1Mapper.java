package com.company.app.sample.mapper;

import org.apache.ibatis.annotations.Insert;

public interface Sample1Mapper {
	//xml파일 없이도 쿼리 사용 가능
	@Insert("insert into tbl_sample1 (col1) values(#{data})")
	public int insert(String data);
}
