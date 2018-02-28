/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.surveyapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;

@Entity
public class Survey implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @ManyToMany(mappedBy = "surveys", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Question> questions = new ArrayList<>();

    private Survey() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public Survey(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void addQuestion(Question question) {
        questions.add(question);
        question.surveys.add(this);

    }

    public void removeQuestion(Question question) {
        questions.remove(question);
        question.surveys.remove(this);

    }

    public void remove() {
        for (Question question : new ArrayList<>(questions)) {
            removeQuestion(question);
        }
    }
}
