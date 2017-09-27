package com.github.uuidcode.java9.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URI;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;

public class Java9Test {
    protected static Logger logger = LoggerFactory.getLogger(Java9Test.class);

    @Test
    public void test() throws Exception {
        HttpRequest httpRequest = HttpRequest.newBuilder()
            .uri(new URI("http://deployable.devel.kakao.com/api/json/info"))
            .GET()
            .build();

        String content = HttpClient.newHttpClient()
            .send(httpRequest, HttpResponse.BodyHandler.asString())
            .body();

        if (logger.isDebugEnabled()) {
            logger.debug(">>> test content: {}", content);
        }

        assertThat(content).isNotNull();
    }
}
