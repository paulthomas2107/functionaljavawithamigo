package com.amigoscode.functionalinterfaces;

import lombok.extern.java.Log;

import java.util.function.BiFunction;
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

        // Calling functions together
        int multipleBy10 = multiplyBy10Function.apply(increment2);
        log.info(String.valueOf(multipleBy10));

        // Better way of combining functions
        Function<Integer, Integer> addBy1ThenMultiplyBy10
                = incrementByOneFunction.andThen(multiplyBy10Function);
        log.info(String.valueOf(addBy1ThenMultiplyBy10.apply(4)));

        // Bi-function takes 2 arguments and returns third
        // Normal
        log.info(String.valueOf(incrementByOneAndMultiply(4, 100)));
        // Bi-function version
        log.info(String.valueOf(incrementByOneAndMultiplyBiFunction.apply(4, 100)));

    }

    static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;

    static Function<Integer, Integer> multiplyBy10Function = number -> number * 10;

    static int increment(int number) {
        return number + 1;
    }

    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBiFunction =
            (numberToIncrementByOne, numberToMultiplyBy)
                    -> (numberToIncrementByOne + 1) * numberToMultiplyBy;

    static int incrementByOneAndMultiply(int number, int numToMultiplyBy) {
        return (number + 1) * numToMultiplyBy;
    }

}
