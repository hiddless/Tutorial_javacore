package com.hiddless.tutorials.oop.interfacex;

public interface IPersonCommonFeatures {

    public void getUp();
    public void eat();
    public void goToSchool();
    public void comeFromSchool();

    default void interfaceGovdeliMethod() {
        System.out.println("Interface Gövdeli Method");
    }

}
