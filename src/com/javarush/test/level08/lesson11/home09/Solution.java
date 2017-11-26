package com.javarush.test.level08.lesson11.home09;

import java.util.Date;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Не забудьте учесть первый день года.
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(isDateOdd("JANUARY 1 2000"));
    }

    public static boolean isDateOdd(String date) {
        Date date1 = new Date(date);
        Date newYear = new Date(date);
        newYear.setSeconds(0);
        newYear.setMinutes(0);
        newYear.setHours(0);
        newYear.setDate(1);
        newYear.setMonth(0);
        long dif = date1.getTime() - newYear.getTime();
        int days = (int) (dif / 1000 / 60 / 60 / 24) + 1;
        if (days % 2 != 0) {
            return true;
        } else {
            return false;
        }

    }
}
