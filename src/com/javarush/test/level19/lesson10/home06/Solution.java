package com.javarush.test.level19.lesson10.home06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* Замена чисел
1. В статическом блоке инициализировать словарь map парами [число-слово] от 0 до 12 включительно
Например, 0 - "ноль", 1 - "один", 2 - "два"
2. Считать с консоли имя файла
3. Заменить все числа на слова используя словарь map
4. Результат вывести на экран
5. Закрыть потоки. Не использовать try-with-resources

Пример данных:
Это стоит 1 бакс, а вот это - 12 .
Переменная имеет имя file1.
110 - это число.

Пример вывода:
Это стоит один бакс, а вот это - двенадцать .
Переменная имеет имя file1.
110 - это число.
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одинадцать");
        map.put(12, "двенадцать");

    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        reader = new BufferedReader(new FileReader(s));
        s = null;
        Set<String> stringSet = new HashSet<>();
        stringSet.add("0");
        stringSet.add("1");
        stringSet.add("2");
        stringSet.add("3");
        stringSet.add("4");
        stringSet.add("5");
        stringSet.add("6");
        stringSet.add("7");
        stringSet.add("8");
        stringSet.add("9");
        stringSet.add("10");
        stringSet.add("11");
        stringSet.add("12");
        while ((s = reader.readLine()) != null) {
            StringBuilder sb = new StringBuilder();
            String[] strings = s.split(" ");
            for (int i = 0; i < strings.length; i++) {
                if (i < strings.length - 1) {
                    if (stringSet.contains(strings[i])) {
                        sb.append(map.get(Integer.parseInt(strings[i])) + " ");
                    } else {
                        sb.append(strings[i] + " ");
                    }
                } else {
                    if (stringSet.contains(strings[i])) {
                        sb.append(map.get(Integer.parseInt(strings[i])));
                    } else {
                        sb.append(strings[i]);
                    }
                }

            }
            System.out.println(sb.toString());
        }
    }
}
