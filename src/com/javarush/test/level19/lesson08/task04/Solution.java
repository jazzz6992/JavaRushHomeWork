package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream myPS = new PrintStream(baos);
        System.setOut(myPS);
        testString.printSomething();
        String s = new String(baos.toByteArray());
        Scanner scanner = new Scanner(s);
        ArrayList<Integer> listInt = new ArrayList<>();
        String[] arr = s.split(" ");
        int a = Integer.parseInt(arr[0]);
        int b = Integer.parseInt(arr[2]);
        char c = arr[1].charAt(0);
        Integer result = 0;
        if (c == '+') {
            result = a + b;
        } else if (c == '-') {
            result = a - b;
        } else if (c == '/') {
            result = a / b;
        } else if (c == '*') {
            result = a * b;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.insert(s.lastIndexOf(" ") + 1, result.toString());
        s = sb.toString();
        System.setOut(console);
        System.out.println(s);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 / 6 = ");
        }
    }
}

