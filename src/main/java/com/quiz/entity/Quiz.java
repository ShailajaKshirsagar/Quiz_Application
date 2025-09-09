package com.quiz.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
public class Quiz
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private int noOfQue;

    private String option1;

    private String option2;

    private String option3;

    private String option4;

    @ManyToMany
    private List<Questions> questionsList;

}
