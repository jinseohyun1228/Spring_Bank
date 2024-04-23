package com.jshbank.demo.surveyTest.repository;

import com.jshbank.demo.surveyTest.entity.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyRepository extends JpaRepository<Survey, Long> {
}