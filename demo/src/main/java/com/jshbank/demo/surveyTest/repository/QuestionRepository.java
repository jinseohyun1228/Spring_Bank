package com.jshbank.demo.surveyTest.repository;

import com.jshbank.demo.surveyTest.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}