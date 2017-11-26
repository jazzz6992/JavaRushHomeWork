package com.javarush.test.level12.lesson04.task03;

/* Пять методов print с разными параметрами
Написать пять методов print с разными параметрами.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public void print() {
        System.out.println("nothing");
    }

    public void print(int x) {
        System.out.println(x);
    }

    public void print(String s, int x) {
        System.out.println(s + " " + x);
    }

    public String print(String s, String v) {
        StringBuilder sb = new StringBuilder();
        String r = sb.append(s).append(v).toString();
        System.out.println(r);
        return r;
    }

    public int print(int x, int z) {
        System.out.println(x + z);
        return x + z;
    }
}
