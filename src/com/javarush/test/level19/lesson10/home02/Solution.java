package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Solution {
    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        Map<String, Double> map = new HashMap<>();
        String s;
        String[] strings;
        double d;
        double max = 0;
        ArrayList<String> list = new ArrayList<>();
        while ((s = reader.readLine()) != null) {
            strings = s.split(" ");
            if (map.containsKey(strings[0])) {
                d = map.get(strings[0]) + Double.parseDouble(strings[1]);
                map.put(strings[0], d);
            } else {
                d = Double.parseDouble(strings[1]);
                map.put(strings[0], d);
            }
            if (d> max) {
                max = d;
                list.clear();
                list.add(strings[0]);
            } else if (d == max) {
                list.add(strings[0]);
            }
//            for (int i = 0; i < list.size(); i++) {
//                System.out.print(list.get(i) + " ");
//            }
//            System.out.println();
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        reader.close();

    }
}
