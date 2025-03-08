package com.hiddless.tutorials._05_week;

/// Java 1.7 ile gelen özellik
interface MathOperation1 {
    int operation(int a, int b);
}

/// Java 1.8 ile gelen
@FunctionalInterface
interface MathOperation2 {
    int operation(int a, int b);
}

public class _02_Lambda {

    public static void main(String[] args) {
        MathOperation1 addition1 = new MathOperation1() {
            @Override
            public int operation(int a, int b) {
                return a + b;
            }
        };
        System.out.println(addition1.operation(9, 81));

        /// Java 1.8 ile gelen Lambda Expression
        MathOperation2 addition2 = (a, b) -> a + b;
        System.out.println(addition2.operation(9,81));
    }
}
