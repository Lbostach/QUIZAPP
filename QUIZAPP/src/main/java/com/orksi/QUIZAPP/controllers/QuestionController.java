package com.orksi.QUIZAPP.controllers;

import com.orksi.QUIZAPP.models.Answer;
import com.orksi.QUIZAPP.models.Question;
import com.orksi.QUIZAPP.repositories.QuestionRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionController(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }
    @GetMapping("/{questionId}")
    public Question getQuestion(@PathVariable int questionId) {
        return questionRepository.findById(questionId)
                .orElseThrow(() -> new ResourceNotFoundException("Question not found with id " + questionId));
    }
    @GetMapping("/{questionId}/answers")
    public List<Answer> getAnswersForQuestion(@PathVariable int questionId) {
        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new ResourceNotFoundException("Question not found with id " + questionId));
        return question.getAnswers();
    }
}