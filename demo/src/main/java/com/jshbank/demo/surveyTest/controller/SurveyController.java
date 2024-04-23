package com.jshbank.demo.surveyTest.controller;

import com.jshbank.demo.surveyTest.dto.SurveyDto;
import com.jshbank.demo.surveyTest.entity.Question;
import com.jshbank.demo.surveyTest.entity.Survey;
import com.jshbank.demo.surveyTest.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SurveyController {

  @Autowired
  private SurveyService surveyService;

  @PostMapping("/survey/test")
  public String surveyTest(@RequestBody SurveyDto surveyDto) {
    Survey survey = new Survey();
    survey.setTitle(surveyDto.getSurveyTitle());

    List<Question> questions = new ArrayList<>();
    surveyDto.getQuestions().forEach(questionDto -> {
      Question question = new Question();
      question.setText(questionDto.getQuestionText());
      questions.add(question);
    });

    surveyService.createSurvey(survey, questions);

    return "완료?!";
  }
}
