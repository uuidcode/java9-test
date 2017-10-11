package com.github.uuidcode.cfm;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloCollectionFactoryMethodTest {
    protected static Logger logger = LoggerFactory.getLogger(HelloCollectionFactoryMethodTest.class);

    @Test
    public void collectionFactoryMethod() {
        List<String> emptyImmutableList = List.of();
        Set<String> emptyImmutableSet = Set.of();

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
