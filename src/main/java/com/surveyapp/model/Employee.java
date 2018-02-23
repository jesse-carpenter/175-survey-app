/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.surveyapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "employee")
public class Employee implements Serializable{
    
    public Employee(int id, String firstName, String lastName, String description) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
    }

    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMP_SEQ")
//    @SequenceGenerator(sequenceName = "employee_seq", allocationSize = 1, name = "EMP_SEQ")
    @Column(name = "id")
    private int id;
    
    @Column(name = "firstname")
    private String firstName;
    
    @Column(name = "lastname")
    private String lastName;
    
    @Column(name = "description")
    private String description;
            

    private Employee() {}
    
    @Override
	public String toString() {
		return String.format("Employee[id=%d, firstName='%s', lastName='%s', description='%s']", 
                        id, firstName, lastName, description);
	}

    
}

