package com.quiz.service;

import com.quiz.dto.QuizQuestionDto;
import com.quiz.entity.Questions;
import com.quiz.entity.Quiz;

import java.util.List;

public interface QuizService
{
    //save quizs
    String saveQuiz(int noofque,String quizName, String category);

    //get quiz question by quiz id
   List<QuizQuestionDto> getQuizQuestion(int quizId);
}
