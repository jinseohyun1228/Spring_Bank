package com.jshbank.demo.test.requestTest;

import com.jshbank.demo.test.requestTest.Book;
import com.jshbank.demo.test.requestTest.Book_No_Setter;
import org.springframework.web.bind.annotation.*;

@RestController
public class RequestTest {

  @GetMapping("/request/requestparam")
  public String requestParamTest(@RequestParam(value = "name")String name,@RequestParam(value = "age")int age,@RequestParam(required = false) String nickname) {
    if (nickname == null){
      return name+"님! 당신은 " + age + "살이군요?";
    }else {
      return name+"님! " +nickname+ "이란 별명이 귀여워요! 당신은 " + age + "살이군요?";
    }
  }


  @PostMapping("/request/modelAttribute")
  public Book modelAttributeTest(@ModelAttribute Book user){
    System.out.println("user = " + user);
    return user;
  }

  @PostMapping("/request/RequestBody")
  public Book_No_Setter requestBodyTest(@RequestBody Book_No_Setter bookNoSetter) {
    System.out.println("bookNoSetter = " + bookNoSetter);
    return bookNoSetter;
  }
}
