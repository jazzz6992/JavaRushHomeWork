package com.javarush.test.level19.lesson10.home09;

/* Контекстная реклама
В методе main подмените объект System.out написанной вами реадер-оберткой
Ваша реадер-обертка должна выводить на консоль контекстную рекламу после каждого второго println-а
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Рекламный текст: "JavaRush - курсы Java онлайн"

Пример вывода:
first
second
JavaRush - курсы Java онлайн
third
fourth
JavaRush - курсы Java онлайн
fifth
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
        String s = new String(baos.toByteArray());
        StringBuilder sb= new StringBuilder();
        int idxS = 0;
        int idxF = 0;
        int counter = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '\n') {
                counter++;
                if (counter == 2) {
                    counter = 0;
                    idxF = i + 1;
                    String tmp = s.substring(idxS, idxF);
                    sb.append(tmp);
                    sb.append("JavaRush - курсы Java онлайн\n");
                    idxS = idxF;
                }else {
                    idxF = i + 1;
                    String tmp = s.substring(idxS, idxF);
                    sb.append(tmp);
                    idxS = idxF;
                }
            }
        }
        s = sb.toString();
        System.setOut(console);
        System.out.println(s);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
