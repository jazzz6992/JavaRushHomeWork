package com.javarush.test.level12.lesson04.task05;

/* Три метода возвращают максимальное из двух переданных в него чисел
Написать public static методы: int max(int, int), long max (long, long), double max (double, double).
Каждый метод должен возвращать максимальное из двух переданных в него чисел.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static int max(int x, int z) {
        if (x > z) {
            return x;
        } else {
            return z;
        }
    }

    public static long max(long x, long z) {
        if (x > z) {
            return x;
        } else {
            return z;
        }
    }

    public static double max(double x, double z) {
        if (x > z) {
            return x;
        } else {
            return z;
        }
    }
}
