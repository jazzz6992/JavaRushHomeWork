package com.javarush.test.level14.lesson08.bonus01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;
import java.util.List;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            int[] arr = new int[10];
            System.out.println(arr[11]);
        } catch (ArrayIndexOutOfBoundsException ex) {
            exceptions.add(ex);
        }

        try {
            File file = null;
            FileInputStream fis = new FileInputStream(file);
        } catch (NullPointerException e) {
            exceptions.add(e);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            File file = new File("/Users/vsevolodvisnevskij/IdeaProjects/JavaRushHomeWork/JavaRushHomeWork/123");
            FileInputStream fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            exceptions.add(e);
        }

        try {
            Object o = new Integer(5);
            String s = (String) o;
        } catch (ClassCastException e) {
            exceptions.add(e);
        }

        try {
            int[] arr = new int[-1];
        } catch (NegativeArraySizeException e) {
            exceptions.add(e);
        }

        try {
            String s = "hi";
            int x = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            exceptions.add(e);
        }

        try {
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            exceptions.add(e);
        }

        try {
            throw new IllegalFormatCodePointException(1);
        } catch (IllegalFormatCodePointException e) {
            exceptions.add(e);
        }

        try {
            throw new IndexOutOfBoundsException();
        } catch (IndexOutOfBoundsException e) {
            exceptions.add(e);
        }

        try {
            throw new ArrayStoreException();
        } catch (ArrayStoreException e) {
            exceptions.add(e);
        }

    }
}
