package com.javarush.test.level19.lesson08.task02;

/* Ридер обертка 2
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна заменять все подстроки "te" на "??"
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток
Вывести модифицированную строку в консоль.
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream myPS = new PrintStream(baos);
        System.setOut(myPS);
        testString.printSomething();
        String s = baos.toString();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        while (i < s.length()) {
            int x = s.substring(j).indexOf("te");
            if (x == -1) {
                i = s.length();
            } else {
                i += x;
            }
            sb.append(s.substring(j, i));
            if (i < s.length()) {
                sb.append("??");
            } else {
                break;
            }

            i+=2;
            j = i;

        }
        s = sb.toString();
        System.setOut(console);
        System.out.println(s);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("ates");
    }
    }
}
