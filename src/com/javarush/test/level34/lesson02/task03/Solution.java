package com.javarush.test.level34.lesson02.task03;

/* Разложение на множители с помощью рекурсии
Разложить целое число n > 1 на простые множители.
Вывести в консоль через пробел все множители в порядке возрастания.
Написать рекуррентный метод для вычисления простых множителей.
Не создавайте статические переменные и поля класса.
Пример:
132
Вывод на консоль:
2 2 3 11
*/
public class Solution {
    public void recursion(int n) {
        if (n <= 1) {
            return;
        }
        for (int i = 2; i < Integer.MAX_VALUE; i++) {
            if (n % i == 0) {
                System.out.println(i);
                recursion(n / i);
                break;
            }
        }
    }
}
