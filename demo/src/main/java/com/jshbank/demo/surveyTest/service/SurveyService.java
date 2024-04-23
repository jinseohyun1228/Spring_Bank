package com.jshbank.demo.surveyTest.service;

import com.jshbank.demo.surveyTest.entity.Question;
import com.jshbank.demo.surveyTest.entity.Survey;
import com.jshbank.demo.surveyTest.repository.QuestionRepository;
import com.jshbank.demo.surveyTest.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

public class SurveyService {

  @Autowired
  private SurveyRepository surveyRepository;

  @Autowired
  private QuestionRepository questionRepository;

  @Transactional
  public Survey createSurvey(Survey survey, List<Question> questions) {
    survey = surveyRepository.save(survey);

    for (Question question : questions) {
      question.setSurvey(survey);
      question = questionRepository.save(question);
    }

    return survey;
  }
}
