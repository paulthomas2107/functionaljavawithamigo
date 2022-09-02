package com.amigoscode.combinatorpattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;
import static com.amigoscode.combinatorpattern.CustomerRegistrationValidator.*;
import static com.amigoscode.combinatorpattern.CustomerRegistrationValidator.ValidationResult.EMAIL_NOT_VALID;
import static com.amigoscode.combinatorpattern.CustomerRegistrationValidator.ValidationResult.PHONE_NUMBER_NOT_VALID;
import static com.amigoscode.combinatorpattern.CustomerRegistrationValidator.ValidationResult.IS_NOT_ADULT;
import static com.amigoscode.combinatorpattern.CustomerRegistrationValidator.ValidationResult.SUCCESS;

public interface CustomerRegistrationValidator
        extends Function<Customer, ValidationResult> {

    // Combinator Pattern
    static CustomerRegistrationValidator isEmailValid () {
        return customer ->
                customer.getEmail().contains("@") ?
                        SUCCESS : EMAIL_NOT_VALID;
    }

    static CustomerRegistrationValidator isPhoneNumberValid () {
        return customer ->
                customer.getPhoneNumber().startsWith("+0") ?
                        SUCCESS : PHONE_NUMBER_NOT_VALID;
    }

    static CustomerRegistrationValidator isAdult () {
        return customer ->
                Period.between(customer.getDob(), LocalDate.now()).getYears() > 16 ?
                        SUCCESS :  IS_NOT_ADULT;
    }

    default CustomerRegistrationValidator and (CustomerRegistrationValidator other) {
        return customer -> {
            ValidationResult result = this.apply(customer);
            return result.equals(SUCCESS)  ? other.apply(customer) : result;
        };
    }
    enum ValidationResult {
        SUCCESS,
        PHONE_NUMBER_NOT_VALID,
        EMAIL_NOT_VALID,
        IS_NOT_ADULT
    }
}
