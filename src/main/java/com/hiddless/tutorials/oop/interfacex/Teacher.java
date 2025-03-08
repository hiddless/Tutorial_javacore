package com.hiddless.tutorials.oop.interfacex;

import java.io.Serializable;

public class Teacher extends Person implements Serializable {

    public static final long serialVersionUID=1L;

    public Teacher() {
    }

    public Teacher(String name, String surname){
        super(name, surname);
    }

    @Override
    public String toString() {
        return "Teacher{} " + super.toString();
    }

    @Override
    public void govdesizMethod() {
        System.out.println("Teacher Gövdesiz Method");
    }

    /// Interface
    @Override
    public void getUp() {
        System.out.println("Öğretmen Ayağa Kalktı");
    }

    @Override
    public void eat() {
        System.out.println("Öğretmen Yemeğini Yedi");
    }

    @Override
    public void goToSchool() {
        System.out.println("Öğretmen Okula Gitti");
    }

    @Override
    public void comeFromSchool() {
        System.out.println("Öğretmen Okuldan Geldi");
    }

    @Override
    public void interfaceGovdeliMethod() {
        super.interfaceGovdeliMethod();
        System.out.println("Teacher tinterface Gövdeli");
    }

}
