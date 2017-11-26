package com.javarush.test.level05.lesson12.bonus03;

import java.io.*;

/* Задача по алгоритмам
Написать программу, которая:
1. вводит с консоли число N > 0
2. потом вводит N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int maximum = max(makeArr());
        System.out.println("Maximum is " + maximum);
    }

    private static int max(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            if (max < arr[i + 1]) {
                max = arr[i + 1];
            }
        }
        return max;
    }

    private static int[] makeArr() throws IOException {
        try {
            System.out.println("Input arr length");
            int n = Integer.parseInt(getS());
            if (n > 0) {
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = makeNumber();
                }
                return arr;
            } else {
                System.err.println("number must be > 0");
                return makeArr();
            }
        } catch (NumberFormatException ex) {
            System.err.println("not a number");
            return makeArr();
        }
    }

    private static int makeNumber() throws IOException {
        try {
            System.out.println("Input a number");
            return Integer.parseInt(getS());
        } catch (Exception ex) {
            System.err.println("not a number");
            return makeNumber();
        }
    }

    private static String getS() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }
}