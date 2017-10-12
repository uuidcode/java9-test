package com.github.uuidcode.mt;

import java.lang.reflect.Field;

import com.github.uuidcode.mp.HelloModulePath;

public class HelloModuleTest {
    public static void main(String[] args) throws Exception {
        HelloModulePath helloModulePath = new HelloModulePath();
        Field field = HelloModulePath.class.getDeclaredField("name");
        field.setAccessible(true);
        Object value = field.get(helloModulePath);
        System.out.println(helloModulePath);
        System.out.println(value);
    }
}
