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
import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.Temporal;

@Entity
@Table(name = "answers")
public class Answer implements Serializable {

    @GeneratedValue
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "q_id")
    private int questionId;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "response_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date = new Date();

    @Column(name = "category")
    private String category;

    @Column(name = "likert_response")
    private Double likertResponse = 0.0;

    @Column(name = "text_response")
    private String textResponse = "";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getLikertResponse() {
        return likertResponse;
    }

    public void setLikertResponse(double likertResponse) {
        this.likertResponse = likertResponse;
    }

    public String getTextResponse() {
        return textResponse;
    }

    public void setTextResponse(String textResponse) {
        this.textResponse = textResponse;
    }

    @Override
    public String toString() {
        return String.format("Employee[id=%d, questionId='%s', userId='%s', date='%s', category='%s', likertResponse='%s', textResponse='%s']",
                id, questionId, userId, date, category, likertResponse, textResponse);
    }
}
