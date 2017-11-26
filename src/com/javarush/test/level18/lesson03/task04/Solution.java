package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(reader.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        while (fis.available() > 0) {
            int tmp = fis.read();
            if (map.containsKey(tmp)) {
                map.put(tmp, map.get(tmp) + 1);
            } else {
                map.put(tmp, 1);
            }
        }
        for (Map.Entry<Integer, Integer> pair :
                map.entrySet()) {
            if (pair.getValue() < min) {
                min = pair.getValue();
            }
        }
        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            if (pair.getValue() == min) {
                System.out.print(pair.getKey() + " ");
            }
        }


    }
}
