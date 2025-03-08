package com.hiddless.tutorials.oop.inheritance;

public class MainInheritence {

    public static void main(String[] args) {

        /// Person
        Person person = new Person("person adı-1","person soyadı-1");
        person.fullName();
        System.out.println(person);
        System.out.println("********************");

        /// Student
        Student student = new Student("öğrenci adı-1", "öğrenci soyadı-1", "öğrenciye özel");
        student.fullName();
        System.out.println(student);
        System.out.println("********************");

        /// Teacher
        Teacher teacher = new Teacher("teacher adı-1","teacher soyadı-1");
        teacher.fullName();
        System.out.println(teacher);
        System.out.println("********************");
    }
}
