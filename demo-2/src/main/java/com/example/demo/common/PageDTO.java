package com.example.demo.common;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {

  private int startPage;
  private int endPage;
  //last 페이지면 다음 버튼이 나오지 않게 boolean 타입으로 조절
  private boolean prev, next;

  //레코드 건수
  private int total;
  private Criteria cri;
  
  
  public PageDTO(Criteria cri, int total) {

    this.cri = cri;
    this.total = total;

    this.endPage = (int) (Math.ceil(cri.getPageNum() / 10.0)) * 10;

    this.startPage = this.endPage - 9;

    int realEnd = (int) (Math.ceil((total * 1.0) / cri.getAmount()));

    if (realEnd <= this.endPage) {
      this.endPage = realEnd;
    }

    this.prev = this.startPage > 1;

    this.next = this.endPage < realEnd;
  }
  
}

