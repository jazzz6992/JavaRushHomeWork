package com.javarush.test.level06.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 5 чисел и выводит их в возрастающем порядке.
Пример ввода:
3
2
15
6
17
Пример вывода:
2
3
6
15
17
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        makeArr();
    }

    public static void makeArr() throws IOException {
        int[] arr = new int[5];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = giveNumber();
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                int min = arr[j];
                if (arr[j] > arr[j + 1]) {
                    min = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = min;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static int giveNumber() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int i;
        try {
            i = Integer.parseInt(reader.readLine());
        } catch (NumberFormatException e) {
            System.out.println("Input a number");
            return giveNumber();
        }
        return i;
    }
}
