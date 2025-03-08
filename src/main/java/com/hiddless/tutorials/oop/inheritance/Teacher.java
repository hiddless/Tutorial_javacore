package com.hiddless.tutorials.oop.inheritance;

import java.io.Serializable;

public class Teacher extends Person implements Serializable {

    /// Serileştirme
    public static final long serialVersionUID=1L;

    public Teacher() {
    }

    public Teacher(String name, String surname) {
        super(name,surname);
    }

    @Override
    public String toString() {
        return "Teacher{} " + super.toString();
    }
}
