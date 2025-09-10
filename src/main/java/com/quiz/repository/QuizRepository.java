package com.quiz.repository;

import com.quiz.entity.Questions;
import com.quiz.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepository extends JpaRepository<Quiz,Integer> {

    @Query(value = "SELECT * FROM questions q WHERE q.category = :category ORDER BY RAND() LIMIT :no_of_que", nativeQuery = true)
    List<Questions> findRandomQuestion(@Param("no_of_que") int no_of_que, @Param("category") String category);

}
