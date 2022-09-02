package com.amigoscode.combinatorpattern;

import lombok.extern.java.Log;

import java.time.LocalDate;

import static com.amigoscode.combinatorpattern.CustomerRegistrationValidator.isEmailValid;
import static com.amigoscode.combinatorpattern.CustomerRegistrationValidator.isAdult;
import static com.amigoscode.combinatorpattern.CustomerRegistrationValidator.isPhoneNumberValid;
import static com.amigoscode.combinatorpattern.CustomerRegistrationValidator.ValidationResult;


@Log
public class Main {

    public static void main(String[] args) {

        Customer customer = new Customer(
                "Alice",
                "alice@gmail.com",
                "+01617755000",
                LocalDate.of(2000, 1, 1)
        );


        log.info("Customer valid: " + new CustomerValidatorService().isValid(customer));

        // if valid persist to DB

        customer = new Customer(
                "Alice",
                "alice@gmail.com",
                "+01617755000",
                LocalDate.of(2000, 1, 1)
        );

        log.info("Customer valid: " + new CustomerValidatorService().isValid(customer));

        // Using combinator pattern
      ValidationResult result = isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAdult())
                .apply(customer);


      log.info("Result: "+result);

      if (result != ValidationResult.SUCCESS) {
          throw new IllegalStateException(result.name());
      }


        customer = new Customer(
                "Alice",
                "alice@gmail.com",
                "+01617755000",
                LocalDate.of(2020, 1, 1)
        );

        result = isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAdult())
                .apply(customer);


        log.info("Result: "+result);

        if (result != ValidationResult.SUCCESS) {
            throw new IllegalStateException(result.name());
        }

    }
}
