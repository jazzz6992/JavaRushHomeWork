package com.javarush.test.level20.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution {

    public static int[] getNumbers(int N) {
        ArrayList<Integer> ourNumbers = new ArrayList<>();
        for (int i = 1; i < N; i++) {
            char[] currentNumber = String.valueOf(i).toCharArray();
            boolean notNullEnding = true;
            for (int j = 0; j < currentNumber.length - 1; j++) {
                if (currentNumber[j] > currentNumber[j + 1]) {
                    if (currentNumber[j + 1] == '0') {
                        int checkForZeroIdx = j + 2;
                        boolean allIsZero = true;
                        while (checkForZeroIdx < currentNumber.length) {
                            if (currentNumber[checkForZeroIdx] != '0') {
                                allIsZero = false;
                                break;
                            } else {
                                checkForZeroIdx++;
                            }
                        }
                        if (allIsZero) {
                            notNullEnding = false;
                            try {
                                i = Integer.parseInt(String.copyValueOf(currentNumber));
                                ourNumbers.add(i);
                            } catch (NumberFormatException ex) {
                                break;
                            }
                            j++;
                            while (j < currentNumber.length) {
                                currentNumber[j] = currentNumber[j - 1];
                                try {
                                    i = Integer.parseInt(String.valueOf(currentNumber));
                                    ourNumbers.add(i);
                                } catch (NumberFormatException ex) {
                                    break;
                                }
                                j++;
                            }
                            break;
                        }
                    }
                    currentNumber[j + 1] = currentNumber[j];
                }
            }
            if (notNullEnding) {
                try {
                    i = Integer.parseInt(String.valueOf(currentNumber));
                    ourNumbers.add(i);
                } catch (NumberFormatException ex) {
                    break;
                }
            }
        }

        ArrayList<Integer> finalResult = new ArrayList<>();

        for (int i = 0; i < ourNumbers.size(); i++) {
            String toCheck = String.valueOf(ourNumbers.get(i));
            int length = toCheck.length();
            int result = 0;
            for (int j = 0; j < toCheck.length(); j++) {
                result += Math.pow(Character.getNumericValue(toCheck.charAt(j)), length);
            }
            String power = String.valueOf(result);
            int len = power.length();
            int isArmstrongs = 0;
            for (int j = 0; j < power.length(); j++) {
                isArmstrongs += Math.pow(Character.getNumericValue(power.charAt(j)), len);
            }
            if (result == isArmstrongs && isArmstrongs < N) {
                if (!finalResult.contains(result))
                    finalResult.add(result);
            }
        }

        for (int i = 0; i < finalResult.size(); i++) {
            boolean changed = false;
            for (int j = 0; j < finalResult.size() - i - 1; j++) {
                if (finalResult.get(j) > finalResult.get(j + 1)) {
                    changed = true;
                    int tmp = finalResult.get(j);
                    finalResult.set(j, finalResult.get(j + 1));
                    finalResult.set(j + 1, tmp);
                }
            }
            if (!changed) {
                break;
            }
        }

        int[] result = new int[finalResult.size()];

        for (int i = 0; i < finalResult.size(); i++) {
            result[i] = finalResult.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Date start = new Date();
        int x = Integer.parseInt(args[0]);
        int[] arr = getNumbers(x);
        Date finish = new Date();
        long time = finish.getTime() - start.getTime();
        System.out.println("quantity of digits = " + arr.length);
        System.out.println("***************");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("***************");
        System.out.println(time + "ms");

    }
}
