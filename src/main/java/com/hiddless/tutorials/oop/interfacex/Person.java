package com.hiddless.tutorials.oop.interfacex;

import java.io.Serializable;
import java.util.Objects;

abstract public class Person implements IPersonCommonFeatures, Serializable {

    public static final long serialVersionUID=1L;

    private String name;
    private String surname;

    public Person() {
    }

    /// Parameter

    public Person(String name, String surname) {
        this.name = name;
        this.surname= surname;
    }

    /// toString
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

    /// Equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person= (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(surname, person.surname);
    }

    @Override public int hashCode() {
        return Objects.hash(name, surname);
    }



}
