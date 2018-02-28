/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.surveyapp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.surveyapp.dao.AnswerRepository;
import com.surveyapp.dao.QuestionRepository;
import com.surveyapp.dao.SurveyRepository;
import com.surveyapp.model.Answer;
import com.surveyapp.model.AnswerWrapper;
import com.surveyapp.model.Question;
import com.surveyapp.model.QuestionWrapper;
import com.surveyapp.model.Survey;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
public class SurveyController {

    @Autowired
    QuestionRepository questionRepo;

    @Autowired
    AnswerRepository answerRepo;
    
    @Autowired
    SurveyRepository surveyRepo;

    @RequestMapping("/ping")
    public String heartbeat() {
        return "pong";
    }

    
    @Transactional
    @RequestMapping(value = "/questions", params = "id", method = RequestMethod.GET)
    public String findById(@RequestParam Integer id) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        //Set pretty printing of json
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        return objectMapper.writeValueAsString(questionRepo.findById(id));
    }
    
    @Transactional
    @RequestMapping(value = "/questions", params = "category", method = RequestMethod.GET)
    public String findQuestionsByCategory(@RequestParam String category, @RequestParam(value = "count", required = false) Integer count) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        //Set pretty printing of json
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        
        if (count != null) {
            Pageable page = PageRequest.of(0, count);
            //Convert List of Question objects to JSON
            return objectMapper.writeValueAsString(questionRepo.findByCategory(category, page));
        } else {
            //Convert List of Question objects to JSON
            return objectMapper.writeValueAsString(questionRepo.findByCategory(category));
        }
    }
    
    @Transactional
    @RequestMapping(value = "/questions", method = RequestMethod.GET)
    public String findQuestions(@RequestParam(value = "count", required = false) Integer count) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        //Set pretty printing of json
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        
        if (count != null) {
            Pageable page = PageRequest.of(0, count);
            //Convert List of Question objects to JSON
            return objectMapper.writeValueAsString(questionRepo.findAll(page).getContent());
        } else {
            //Convert List of Question objects to JSON
            return objectMapper.writeValueAsString(questionRepo.findAll());
        }
    }
    
    
    @Transactional
    @RequestMapping(value = "/answers", params = "category", method = RequestMethod.GET)
    public String findAnswersByCategory(@RequestParam String category, @RequestParam(value = "count", required = false) Integer count) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        //Set pretty printing of json
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        
        if (count != null) {
            Pageable page = PageRequest.of(0, count);
            //Convert List of Question objects to JSON
            return objectMapper.writeValueAsString(answerRepo.findByCategory(category, page));
        } else {
            //Convert List of Question objects to JSON
            return objectMapper.writeValueAsString(answerRepo.findByCategory(category));
        }
    }
    

    @Transactional
    @RequestMapping(value = "/answers", method = RequestMethod.GET)
    public String findAnswers(@RequestParam(value = "count", required = false) Integer count) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        //Set pretty printing of json
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        if (count != null) {
            Pageable page = PageRequest.of(0, count);
            //Convert List of Question objects to JSON
            return objectMapper.writeValueAsString(answerRepo.findAll(page).getContent());
        } else {
            //Convert List of Question objects to JSON
            return objectMapper.writeValueAsString(answerRepo.findAll());
        }
    }

    
    @Transactional
    @RequestMapping(value = "/surveys", params = "id", method = RequestMethod.GET)
    public String findSurveyById(@RequestParam Integer id) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        //Set pretty printing of json
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        return objectMapper.writeValueAsString(surveyRepo.findById(id));
    }
    
    @Transactional
    @RequestMapping(value = "/surveys", params = "title", method = RequestMethod.GET)
    public String findSurveyByTitle(@RequestParam String title) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        //Set pretty printing of json
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        return objectMapper.writeValueAsString(surveyRepo.findByTitle(title));
    }
    
    @Transactional
    @RequestMapping(value = "/surveys", method = RequestMethod.GET)
    public String findSurveys(@RequestParam(value = "count", required = false) Integer count) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        //Set pretty printing of json
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        if (count != null) {
            Pageable page = PageRequest.of(0, count);
            //Convert List of Question objects to JSON
            return objectMapper.writeValueAsString(surveyRepo.findAll(page).getContent());
        } else {
            //Convert List of Question objects to JSON
            return objectMapper.writeValueAsString(surveyRepo.findAll());
        }
    }
    
    
    @Transactional
    @RequestMapping(value = "/saveQuestions", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public List<String> saveQuestions(@RequestBody QuestionWrapper wrapper) {
        List<String> response = new ArrayList<>();
        for (Question next : wrapper.getQuestions()) {
            questionRepo.save(next);
            response.add("Saved question: " + next.toString());
        }
        return response;
    }
    
    @Transactional
    @RequestMapping(value = "/saveAnswers", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public List<String> saveAnswers(@RequestBody AnswerWrapper wrapper) {
        List<String> response = new ArrayList<>();
        for (Answer next : wrapper.getAnswers()) {
            answerRepo.save(next);
            response.add("Saved answer: " + next.toString());
        }
        return response;
    }
    
    @Transactional
    @RequestMapping(value = "/saveSurvey", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public List<String> saveSurvey(@RequestBody Survey survey) {
        surveyRepo.save(survey);
        
        List<String> response = new ArrayList<>();
        response.add(survey.getTitle());
        for (Question next : survey.getQuestions()) {
            next.getSurveys().add(survey);
            response.add("Saved question: " + next.getQuestion());
        }
        return response;
    }

}
