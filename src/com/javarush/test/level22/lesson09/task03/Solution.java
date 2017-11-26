package com.javarush.test.level22.lesson09.task03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        reader.close();
        BufferedReader reader1 = new BufferedReader(new FileReader(name));
        StringBuilder sb = new StringBuilder();
        while (reader1.ready()) {
            sb.append(reader1.readLine());
        }
        reader1.close();
        String text = sb.toString();
        text = text.replace('\n', ' ');
        String[] words = text.split(" ");

        //...
        StringBuilder result = getLine(words);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder sb = new StringBuilder();
        if (words == null || words.length == 0) {
            return sb;
        }

        ArrayList<String> list = new ArrayList<>();
        list.addAll(Arrays.asList(words));
        char last;
        if (list.size() > 0) {
            sb.append(list.get(0));
            last = list.get(0).toLowerCase().charAt(list.get(0).length() - 1);
            list.remove(0);
            boolean isFound = true;
            while (isFound) {
                isFound = false;
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).equals("") || list.get(i) == null) {
                        list.remove(i);
                        isFound = true;
                        break;
                    }
                    if (list.get(i).toLowerCase().charAt(0) == last) {
                        sb.append(" " + list.get(i));
                        last = list.get(i).toLowerCase().charAt(list.get(i).length() - 1);
                        list.remove(i);
                        isFound = true;
                        break;
                    } else if (Character.toLowerCase(sb.charAt(0)) == list.get(i).toLowerCase().charAt(list.get(i).length() - 1)) {
                        sb.insert(0, list.get(i) + " ");
                        list.remove(i);
                        isFound = true;
                        break;
                    }
                }
            }
        }
        return sb;
    }
}
