package com.javarush.test.level04.lesson04.task06;

/* День недели
Ввести с клавиатуры номер дня недели, в зависимости от номера вывести название «понедельник», «вторник», «среда», «четверг», «пятница», «суббота», «воскресенье»,
если введен номер больше или меньше 7 – вывести «такого дня недели не существует».
Пример для номера 5:
пятница
Пример для номера 10:
такого дня недели не существует
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int day;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        day = Integer.parseInt(reader.readLine());
        if (day == 1) {
            System.out.println("понедельник");
        }
        if (day == 2) {
            System.out.println("вторник");
        }
        if (day == 3) {
            System.out.println("среда");
        }
        if (day == 4) {
            System.out.println("четверг");
        }
        if (day == 5) {
            System.out.println("пятница");
        }
        if (day == 6) {
            System.out.println("суббота");
        }
        if (day == 7) {
            System.out.println("воскресенье");
        }
        if (day < 1 || day > 7) {
            System.out.println("такого дня недели не существует");
        }

    }

}