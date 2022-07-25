package com.company.mvc.board;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class ReplyVO {
	private String rno;
	private String bno;
	private String reply;
	//@JsonAlias(value="writer")
	private String replyer;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date replydate;
	@JsonIgnore
	private Date updatedate;
}
