package com.hiddless.tutorials._05_week;

/*
Java 8, bazı hazır fonksiyonel arayüzler de sunar:

Predicate → boolean test(T t)  → Koşul kontrolleri için.
Function<T, R> → R apply(T t)  → Bir değeri dönüştürmek için.
Consumer → void accept(T t)    → Parametre alır, bir işlem yapar ama geriye değer döndürmez.
Supplier → T get()             → Parametre almaz, bir değer üretir.
 */

import com.hiddless.util.SpecialColor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Stream {

    /// Normal List Add
    public static ArrayList<String> streamExam1() {
        ArrayList<String> names = new ArrayList<>();
        names.add("Sophie");
        names.add("Ela");
        names.add("Tom");
        names.add("Eren");
        names.add("Mary");
        names.add("Necoli");
        names.add("Efsune");
        for (String name : names) {
            if (name.startsWith("E")) {
                System.out.println(name);
            }
        }
        System.out.println();
        return names;
    }


    /// Diziyi Listeye çevirsek
    public static void streamExam2() {
        List<String> names = Arrays.asList("Sophie","Ela","Tom", "Eren","Mary","Necoli","Efsune");
        for (String name : names) {
            if (name.startsWith("E")) {
                System.out.println(name);
            }
        }
        System.out.println();
    }

    /// Java 8 ile gelen Stream Özelliği
    public static void streamExam3() {
        List<String> names = streamExam1()
                .stream()
                .filter(xyz -> xyz.startsWith("E"))
                .collect(Collectors.toList());
        names.forEach(System.out::print);
    }

    public static void main(String[] args) {
        System.out.println(SpecialColor.CYAN + "1.YÖNTEM"+ SpecialColor.RESET);
        streamExam1();

        System.out.println(SpecialColor.PURPLE + "2.YÖNTEM" +SpecialColor.RESET);
        streamExam2();

        System.out.println(SpecialColor.GREEN + "3.YÖNTEM"+ SpecialColor.RESET);
        streamExam3();
    }
}
