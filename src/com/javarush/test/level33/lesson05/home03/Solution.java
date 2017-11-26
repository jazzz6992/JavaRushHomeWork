package com.javarush.test.level33.lesson05.home03;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

/* Десериализация JSON объекта
НЕОБХОДИМО: подключенные библиотеки Jackson Core, Bind и Annotation версии 2.6.1

В метод convertFromJsonToNormal первым параметром приходит имя файла, который содержит один ДЖЕЙСОН объект.
Вторым параметром приходит имя класса, объект которого находится в файле.
Метод convertFromJsonToNormal должен вычитать объект из файла, преобразовать его из JSON и вернуть его.
*/
public class Solution {

    public static <T> T convertFromJsonToNormal(String fileName, Class<T> clazz) throws IOException {
        FileInputStream fis = new FileInputStream(fileName);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        while (fis.available() > 0) {
            byte[] buf = new byte[1024];
            int count = fis.read(buf);
            baos.write(buf, 0, count);
        }
        String json = new String(baos.toByteArray());
        StringReader stringReader = new StringReader(json);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(stringReader, clazz);

    }
}
