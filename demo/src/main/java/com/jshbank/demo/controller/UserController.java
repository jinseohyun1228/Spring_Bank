package com.jshbank.demo.controller;

import com.jshbank.demo.entity.User;
import com.jshbank.demo.repository.UserRepository;
import io.micrometer.observation.Observation;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.function.Supplier;

@RestController
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @PostMapping("/user/join")
  public User join(User user){
    user.setAccountNumber(user.getPhoneNumber()+"C");
    System.out.println(" 흠.. " + user.getAccountNumber());
    userRepository.save(user);

    return user;
  }

  @PostMapping("/balance")
  public String postnull(@RequestBody Map<String, Object> data){
    int id = (int) data.get("id");
    String phoneNumber = (String) data.get("phoneNumber");

    User user = userRepository.findById(id).orElseThrow(()->{
      return new IllegalArgumentException("해당 사용자는 없습니다.");
    });

    return user.getAccountNumber();
  }


  @PostMapping("/user/balance")
  private String checkBalance(@RequestBody Map<String, Object> payload) {
    int id = (int) payload.get("id");
    String password = (String) payload.get("password");

    User user = userRepository.findById(id).orElseThrow(()->{
      return new IllegalArgumentException("해당 사용자는 없습니다.");
    });

    if (user.getPassword().equals(password)) {
     return user.getUsername() + "님의 잔액은 " + user.getBalance() + "입니다.";
   } else {
     throw new IllegalArgumentException("해당 비밀번호가 틀렸습니다..");
   }
  }

  @Transactional
  @PutMapping("/user/deposit")
  public User deposit(@RequestBody Map<String, Object> data){
    int id = (int) data.get("id");
    long amountOfMoney = (int) data.get("amountOfMoney");

    User user = userRepository.findById(id).orElseThrow(()->{
      return new IllegalArgumentException("해당 사용자는 없습니다.");
    });

    long balanceBeforeDeposit =  user.getBalance();
    long temp = balanceBeforeDeposit + amountOfMoney;

    System.out.println("temp = " + temp);
    user.setBalance(temp);

    long balanceAfterDeposit = user.getBalance();


    return user;
  }

  @Transactional
  @PutMapping("/user/withdraw")
  public User withdraw(@RequestBody Map<String, Object> data){
    int id = (int) data.get("id");
    long amountOfMoney = (int) data.get("amountOfMoney");

    User user = userRepository.findById(id).orElseThrow(()->{
      return new IllegalArgumentException("해당 사용자는 없습니다.");
    });

    long balanceBeforeDeposit =  user.getBalance();
    long temp = balanceBeforeDeposit - amountOfMoney;

    System.out.println("temp = " + temp);
    user.setBalance(temp);

    long balanceAfterDeposit = user.getBalance();


    return user;
  }





}

