package com.hiddless.tutorials.oop.accessmodifierother;

import com.hiddless.tutorials.oop.accessmodifiersame.Student;

public class Manager {
    public static void main(String[] args) {
        Student student= new Student();
        System.out.println(student.publicData);
        //System.out.println(student.protectedData);
        //System.out.println(student.privateData);
        //System.out.println(student.defaultData);
    }
}
