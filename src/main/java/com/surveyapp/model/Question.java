/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.surveyapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "questions")
public class Question implements Serializable{
    
    @GeneratedValue
    @Id
    @Column(name = "id")
    private int id;
    
    @NotNull
    @Column(name = "question")
    private String question;

    @NotNull
    @Column(name = "category")
    private String category;
    
    @Column(name = "likert")
    private boolean likert = true;
    
    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "Survey_Question",
        joinColumns = {
            @JoinColumn(
                name = "question_id", 
                referencedColumnName = "id"
            )
        },
        inverseJoinColumns = {
            @JoinColumn(
                name = "survey_id", 
                referencedColumnName = "id"
            )
        }
    )
    protected List<Survey> surveys = new ArrayList<>();
            
    public int getId() {
        return id;
    }

    public List<Survey> getSurveys() {
        return surveys;
    }

    public void setSurveys(List<Survey> surveys) {
        this.surveys = surveys;
    }

    public String getQuestion() {
        return question;
    }

    public String getCategory() {
        return category;
    }

    public boolean isLikert() {
        return likert;
    }
    
    public void setQuestion(String question) {
        this.question = question;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setLikert(boolean likert) {
        this.likert = likert;
    }
    
    @Override
    public String toString() {
            return question;
    }

    
}

