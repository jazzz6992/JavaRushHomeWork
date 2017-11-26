package com.javarush.test.level04.lesson16.home03;

import java.io.*;

/* Посчитать сумму чисел
Вводить с клавиатуры числа и считать их сумму. Если пользователь ввел -1, вывести на экран сумму и завершить программу.  -1 должно учитываться в сумме.
*/

public class Solution
{
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        boolean isOk = true;
        while (isOk) {
            int i =  Integer.parseInt(reader.readLine());
            sum += i;
            if (i == -1) {
                isOk = false;
            }
        }
        System.out.println(sum);
    }
}
