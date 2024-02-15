package com.jshbank.demo.controller;

import com.jshbank.demo.entity.Remittance;
import com.jshbank.demo.entity.User;
import com.jshbank.demo.repository.RemittanceRepository;
import com.jshbank.demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RemittanceController {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private RemittanceRepository remittanceRepository;

  @Transactional
  @PostMapping("/sendMoney")
  public Remittance sendMoney(@RequestBody Remittance remittance){
    System.out.println("remittance = " + remittance);
    User sender = userRepository.findById(remittance.getSender().getId()).orElseThrow(()->{
      return new IllegalArgumentException("보내는 사람이 틀렸습니다.");
    });

    User horder = userRepository.findById(remittance.getHolder().getId()).orElseThrow(()->{
      return new IllegalArgumentException("받는 사람이 틀렸습니다.");
    });

    if (sender.getBalance() > remittance.getAmount()) {
      long temp = remittance.getAmount();
      long senderBalance = sender.getBalance() - temp;
      sender.setBalance(senderBalance);

      long horderBalnce = horder.getBalance() + temp;

      horder.setBalance(horderBalnce);

      remittanceRepository.save(remittance);

    }else {
      throw new IllegalArgumentException("잔액이 부족합니다.");
    }

    return remittance;

  }
}


