package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File file = new File(reader.readLine());
        reader.close();
        FileInputStream fis = new FileInputStream(file);
        byte[] buf = new byte[fis.available()];
        fis.read(buf);
        fis.close();
        String s = new String(buf);
        String[] words = s.split("\\W");
        int counter = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals("world")) {
                counter++;
            }
        }
        System.out.println(counter);
    }
}
