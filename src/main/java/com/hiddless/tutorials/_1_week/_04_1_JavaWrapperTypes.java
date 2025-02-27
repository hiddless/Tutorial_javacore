package com.hiddless.tutorials._1_week;

import com.hiddless.util.SpecialColor;

import java.util.Scanner;

public class _04_1_JavaWrapperTypes {
    public static void main(String[] args) {

    // WRAPPER TYPE (new varsa)
        Scanner scanner = new Scanner(System.in);
        Byte b = null;
        while (b==null) {
            System.out.println("Bir Sayı gir -127<x<127");
            if (scanner.hasNextByte()) {
                byte temp= scanner.nextByte();
                if (temp >= -128 && temp <=127) {
                    b= temp;
                }else {
                    System.out.println(SpecialColor.RED + "Aralık içinde bir sayı girmediniz! Lütfen Tekrar dene"+ SpecialColor.RESET);
                    scanner.next();
                }
            }
            System.out.println("Girilen geçerli değer: "+b);
            scanner.close();

        }

    // Primitive => Wrapper Type dönüştürmek
    int primitiveValue = 100;
    Integer wrapperValue = primitiveValue;
        System.out.println("Wrapper Integer: " + wrapperValue);
    }
}
