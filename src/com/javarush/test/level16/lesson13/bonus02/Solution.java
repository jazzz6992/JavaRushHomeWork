package com.javarush.test.level16.lesson13.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Клубок
1. Создай 5 различных своих нитей c отличным от Thread типом:
1.1. нить 1 должна бесконечно выполняться;
1.2. нить 2 должна выводить "InterruptedException" при возникновении исключения InterruptedException;
1.3. нить 3 должна каждые полсекунды выводить "Ура";
1.4. нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
1.5. нить 5 должна читать с консоли цифры пока не введено слово "N", а потом вывести в консоль сумму введенных цифр.
2. В статическом блоке добавь свои нити в List<Thread> threads в перечисленном порядке.
3. Нити не должны стартовать автоматически.
Подсказка: Нить 4 можно проверить методом isAlive()
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<Thread>(5);

    static {
        threads.add(new InfinityThread());
        threads.add(new ExceptionThread());
        threads.add(new HailThread());
        threads.add(new WarningThread());
        threads.add(new SumThread());
    }

    public static class InfinityThread extends Thread {
        @Override
        public void run() {
            while (true) {

            }
        }
    }

    public static class ExceptionThread extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    System.out.println("InterruptedException");
                }
            }
        }
    }

    public static class HailThread extends Thread {
        @Override
        public void run() {
            while (!this.isInterrupted()) {
                System.out.println("Ура");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    break;
                }
            }
        }
    }

    public static class WarningThread extends Thread implements Message {
        @Override
        public void showWarning() {
            this.interrupt();
            try {
                this.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        @Override
        public void run() {
            while (!this.isInterrupted()) {

            }
        }
    }

    public static class SumThread extends Thread {
        String word = "N";
        String tmp;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();

        @Override
        public void run() {
            try {
                while (!(tmp = reader.readLine()).equals(word)) {
                    try {
                        list.add(Integer.parseInt(tmp));
                    } catch (NumberFormatException ex) {

                    }
                }
                int sum = 0;
                for (int i = 0; i < list.size(); i++) {
                    sum += list.get(i);
                }
                System.out.println(sum);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
