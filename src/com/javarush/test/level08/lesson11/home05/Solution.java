package com.javarush.test.level08.lesson11.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
  мама     мыла раму.

Пример вывода:
  Мама     Мыла Раму.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();


//        String[] arr = s.split(" ");
//        s = "";
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = arr[i].replaceFirst(arr[i].valueOf(arr[i].charAt(0)), arr[i].valueOf(arr[i].charAt(0)).toUpperCase());
//            if (i == arr.length - 1) {
//                s += arr[i];
//            } else {
//                s += arr[i] + " ";
//            }
//
//        }


        char[] arr2 = s.toCharArray();
        for (int i = 0; i < arr2.length - 1; i++) {
            if (i == 0) {
                arr2[i] = Character.toUpperCase(arr2[i]);
            }
            if (arr2[i] == ' ') {
                arr2[i + 1] = Character.toUpperCase(arr2[i + 1]);
            }
        }
        s = String.valueOf(arr2);

        System.out.println(s);
    }
}
