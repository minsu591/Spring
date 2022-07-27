package com.company.app.sample.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.app.sample.mapper.Sample1Mapper;
import com.company.app.sample.mapper.Sample2Mapper;
import com.company.app.sample.service.SampleService;

@Service
public class SampleServiceImpl implements SampleService {

	@Autowired Sample1Mapper s1mapper;
	@Autowired Sample2Mapper s2mapper;
	
	@Override
	public void addDate(String data) {
		//sample2의 컬럼의 데이터 길이가 10byte.
		//아무것도 안한 상태에서는 s1은 커밋, s2는 에러날 것.
		//트랜잭션을 걸면 하나가 에러났을 때 둘 다 rollback되어야함.
		//test하는 쪽에도 Transactional 걸어주기
		s1mapper.insert(data);
		s2mapper.insert(data);
	}

}
