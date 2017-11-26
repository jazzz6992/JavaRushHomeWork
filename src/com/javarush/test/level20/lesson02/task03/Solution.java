package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.*;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();
        Properties myProp = new Properties();
        myProp.load(new FileInputStream(file));
        Enumeration e = myProp.propertyNames();
        while (e.hasMoreElements()) {
            String key = (String) e.nextElement();
            properties.put(key, myProp.getProperty(key));
        }

    }

    public void save(OutputStream outputStream) throws Exception {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
        Properties myProp = new Properties();
        myProp.putAll(properties);
        myProp.store(writer, null);
        writer.close();
    }


    public void load(InputStream inputStream) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        Properties myProp = new Properties();
        myProp.load(reader);
        Set<String> set = myProp.stringPropertyNames();
        for (String s : set) {
            properties.put(s, myProp.getProperty(s));
        }
        reader.close();
    }
}
