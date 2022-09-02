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
        log.info(String.valueOf(isPhoneNumberValidPredicate.test("0900000002")));

        // Chained Predicate
        log.info(String.valueOf(isPhoneNumberValidPredicate.and(containsNumber3).test("07000000003")));
        log.info(String.valueOf(isPhoneNumberValidPredicate.and(containsNumber3).test("07000000009")));
        log.info(String.valueOf(isPhoneNumberValidPredicate.or(containsNumber3).test("070000000093")));

    }

    static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.startsWith("07") && phoneNumber.length() == 11;
    }

    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber ->
            phoneNumber.startsWith("07") && phoneNumber.length() == 11;

    static Predicate<String> containsNumber3 = phoneNumber ->
            phoneNumber.contains("3");
}
