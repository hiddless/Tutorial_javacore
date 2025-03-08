package com.hiddless.tutorials.oop.inheritance;

import java.io.Serializable;

public class Student extends Person implements Serializable {

    /// Sadece Student
    private String studentsSpeacial;

    /// Serileştirme
    public static final long serialVersionUID=1L;

    public Student() {
    }

    public Student(String name, String surname, String studentsSpeacial) {
        super(name, surname);
        this.studentsSpeacial=studentsSpeacial;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentSpecial='" + studentsSpeacial + '\'' +
                "} " + super.toString();
    }
}
