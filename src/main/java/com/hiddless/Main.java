package com.hiddless;

import com.hiddless.controller.StudentController;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
            StudentController studentController = new StudentController();
            studentController.chooise();
        }catch (Exception e) {

        }
    }
}