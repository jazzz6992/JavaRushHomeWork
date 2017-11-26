package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;




/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(reader.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        while (fis.available() > 0) {
            int tmp = fis.read();
            if (!list.contains(tmp)) {
                list.add(tmp);
            }
        }
        fis.close();
        for (int i = 0; i < list.size(); i++) {
            for (int j = list.size() - 1; j > 0 + i; j--) {
                if (list.get(j) < list.get(j - 1)) {
                    int tmp = list.get(j);
                    list.set(j, list.get(j - 1));
                    list.set(j - 1, tmp);
                }
            }
            System.out.print(list.get(i) + " ");
        }
    }
}
