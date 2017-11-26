package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int i1 = Integer.parseInt(reader.readLine());
        int i2 = Integer.parseInt(reader.readLine());
        int i3 = Integer.parseInt(reader.readLine());
        int max;
        int[] ar = {i1, i2, i3};
        for (int i = 0; i < ar.length - 1; i++) {
            for (int j = 0; j < ar.length - 1; j++) {
                max = ar[j];
                if (max < ar[j + 1]) {
                    ar[j] = ar[j + 1];
                    ar[j+1] = max;
                }
            }
        }
        for (int i = 0; i < ar.length; i++) {
            System.out.print(ar[i] + " ");
        }


    }
}
