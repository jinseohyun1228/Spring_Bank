package com.jshbank.demo.surveyTest.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Question {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String text;

  @ManyToOne
  @JoinColumn(name = "survey_id")
  private Survey survey;


  // 기본 생성자, 게터, 세터 생략
}
