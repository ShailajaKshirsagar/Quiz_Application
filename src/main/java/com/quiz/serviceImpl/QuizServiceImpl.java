package com.quiz.serviceImpl;

import com.quiz.dto.QuizQuestionDto;
import com.quiz.entity.Questions;
import com.quiz.entity.Quiz;
//import com.quiz.repository.QuizRepository;
import com.quiz.repository.QuestionRepository;
import com.quiz.repository.QuizRepository;
import com.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizServiceImpl implements QuizService
{
    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public String saveQuiz(int noofque, String quizName, String category) {

        List<Questions> questionsList = questionRepository.findRandomQuestion(noofque,category);

        Quiz quiz = new Quiz();
        quiz.setTitle(quizName);
        quiz.setNoOfQue(noofque);
        quiz.setCategory(category);
        quiz.setQuestionsList(questionsList);

        quizRepository.save(quiz);
        return "Quiz is created";
    }

    @Override
    public List<QuizQuestionDto> getQuizQuestion(int quizId) {

        //because quiz questions will be retriend from questions table so we have to use that repo.

        Quiz quiz = quizRepository.findById(quizId).get();

        List<Questions> questionsList = quiz.getQuestionsList();

        List<QuizQuestionDto> dtoList = new ArrayList<>();

        for( Questions questions :questionsList){
            QuizQuestionDto dto = new QuizQuestionDto();
            dto.setId(questions.getId());
            dto.setQuestion(questions.getQuestion());
            dto.setOption1(questions.getOption1());
            dto.setOption2(questions.getOption2());
            dto.setOption3(questions.getOption3());
            dto.setOption4(questions.getOption4());
            dtoList.add(dto);
        }
        return dtoList;
    }
}
