package com.amigoscode.functionalinterfaces;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.java.Log;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

@Log
public class _Consumer {

    public static void main(String[] args) {

        Customer paul = new Customer("Paul", "555-1234");

        // Normal Java
        greetCustomer(paul);
        greetCustomerV2(paul, false);
        // Functional interface
        greetCustomerConsumer.accept(paul);
        // BIConsumer version
        greetCustomerConsumerV2.accept(paul, true);
        greetCustomerConsumerV2.accept(paul, false);
    }

    static Consumer<Customer> greetCustomerConsumer = customer ->
            log.info("Hello "+customer.customerName + ", thanks for registering phone " + customer.customerPhoneNumber);

    static BiConsumer<Customer, Boolean> greetCustomerConsumerV2 = (customer, showPhoneNumber) ->
            log.info("Hello "+customer.customerName
                    + ", thanks for registering phone "
                    + (showPhoneNumber ? customer.customerPhoneNumber : "********"));
    static void greetCustomer(Customer customer) {
        log.info("Hello "+customer.customerName + ", thanks for registering phone " + customer.customerPhoneNumber);
    }

    static void greetCustomerV2(Customer customer, boolean showPhoneNumber) {
        log.info("Hello "+customer.customerName
                + ", thanks for registering phone "
                + (showPhoneNumber ? customer.customerPhoneNumber : "********"));
    }

    @Data
    @AllArgsConstructor
    static class Customer {
        private final String customerName;
        private final String customerPhoneNumber;

    }
}

