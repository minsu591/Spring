package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor //기본 생성자 생성
@AllArgsConstructor //전체 항목 초기화
@Data
public class Customer {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Long id;
	
	@Column(length=20, nullable =false)
	private String name;
	
	@Column(length=20, nullable=false, unique = true)
	private String phone;
}
