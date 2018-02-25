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
import javax.persistence.GeneratedValue;

@Entity
@Table(name = "questions")
public class Question implements Serializable{
    
    @GeneratedValue
    @Id
    @Column(name = "id")
    private int id;
    
    @Column(name = "question")
    private String question;
    
    @Column(name = "category")
    private String category;
    
    @Column(name = "likert")
    private boolean likert;
            

//    private Question() {}

    public int getId() {
        return id;
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
    
    @Override
    public String toString() {
            return question;
    }

    
}

