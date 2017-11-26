package com.javarush.test.level22.lesson09.task01;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        reader.close();
        FileInputStream fis = new FileInputStream(name);
        int aval = fis.available();
        byte[] buf = new byte[aval];
        fis.read(buf);
        fis.close();
        String text = new String(buf);
        text = text.replace("\n", " ");
        StringBuilder sb;
        String[] words = text.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i] != null) {
                for (int j = i + 1; j < words.length; j++) {
                    if (words[j] != null) {
                        sb = new StringBuilder(words[j]);
                        sb.reverse();
                        if (words[i].equals(sb.toString())) {
                            Pair pair = new Pair();
                            pair.first = words[i];
                            pair.second = words[j];
                            result.add(pair);
                            words[i] = null;
                            words[j] = null;
                            break;
                        }
                    }
                }
            }
        }
        for (Pair pair :
                result) {
            System.out.println(pair);
        }
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null && second != null ? second :
                            second == null && first != null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
