package com.javarush.test.level04.lesson06.task07;

/* Три числа
Ввести с клавиатуры три целых числа. Одно из чисел отлично от двух других, равных между собой.
Вывести на экран порядковый номер числа, отличного от остальных.
Пример для чисел 4 6 6:
1
Пример для чисел 6 6 3:
3
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a1 = Integer.parseInt(reader.readLine());
        int a2 = Integer.parseInt(reader.readLine());
        int a3 = Integer.parseInt(reader.readLine());
        if (a2 == a3 && a2 != a1) {
            System.out.println(1);
        } else if (a1 == a3 && a1 != a2) {
            System.out.println(2);
        } else if (a1 == a2 && a1 != a3){
            System.out.println(3);
        }
    }
}
