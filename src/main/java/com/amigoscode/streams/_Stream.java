package com.amigoscode.streams;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.java.Log;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

import static com.amigoscode.streams._Stream.Gender.*;

@Log
public class _Stream {

    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("Paul", MALE),
                new Person("Maria", FEMALE),
                new Person("John", MALE),
                new Person("Caitlin", FEMALE),
                new Person("Bill", MALE),
                new Person("Sarah", PREFER_NOT_TO_SAY));



        log.info("Person count: " + String.valueOf(people.stream().count()));

        // Get set unique set of genders
        Set<Gender> uniqueGenders =
                people.stream()
                        .map(person -> person.gender)
                        .collect(Collectors.toSet());

        log.info(String.valueOf(uniqueGenders));

        // Show unique genders
        people.stream()
                .map(person -> person.gender)
                .collect(Collectors.toSet())
                .forEach(gender -> log.info(String.valueOf(gender)));

        // Show unique Names
        people.stream()
                .map(person -> person.name)
                .collect(Collectors.toSet())
                .forEach(name -> log.info(String.valueOf(name)));

        // Show name lengths
        people.stream()
                .map(person -> person.name)
                .mapToInt(name -> name.length())
                .forEach(name -> log.info(String.valueOf(name)));

        // Alternative
        log.info("-----------------------------------------------------------");
        Function<Person, String> personStringFunction = person -> person.name;
        ToIntFunction<String> stringToIntFunction = name -> name.length();
        IntConsumer println = System.out::println;
        log.info("-----------------------------------------------------------");

        people.stream()
                .map(personStringFunction)
                .mapToInt(stringToIntFunction)
                .forEach(println);


        // Expanded from above
        people.stream()
                .map(person -> person.name)
                .mapToInt(name -> name.length())
                .forEach(name -> log.info(String.valueOf(name)));

        //Alternative
        people.stream()
                .map(person -> person.name)
                .mapToInt(String::length)
                .forEach((item) -> log.info(String.valueOf(item)));

        // Matching
        boolean containsOnlyFemale = people.stream()
                .allMatch(person -> FEMALE.equals(person.gender));
        log.info("Only Females: "+containsOnlyFemale);

        containsOnlyFemale = people.stream()
                .anyMatch(person -> FEMALE.equals(person.gender));
        log.info("Only Females: "+containsOnlyFemale);


    }


    @Data
    @AllArgsConstructor
    static class Person {
        private final String name;
        private final Gender gender;
    }

    enum Gender {
        MALE, FEMALE, PREFER_NOT_TO_SAY
    }
}
