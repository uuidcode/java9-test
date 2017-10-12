package com.github.uuidcode.mp;

import static com.google.common.base.CaseFormat.LOWER_CAMEL;
import static com.google.common.base.CaseFormat.LOWER_UNDERSCORE;

import org.apache.commons.lang3.StringUtils;

import com.google.gson.Gson;

public class HelloModulePath {
    private String name = "Hi";

    public String getName() {
        return this.name;
    }

    public HelloModulePath setName(String name) {
        this.name = name;
        return this;
    }
    public static void main(String[] args) {
        System.out.println(StringUtils.wrap("Hello, Module Path", "'"));
        System.out.println(LOWER_UNDERSCORE.to(LOWER_CAMEL, "module_path"));
        System.out.println(Gson.class.getModule());
        System.out.println(String.class.getModule());
    }
}
