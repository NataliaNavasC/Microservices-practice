package com.example.app.questionsservice.repository;

import com.example.app.questionsservice.model.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Integer> {
}
