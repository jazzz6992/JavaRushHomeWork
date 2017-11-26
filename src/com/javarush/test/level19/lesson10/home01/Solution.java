package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
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
        while ((s = reader.readLine()) != null) {
            String[] strings = s.split(" ");
            if (map.containsKey(strings[0])) {
                map.put(strings[0], map.get(strings[0]) + Double.parseDouble(strings[1]));
            } else {
                map.put(strings[0], Double.parseDouble(strings[1]));
            }
        }
        ArrayList<String> list = new ArrayList<>();
        for (Map.Entry<String, Double> pair : map.entrySet()) {
            list.add(pair.getKey() + " " + pair.getValue());
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = list.size() - 1; j > 0 + i; j--) {
                if (list.get(j).compareTo(list.get(j-1)) < 0) {
                    String tmp = list.get(j);
                    list.set(j, list.get(j-1));
                    list.set(j-1, tmp);
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        reader.close();
    }
}
