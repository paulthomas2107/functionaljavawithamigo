package com.amigoscode.functionalinterfaces;

import lombok.extern.java.Log;

import java.util.function.Predicate;

@Log
public class _Predicate {

    public static void main(String[] args) {

        // Normal
        log.info(String.valueOf(isPhoneNumberValid("07000000001")));
        log.info(String.valueOf(isPhoneNumberValid("0700000000")));
        log.info(String.valueOf(isPhoneNumberValid("0900000002")));

        // Predicate
        log.info(String.valueOf(isPhoneNumberValidPredicate.test("07000000001")));
        log.info(String.valueOf(isPhoneNumberValidPredicate.test("0700000000")));


    }

    static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.startsWith("07") && phoneNumber.length() == 11;
    }

    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber ->
            phoneNumber.startsWith("07") && phoneNumber.length() == 11;
}
