package com.jshbank.demo.test.requestTest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
//@NoArgsConstructor
@Setter
@Getter
public class Book_No_Setter {
    private String bookTitle;
    private int numberOfPages;
    private String writer;
}