package com.javarush.test.level09.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Задача по алгоритмам
Задача: Пользователь вводит с клавиатуры список слов (и чисел). Слова вывести в возрастающем порядке, числа - в убывающем.
Пример ввода:
Вишня
1
Боб
3
Яблоко
2
0
Арбуз
Пример вывода:
Арбуз
3
Боб
2
Вишня
1
0
Яблоко
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (isNumber(array[j])) {
                    for (int k = j + 1; k < array.length; k++) {
                        if (isNumber(array[k])) {
                            if (Integer.parseInt(array[j]) < Integer.parseInt(array[k])) {
                                String tmp = array[k];
                                array[k] = array[j];
                                array[j] = tmp;
                            }
                        }
                    }
                } else  {
                    for (int k = j + 1; k < array.length; k++) {
                        if (!isNumber(array[k])) {
                            if (array[j].length() > array[k].length()) {
                                for (int l = 0; l < array[k].length(); l++) {
                                    if (array[j].charAt(l) > array[k].charAt(l)) {
                                        String tmp = array[k];
                                        array[k] = array[j];
                                        array[j] = tmp;
                                        break;
                                    } else if (array[j].charAt(l) < array[k].charAt(l)) {
                                        break;
                                    }
                                    if (l == array[k].length() - 1) {
                                        String tmp = array[k];
                                        array[k] = array[j];
                                        array[j] = tmp;
                                        break;
                                    }
                                }
                            } else {
                                for (int l = 0; l < array[j].length(); l++) {
                                    if (array[j].charAt(l) > array[k].charAt(l)) {
                                        String tmp = array[k];
                                        array[k] = array[j];
                                        array[j] = tmp;
                                        break;
                                    } else if (array[j].charAt(l) < array[k].charAt(l)) {
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    //строка - это на самом деле число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') //есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-')) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }
}
