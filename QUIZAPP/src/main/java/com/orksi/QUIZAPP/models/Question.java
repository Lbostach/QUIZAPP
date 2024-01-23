package com.orksi.QUIZAPP.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Question {
        @Id
        @GeneratedValue
        private int id;

    private String questionText;
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Answer> answers;

    public Question(String questionText) {
        this.questionText = questionText;
        this.answers = new ArrayList<>();
    }



    public String getQuestionText() {
        return questionText;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public boolean isCorrect(Answer answer) {
        return answer.isCorrect();
    }

    // Shuffle the order of answers
    public void shuffleAnswers() {
        Collections.shuffle(answers);
    }
}
