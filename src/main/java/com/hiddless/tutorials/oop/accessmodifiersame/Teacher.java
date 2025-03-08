package com.hiddless.tutorials.oop.accessmodifiersame;

public class Teacher {

    public String publicData="public";
    protected String protectedData= "protected";
    private String privateData="private";
    String defaultData= "default";


    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        System.out.println(teacher.publicData);
        System.out.println(teacher.protectedData);
        System.out.println(teacher.privateData);
        System.out.println(teacher.defaultData);
    }

}
