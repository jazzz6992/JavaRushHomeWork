package com.javarush.test.level04.lesson04.task10;

/* Три числа
Ввести с клавиатуры три целых числа. Определить, имеется ли среди них хотя бы одна пара равных между собой чисел.
Если такая пара существует, вывести на экран числа через пробел. Если все три числа равны между собой, то вывести все три.
Пример для чисел 1 2 2:
2 2
Пример для чисел 2 2 2:
2 2 2
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int i1;
        int i2;
        int i3;
        i1 = Integer.parseInt(reader.readLine());
        i2 = Integer.parseInt(reader.readLine());
        i3 = Integer.parseInt(reader.readLine());
//        try {
//            i1 = Integer.parseInt(reader.readLine());
//            i2 = Integer.parseInt(reader.readLine());
//            i3 = Integer.parseInt(reader.readLine());
//        } catch (NumberFormatException ex) {
//            System.err.println("Введите число");
//        }
        if (i1 == i2 && i2 == i3) {
            System.out.println(i1 + " " + i2 + " " + i3);
        } else {
            if (i1 == i2) {
                System.out.println(i1 + " " + i2);
            } else if (i2 == i3) {
                System.out.println(i2 + " " + i3);
            } else if (i1 == i3) {
                System.out.println(i1 + " " + i3);
            }
        }
    }
}