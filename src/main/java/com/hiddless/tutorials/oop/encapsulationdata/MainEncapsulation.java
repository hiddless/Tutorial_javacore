package com.hiddless.tutorials.oop.encapsulationdata;

import com.hiddless.util.SpecialColor;

public class MainEncapsulation {
    public static void main(String[] args) {
        Person person= new Person();
        person.setName("Sophia");

        person.setAge(18);
        System.out.println(SpecialColor.BLUE +"ADI: "+person.getName()+" YAŞI: "+person.getAge()+SpecialColor.RESET);
    }
}
