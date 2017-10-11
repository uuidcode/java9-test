#!/usr/bin/env bash
javac -d \
../mod/com.github.uuidcode.jlink \
../src/main/java/com/github/uuidcode/jlink/HelloJLink.java \
../src/main/java/module-info.java

jlink --module-path \
$JAVA_HOME/jmods:\
../mod \
--add-modules \
com.github.uuidcode.jlink \
--launcher run=com.github.uuidcode.jlink/com.github.uuidcode.jlink.HelloJLink \
--output \
../dist