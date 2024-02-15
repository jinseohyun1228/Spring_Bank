package com.jshbank.demo.repository;

import com.jshbank.demo.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@SpringBootTest
class UserRepositoryTest {


  @Autowired
  private UserRepository userRepository;

  @Test
  public void find(){
    User user = userRepository.findById(2).orElseThrow(()->{
      return new IllegalArgumentException("ㅌ");
    });

    System.out.println("user = " + user);

  }

}