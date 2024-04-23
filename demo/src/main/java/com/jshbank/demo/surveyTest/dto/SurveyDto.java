package com.jshbank.demo.surveyTest.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class SurveyDto {
  private String surveyTitle;
  private List<QuestionDTO> questions;
}
/*
{
  "surveyTitle": "설문조사A",
  "questions": [
    {"questionText": "문항1"},
    {"questionText": "문항2"},
    {"questionText": "문항3"}
  ]
}

 */