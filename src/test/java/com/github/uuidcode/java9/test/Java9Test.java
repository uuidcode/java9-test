package com.github.uuidcode.java9.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;

public class Java9Test {
    protected static Logger logger = LoggerFactory.getLogger(Java9Test.class);

    @Test
    public void processHandler() {
        ProcessHandle.allProcesses()
            .filter(p -> p.info().command().orElse("").contains("java"))
            .forEach(p -> {
                if (logger.isDebugEnabled()) {
                    logger.debug(">>> pid: {}", p.pid());
                    logger.debug(">>> command: {}", p.info().command());
                    logger.debug(">>> startInstant: {}", p.info().startInstant());
                }
            });
    }

    @Test
    public void collectionFactoryMethod() {
        List<String> immutableList = List.of("one", "two");
        Set<String> immutableSet = Set.of("one", "two");
        Map<String, String> immutableMap = Map.of("one", "1", "two", "2");

        if (logger.isDebugEnabled()) {
            logger.debug(">>> immutableMap: {}", immutableMap);
        }

        assertThat(immutableMap.size()).isGreaterThan(0);
    }

    @Test
    public void qna() {
        char Q = 'Q';
        char N = 'N';

        if (logger.isDebugEnabled()) {
            logger.debug(">>> Q & N {}", Q & N);
        }
    }

    @Test
    public void lang() {
        String lang = "java kotlin python";
        List<String> langList = Arrays.asList(lang.split(" "));

        assertThat(langList.size()).isEqualTo(3);
        assertThat(langList.get(0)).isEqualTo("java");
        assertThat(langList.get(1)).isEqualTo("kotlin");
        assertThat(langList.get(2)).isEqualTo("python");
    }
}
