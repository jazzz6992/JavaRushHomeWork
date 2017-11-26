package com.javarush.test.level04.lesson06.task02;

/* Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
*/

import java.io.*;

public class Solution {
    public static int max(int a, int b) {
        if (a < b) {
            return b;
        } else {
            return a;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int i1 = Integer.parseInt(reader.readLine());
        int i2 = Integer.parseInt(reader.readLine());
        int i3 = Integer.parseInt(reader.readLine());
        int i4 = Integer.parseInt(reader.readLine());
        if (max(i1, i2) > max(i3, i4)) {
            System.out.println(max(i1, i2));
        } else {
            System.out.println(max(i3, i4));
        }

    }
}
