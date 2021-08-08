package com.java.week1;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HelloClassLoader extends ClassLoader{
    public static void main(String[] args) {
        try {
            Class<?> helloClass = new HelloClassLoader().findClass("Hello");
            Method helloMethod = helloClass.getMethod("hello");
            helloMethod.invoke(helloClass.getDeclaredConstructor().newInstance());
        } catch (ClassNotFoundException | NoSuchMethodException
                | IllegalAccessException | InstantiationException
                | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Path path = Paths.get("week1-jvm-and-gc//com//java//week1//Hello.xlass");
        byte[] rawBytes = new byte[0];

        try {
            rawBytes = Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        byte[] targetBytes = decode(rawBytes);

        return defineClass(name, targetBytes, 0, targetBytes.length);

    }

    private static byte[] decode(byte[] listOfBytes) {
        byte[] targetList = new byte[listOfBytes.length];
        for (int i = 0; i < listOfBytes.length; i++) {
            targetList[i] = (byte) (255 - listOfBytes[i]);
        }

        return targetList;
    }

}
