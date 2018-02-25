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
import com.surveyapp.dao.EmployeeRepository;
import com.surveyapp.dao.QuestionRepository;
import com.surveyapp.model.Answer;
import com.surveyapp.model.AnswerWrapper;
import com.surveyapp.model.Question;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
public class SurveyController {

    @Autowired
    QuestionRepository qRepository;
    
    @Autowired
    AnswerRepository aRepository;

    @Transactional
    @RequestMapping(value="/questions", method = RequestMethod.GET)
    public String findByCategory(@RequestParam(value = "cat") String category, @RequestParam(value="count", required=false) String count) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
    	//Set pretty printing of json
    	objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    	
    	//Convert List of Question objects to JSON
    	String result = objectMapper.writeValueAsString(qRepository.findByCategory(category));

        return result;
    }

    @Transactional
    @RequestMapping("/findall")
    public String findAll() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
    	//Set pretty printing of json
    	objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    	
    	//Convert List of Question objects to JSON
    	String result = objectMapper.writeValueAsString(qRepository.findAll());

        return result;
    }
    
    @Transactional
    @RequestMapping("/answers")
    public String findAnswers() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
    	//Set pretty printing of json
    	objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    	
    	//Convert List of Question objects to JSON
    	String result = objectMapper.writeValueAsString(aRepository.findAll());

        return result;
    }
    
    @Transactional
    @RequestMapping(value="/save", method=RequestMethod.POST,consumes="application/json",produces="application/json")
    @ResponseBody
    public List<String> saveAnswers(@RequestBody AnswerWrapper wrapper) {
        List<String> response = new ArrayList<>();
        for (Answer next: wrapper.getAnswers()){
        aRepository.save(next);
         response.add("Saved answer: " + next.toString());
    }
        return response;
    }
    
    
    //    @Transactional
//    @RequestMapping(value="/questions", method = RequestMethod.GET)
//    public String findByCategory(@RequestParam(value = "cat") String category, @RequestParam(value="count", required=false) String count) {
//        String result = "";
//
//        result = qRepository.findByCategory(category).stream().map((next) -> next.toString() + "<br>").reduce(result, String::concat);
//
//        return result;
//    }
//    
//    @Transactional
//    @RequestMapping("/findall")
//    public String findAll() {
//        String result = "";
//
//        for (Question next : qRepository.findAll()) {
//            result += next.toString() + "<br>";
//        }
//
//        return result;
//    }
//    
//    @Transactional
//    @RequestMapping("/findanswers")
//    public String findAnswers() {
//        String result = "";
//
//        for (Answer next : aRepository.findAll()) {
//            result += next.toString() + "<br>";
//        }
//
//        return result;
//    }
}
