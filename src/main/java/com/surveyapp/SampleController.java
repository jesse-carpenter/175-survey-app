/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.surveyapp;


import com.surveyapp.dao.EmployeeRepository;
import com.surveyapp.model.Employee;
import com.surveyapp.model.Greeting;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
@RequestMapping("/sample")
public class SampleController {
    
    @Autowired
    EmployeeRepository repository;
    
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    

    @RequestMapping("/testPage")
    public String welcome(Map<String, Object> model) {
//        return new ModelAndView("testpage");
//		model.put("message", this.message);
		return "testpage";
	}

 

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    @Transactional
    @RequestMapping("/findall")
    public String findAll(){
            String result = "";

            for(Employee emp : repository.findAll()){
                    result += emp.toString() + "<br>";
            }

            return result;
    }
    @Transactional
    @RequestMapping("/save")
	public String process(){
         // save a single Customer
        repository.save(new Employee(4, "Jack", "Smith", "Lumber Jack"));

//        // save a list of Customers
//        repository.save(Arrays.asList(new Customer("Adam", "Johnson"), new Customer("Kim", "Smith"),
//                new Customer("David", "Williams"), new Customer("Peter", "Davis")));

        return "Done";
    }
}
