package com.avinash.SpringJPA.model;


//below we have created a Model class
//so we must map the model to a Table in our database
//in JPA we can do that by using Annotation @Entity
//lets do that
//we must define the Primary key in the model
//we will do that by Annotation @Id
//in our model "roll" is primary key
//hence we will use @Id above it

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Entity //mapping with the table in database
public class  Student {

    //instance variable
    @Id
    private int roll;
    private String fname;
    private String lname;
    private int marks;

    //setters

    //roll
    public void setRoll(int roll){this.roll = roll;}

    //fname
    public void setFname(String fname){this.fname = fname;}

    //lname
    public void setLname(String lname){this.lname = lname;}

    //marks
    public void setMarks(int marks){this.marks = marks;}

    //getters

    //roll
    public int getRoll(){return this.roll;}

    //fname
    public String getFname(){return this.fname;}

    //lname
    public String getLname(){return this.lname;}

    //marks
    public int getMarks(){return this.marks;}

    //methods
    @Override
    public String toString() {
        return "Student{" +
                "roll=" + this.roll +
                ", First Name='" + this.fname + '\'' +
                ", Last Name=" + this.lname +
                ", marks=" + this.marks +
                '}';
    }

}
