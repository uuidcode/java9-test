package com.github.uuidcode.java9.test;

import org.junit.Test;

public class ModuleTest {
    @Test
    public void module() {
        String nameAndVersion = String.class.getModule().getDescriptor().toNameAndVersion();
        System.out.println(nameAndVersion);
    }
}
