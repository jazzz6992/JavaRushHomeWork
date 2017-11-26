package com.javarush.test.level32.lesson04.home01;

import java.io.*;

/* Читаем из потока
Реализуйте логику метода getAllDataFromInputStream. Он должен вернуть StringWriter, содержащий все данные из переданного потока.
Возвращаемый объект ни при каких условиях не должен быть null.
Метод main не участвует в тестировании.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("/Users/vsevolodvisnevskij/IdeaProjects/JavaRushHomeWork/JavaRushHomeWork/.idea/codeStyleSettings.xml"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        StringWriter writer = new StringWriter();
        if (is != null) {
            while (is.available() > 0) {
                byte[] buf = new byte[1024];
                int count = is.read(buf);
                writer.write(new String(buf), 0, count);
            }
            is.close();
        }
        writer.close();
        return writer;
    }
}
