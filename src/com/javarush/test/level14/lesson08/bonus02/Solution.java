package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(reader.readLine());
        int y = Integer.parseInt(reader.readLine());
        int min;
        int max;
        int maxD = 1;
        if (x < y) {
            min = x;
            max = y;
        } else {
            min = y;
            max = x;
        }
        for (int i = min; i > 0; i--) {
            if (x % i == 0 && y % i == 0) {
                maxD = i;
                break;
            }
        }
        System.out.println(maxD);
    }
}
