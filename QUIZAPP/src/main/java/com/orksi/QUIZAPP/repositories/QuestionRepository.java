package com.orksi.QUIZAPP.repositories;

import com.orksi.QUIZAPP.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

}
