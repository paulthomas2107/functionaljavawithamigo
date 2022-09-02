package com.amigoscode.functionalinterfaces;

import lombok.extern.java.Log;

import java.util.List;
import java.util.function.Supplier;

@Log
public class _Supplier {

    public static void main(String[] args) {

        log.info(getDBConnectionURL());
        log.info(getDBConnectionURLSupplier.get());

        for (String url : getDBConnectionURLSupplierList.get()) {
            log.info(url);
        }

        // Same as above....better
        getDBConnectionURLSupplierList.get().forEach(url -> {
            log.info(url);
        });

    }

    static String getDBConnectionURL() {
        return "jdbc://localost:5432/users";
    }

    static Supplier<String> getDBConnectionURLSupplier = () -> "jdbc://localost:5432/users";

    static Supplier<List<String>> getDBConnectionURLSupplierList = ()
            -> List.of("jdbc://localost:5432/users", "jdbc://localost:8080/login");


    }


