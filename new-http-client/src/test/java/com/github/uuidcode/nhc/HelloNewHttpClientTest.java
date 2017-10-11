package com.github.uuidcode.nhc;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URI;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;

public class HelloNewHttpClientTest {
    protected static Logger logger = LoggerFactory.getLogger(HelloNewHttpClientTest.class);

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
