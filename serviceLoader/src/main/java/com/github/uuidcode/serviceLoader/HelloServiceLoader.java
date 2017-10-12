package com.github.uuidcode.serviceLoader;

import java.nio.file.spi.FileSystemProvider;
import java.util.ServiceLoader;

public class HelloServiceLoader {
    public static void main(String[] args){
        ServiceLoader<FileSystemProvider> fileSystemProviders =
            ServiceLoader.load(FileSystemProvider.class);

        for (FileSystemProvider fileSystemProvider : fileSystemProviders) {
            System.out.println(fileSystemProvider);
        }
    }
}
