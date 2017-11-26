package com.javarush.test.level25.lesson09.task03;

import java.util.ArrayList;

/* Живем своим умом
В классе Solution реализуйте интерфейс UncaughtExceptionHandler, который должен:
1. прервать нить, которая бросила исключение.
2. вывести в консоль стек исключений начиная с самого вложенного.
Пример исключения: new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")))
Пример вывода:
java.lang.IllegalAccessException: GHI
java.lang.RuntimeException: DEF
java.lang.Exception: ABC
*/
public class Solution implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        while (e != null) {
            System.out.println(e.toString());
            e = e.getCause();
        }


    }
//
//    public static void main(String[] args) {
//        Thread t = new MyThread();
//        t.setUncaughtExceptionHandler(new Solution());
//        t.start();
//
//    }
//
//    public static class MyThread extends Thread {
//        @Override
//        public void run() {
//
//                throw new RuntimeException("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")));
//
//        }
//    }
}
