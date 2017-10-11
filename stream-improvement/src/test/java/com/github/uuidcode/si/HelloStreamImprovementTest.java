package com.github.uuidcode.si;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;

public class HelloStreamImprovementTest {
    @Test
    public void flapMap() {
        final String configurationDirectory =
            Stream.of("app.config", "app.home", "user.home")
                .flatMap(key -> {
                    final String property = System.getProperty(key);

                    if (property == null) {
                        return Stream.empty();
                    } else {
                        return Stream.of(property);
                    }
                })
                .findFirst()
                .orElseThrow(IllegalStateException::new);

        System.out.println(configurationDirectory);
    }

    @Test
    public void ofNullable() {
        final String configurationDirectory =
            Stream.of("app.config", "app.home", "user.home")
                .flatMap(key -> Stream.ofNullable(System.getProperty(key)))
                .findFirst()
                .orElseThrow(IllegalStateException::new);

        System.out.println(configurationDirectory);
    }

    @Test
    public void filter() {
        IntStream.range(1, 20)
            .filter(i -> i < 10)
            .forEach(System.out::println);
    }

    @Test
    public void takeWhile() {
        IntStream.range(1, 20)
            .takeWhile(i -> i < 10)
            .forEach(System.out::println);
    }

    @Test
    public void dropWhile() {
        IntStream.range(1, 20)
            .dropWhile(i -> i < 10)
            .forEach(System.out::println);
    }

    @Test
    public void iterate8() {
        IntStream.iterate(3, x -> x + 3)
            .filter(x -> x < 100)
            .forEach(System.out::println);
    }

    @Test
    public void iterate9() {
        IntStream.iterate(3, x -> x < 100, x -> x + 3)
            .forEach(System.out::println);
    }
}
