package com.amigoscode.imperative;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Log
public class Main {
    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("Paul", Gender.MALE),
                new Person("Maria", Gender.FEMALE),
                new Person("John", Gender.MALE),
                new Person("Caitlin", Gender.FEMALE),
                new Person("Bill", Gender.MALE)
                );

        // Imperative approach
        log.info("Imperative......");
        List<Person> females = new ArrayList<>();
        for (Person person : people) {
            if (Gender.FEMALE.equals(person.gender)) {
                females.add(person);
            }
        }
        for (Person person : females) {
            log.info(person.toString());
        }

        // Declarative approach
        log.info("Declarative......");
        Predicate<Person> personPredicate = person -> Gender.FEMALE.equals(person.gender);

        List<Person> females2 = people.stream()
                .filter(personPredicate)
                .collect(Collectors.toList());
        people.forEach(System.out::println);
    }

    @Data
    @AllArgsConstructor
    static class Person {
        private final String name;
        private final Gender gender;
    }

    enum Gender {
        MALE, FEMALE
    }
}
