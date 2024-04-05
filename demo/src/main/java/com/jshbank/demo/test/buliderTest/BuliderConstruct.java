package com.jshbank.demo.test.buliderTest;


import lombok.Builder;

public class BuliderConstruct {
  private int id;
  private String name;

  @Builder
  public BuliderConstruct(int id, String name) {
    this.id = id;
    this.name = name;
  }
}
