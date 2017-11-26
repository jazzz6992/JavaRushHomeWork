package com.javarush.test.level22.lesson05.task02;

/* Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null) {
            throw new TooShortStringException();
        }
        int indOfTab = string.indexOf('\t');
        if (indOfTab == -1) {
            throw new TooShortStringException();
        } else {
            try {
                String tmp = string.substring(indOfTab + 1);
                indOfTab = tmp.indexOf("\t");
                if (indOfTab == -1) {
                    throw new TooShortStringException();
                } else {
                    tmp = tmp.substring(0, indOfTab);
                    return tmp;
                }
            } catch (IndexOutOfBoundsException ex) {
                throw new TooShortStringException();
            }
        }

    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
//        System.out.println(getPartOfString("tab0\ttab\ttab1\t"));       //tab
//        System.out.println(getPartOfString("\t\t"));                    //
//        System.out.println(getPartOfString("123\t123"));                //Exception
        System.out.println(getPartOfString(null));                      //Exception
    }
}
