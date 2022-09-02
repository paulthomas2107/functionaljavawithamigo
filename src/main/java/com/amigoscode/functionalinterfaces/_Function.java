package com.amigoscode.functionalinterfaces;

import lombok.extern.java.Log;

import java.util.function.Function;

@Log
public class _Function {

    public static void main(String[] args) {


        // Basic
        int increment = increment(1);
        log.info(String.valueOf(increment));

        // With Function
        int increment2 = incrementByOneFunction.apply(1);
        log.info(String.valueOf(increment2));

    }

    static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;

    static int increment(int number) {
        return number + 1;
    }
}
