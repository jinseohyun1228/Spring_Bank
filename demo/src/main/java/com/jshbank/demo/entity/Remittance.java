package com.jshbank.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder  //빌더 페턴!
@Entity
public class Remittance {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)//프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
  private int id;

  @ManyToOne
  @JoinColumn(name = "senderID")
  private User sender;

  @ManyToOne
  @JoinColumn(name = "holderID")
  private User holder;

  @Column
  private long amount;

  @CreationTimestamp
  private Timestamp timestamp;

}
