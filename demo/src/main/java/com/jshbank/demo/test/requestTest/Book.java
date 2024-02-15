package com.jshbank.demo.test.requestTest;

import jakarta.persistence.Entity;
import lombok.*;

@NoArgsConstructor
//@AllArgsConstructor
@Setter
@Getter
public class Book {
  private String bookTitle;
  private int numberOfPages;
  private String writer;

  @Override
  public String toString() {
    String str = "";
    str += "책 제목: " + bookTitle + "\n";
    str += "총 쪽수: " + numberOfPages + "\n";
    str += "작가: " + writer;
    return str;
  }


}
