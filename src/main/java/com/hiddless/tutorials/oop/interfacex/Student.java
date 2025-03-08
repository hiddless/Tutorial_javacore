package com.hiddless.tutorials.oop.interfacex;

import java.io.Serializable;

public class Student extends Person implements Serializable {

    /// Sadece student
    private String studentSpecial;

    /// Serileştirme
    public static final long serialVersionUID=1L;

    public Student() {
    }

    public Student(String name, String surname, String studentSpecial){
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
        System.out.println("Student Gövdesiz Methodu");
    }

    /// Interface
    @Override
    public void getUp() {
        System.out.println("Öğrenci Ayağa Kalktı");
    }

    @Override
    public void eat() {
        System.out.println("Öğrenci Yemeğini Yedi");
    }

    @Override
    public void goToSchool() {
        System.out.println("Öğrenci Okula Gitti");
    }

    @Override
    public void comeFromSchool() {
        System.out.println("Öğrenci Okuldan Geldi");
    }

    @Override
    public void interfaceGovdeliMethod() {
        super.interfaceGovdeliMethod();
        System.out.println("Student tinterface Gövdeli");
    }

}
