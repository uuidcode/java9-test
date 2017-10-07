package com.github.uuidcode.java9.test.pa;

import org.junit.Test;

public class Testing {
    protected static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(Testing.class);

    @Test
    public void test() {
        ProcessHandle.allProcesses()
            .filter(p -> p.info().command().orElse("").contains("chrome"))
            .forEach(p -> {
                if (logger.isDebugEnabled()) {
                    logger.debug(">>> pid: {}", p.pid());
                    logger.debug(">>> command: {}", p.info().command());
                    logger.debug(">>> startInstant: {}", p.info().startInstant());
                }
            });
    }
}
