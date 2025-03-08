package com.hiddless.tutorials.oop.inheritance;

import java.util.Objects;

public class Person {
    /// Serileştirme
    public static final long serialVersionUID=1L;

    /// Variable
    private String name;
    private String surname;

    /// Constructor
    public Person(){
    }

    /// Parametreli Consructor
    public Person(String name, String surname){
        this.name= name;
        this.surname= surname;
    }

    /// To String
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,surname);
    }

    /// Method
    public String fullName(){
        return this.name+" "+this.surname;
    }

    /// Getter and Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
       if (surname.length()>=3) {
           this.surname = surname.toUpperCase().substring(0,3);
       }
       this.surname = surname.toUpperCase();
    }
}
