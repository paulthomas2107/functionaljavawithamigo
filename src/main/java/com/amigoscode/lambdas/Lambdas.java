package com.amigoscode.lambdas;

import lombok.extern.java.Log;

import java.util.function.BiFunction;
import java.util.function.Function;


@Log
public class Lambdas {

    public static void main(String[] args) {

        Function<String, String> upperCaseName1 = name -> {
            // Logic
            if (name.isBlank()) throw new IllegalArgumentException("");
                return name.toUpperCase();
        };

        BiFunction<String, Integer, String> upperCaseName2 = (name, age) -> {
            // Logic
            if (name.isBlank()) throw new IllegalArgumentException("");
            log.info(age.toString());
            return name.toUpperCase();
        };

        log.info(upperCaseName1.apply("paul"));
        log.info(upperCaseName2.apply("thomas", 50));




    }


}
