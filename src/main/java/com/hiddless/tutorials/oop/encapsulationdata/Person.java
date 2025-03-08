package com.hiddless.tutorials.oop.encapsulationdata;

public class Person {

    /// Field
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age){
        if (age>0) {
            this.age =age;
        }else {
            System.out.println("Yaşı sıfırdan küçük giremezsiniz!");
            this.age=Math.abs(age);
        }

    }
}
