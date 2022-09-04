package com.amigoscode.finalsection;

import lombok.extern.java.Log;

import java.util.function.Consumer;

@Log
public class Main {

    public static void main(String[] args) {

        hello("John", null, value -> {
            log.info("Last name not provided for " + value);
        });

    }

    static void hello(String firstName, String lastName, Consumer<String> callback) {
        log.info(firstName);
        if (lastName != null) {
            log.info(lastName);
        } else {
            callback.accept(firstName);
        }
    }
}
