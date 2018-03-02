/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.surveyapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;

@Entity
public class Answer implements Serializable {

    @GeneratedValue
    @Id
    private int id;

    @NotNull
    private int questionId;

    private String userId = "";

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date responseDate = new Date();

    private String category = "";

    private Double likertResponse = 0.0;

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
        return responseDate;
    }

    public void setDate(Date date) {
        this.responseDate = date;
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
        return String.format("Answer[id=%d, questionId='%s', userId='%s', date='%s', category='%s', likertResponse='%s', textResponse='%s']",
                id, questionId, userId, responseDate, category, likertResponse, textResponse);
    }
}
