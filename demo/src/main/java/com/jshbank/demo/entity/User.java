package com.jshbank.demo.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User {

  @Id // 해당 필드?데이터?변수?를 기본키로 설정하는 어노테이션
  @GeneratedValue(strategy = GenerationType.IDENTITY)//프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
  private int id;  //autu_increment

  @Column(nullable = false, length = 10)
  private String username;

  @Column(nullable = false,length = 100)
  private String password;

  @Column(nullable = false,length = 11, unique = true)
  private String phoneNumber;

  @Column(nullable = false,length = 12,unique = true)
  private String accountNumber;

  @ColumnDefault("0")
  private long balance;

}

