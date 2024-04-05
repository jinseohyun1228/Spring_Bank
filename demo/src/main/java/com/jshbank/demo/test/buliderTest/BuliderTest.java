package com.jshbank.demo.test.buliderTest;

public class BuliderTest {
  public static void main(String[] args) {
//    BuliderClass buliderClass01 = new BuliderClass();
    BuliderClass buliderClass02 = new BuliderClass(5,"안녕");
    BuliderClass buliderClass03 = BuliderClass.builder().build();



    BuliderConstruct buliderConstruct01 = BuliderConstruct.builder().id(4).name("안녕").build();


  }
}
