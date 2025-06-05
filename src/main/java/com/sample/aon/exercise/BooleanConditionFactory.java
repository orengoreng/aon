package com.sample.aon.exercise;

import java.util.List;
import java.util.function.BooleanSupplier;

/**
 * This class factory checks for multiple boolean expression to avoid nested if-else statement
 */
public class BooleanConditionFactory {

    // Supply all boolean supplier for condition check
    static boolean checkCondition(List<BooleanSupplier> expression) {
        return !expression.stream().anyMatch(u -> !u.getAsBoolean());
    }

    public static void main(String args[]) {
        A a = new A();
        a.name = "test";
        System.out.println(BooleanConditionFactory.checkCondition(List.of(() -> "students".equals("students") && "world".equals("world"), ()->"test".equals("test"))));
    }
}

class A {
    String name;
}

