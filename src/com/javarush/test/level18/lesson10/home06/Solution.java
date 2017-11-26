package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(args[0]);
        Map<Integer, Integer> map = new HashMap<>();
        while (fis.available() > 0) {
            int tmp = fis.read();
            if (map.containsKey(tmp)) {
                map.put(tmp, map.get(tmp) + 1);
            } else {
                map.put(tmp, 1);
            }
        }
        for (int i = 0; i < 255; i++) {
            if (map.containsKey(i)) {
                System.out.println((char) i + " " + map.get(i));
            }
        }
fis.close();
    }
}
