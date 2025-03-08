package com.hiddless.tutorials._05_week;

/*
Java 8, bazı hazır fonksiyonel arayüzler de sunar:

Predicate      → boolean test(T t)  → Koşul kontrolleri için.
Function<T, R> → R apply(T t)       → Bir değeri dönüştürmek için.
Consumer       → void accept(T t)   → Parametre alır, bir işlem yapar ama geriye değer döndürmez.
Supplier       → T get()            → Parametre almaz, bir değer üretir.
 */

import com.hiddless.util.SpecialColor;

import java.util.function.Consumer;

class Printer {
    static void printMessage(String message) {
        System.out.println(message);
    }
}

public class MethodReferances {
    public static void main(String[] args) {
        /// Yol 1-
        Printer printer1 = new Printer();
        printer1.printMessage(SpecialColor.YELLOW +"Her zaman,Her yerde en büyük FENERBAHÇE"+ SpecialColor.RESET);

        /// Yol 2-
        Consumer<String> printer2 = Printer::printMessage;
        printer2.accept(SpecialColor.BLUE+"Tadic On Fire"+ SpecialColor.RESET);
    }

}
