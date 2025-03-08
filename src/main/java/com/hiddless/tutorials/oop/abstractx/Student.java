package com.hiddless.tutorials.oop.abstractx;

import java.io.Serializable;

public class Student extends Person implements Serializable {

    /// Sadece student
    private String studentSpecial;

    /// Serileştirme

    public static final long serialVersionUID=1L;

    public Student() {
    }

    public Student(String name, String surname, String studentSpecial) {
        super(name, surname);

        this.studentSpecial=studentSpecial;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentSpecial='" + studentSpecial + '\'' +
                "} " + super.toString();
    }

    @Override
    public void govdesizMethod() {
        System.out.println("Student Gövdesiz Method");
    }
}
