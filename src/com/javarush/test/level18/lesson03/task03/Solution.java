package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(reader.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        while (fis.available() > 0) {
            int tmp = fis.read();
            if (map.containsKey(tmp)) {
                map.put(tmp, map.get(tmp) + 1);
                if (map.get(tmp) > max) {
                    max = map.get(tmp);
                }
            } else {
                map.put(tmp, 0);
            }
        }
        fis.close();


        for (Map.Entry<Integer,Integer> pair :
                map.entrySet()) {
            if (pair.getValue() == max) {
                System.out.print(pair.getKey());
            }
        }

    }
}
