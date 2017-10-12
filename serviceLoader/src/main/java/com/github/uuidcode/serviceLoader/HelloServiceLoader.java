package com.github.uuidcode.serviceLoader;

import java.sql.Driver;
import java.util.ServiceLoader;

public class HelloServiceLoader {
    public static void main(String[] args) throws Exception {
        ServiceLoader<Driver> driverServiceLoader =
            ServiceLoader.load(Driver.class);

        for (Driver driver : driverServiceLoader) {
            System.out.println(driver);
        }
    }
}
