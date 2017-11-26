package com.javarush.test.level08.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Задача: Введи с клавиатуры 20 слов и выведи их в алфавитном порядке.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] array = new String[20];
        for (int i = 0; i < array.length; i++)
        {
            array[i] = reader.readLine();
        }

        sort(array);

        for (String x : array)
        {
            System.out.println(x);
        }
    }

    public static void sort(String[] array)
    {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                String compared;
                if (array[j].length() > array[j+1].length()) {
                    for (int k = 0; k < array[j+1].length(); k++) {
                        if (array[j+1].charAt(k) < array[j].charAt(k)) {
                            compared = array[j];
                            array[j] = array[j+1];
                            array[j+1] = compared;
                            break;
                        } else if (array[j+1].charAt(k) > array[j].charAt(k)) {
                            break;
                        }
                        if (k == array[j+1].length()-1) {
                            compared = array[j];
                            array[j] = array[j+1];
                            array[j+1] = compared;
                            break;
                        }
                    }
                } else {
                    for (int k = 0; k < array[j].length(); k++) {
                        if (array[j].charAt(k) > array[j+1].charAt(k)) {
                            compared = array[j+1];
                            array[j+1] = array[j];
                            array[j] = compared;
                            break;
                        } else if (array[j].charAt(k) < array[j+1].charAt(k)) {
                            break;
                        }
                    }
                }
            }
        }
    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b)
    {
        return a.compareTo(b) > 0;
    }
}
