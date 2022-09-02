package com.amigoscode.optionals;

import lombok.extern.java.Log;

import java.util.Optional;
import java.util.function.Supplier;

@Log
public class Main {

    public static void main(String[] args) {

        Object value = Optional.ofNullable("Hello")
                .orElseGet(() -> "default value");
        log.info((String) value);

        /*
        value = Optional.ofNullable(null)
                .orElseThrow(() -> new IllegalStateException("Exception here !"));
        log.info((String) value);
         */

        /*
        Supplier<IllegalStateException> exception = () -> new IllegalStateException("Exception here !");
        value = Optional.ofNullable(null)
                .orElseThrow(exception);
        log.info((String) value);

        */
        Optional.ofNullable("Hello_001")
                .ifPresent(item -> {
                    log.info(item);
                });

        Optional.ofNullable(null)
                .ifPresentOrElse(
                        email -> log.info("Sending mail to "+email),
                        () -> log.info("Cannot send email")
                );


        Optional.ofNullable("paul@Paul.com")
                .ifPresentOrElse(
                        email -> log.info("Sending mail to "+email),
                        () -> log.info("Cannot send email")
                );

    }
}
