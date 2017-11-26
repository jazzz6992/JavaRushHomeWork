package com.javarush.test.level15.lesson04.task02;

/* ООП - Перегрузка
Перегрузите метод printMatrix 8 различными способами. В итоге должно получиться 10 различных методов printMatrix.
*/

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
    }

    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }

    public static void printMatrix(int m, int n, Byte z) {
        System.out.println("Заполняем объектами Byte");
        printMatrix(m, n, (Object) z);
    }

    public static void printMatrix(int m, int n, Short z) {
        System.out.println("Заполняем объектами Short");
        printMatrix(m, n, (Object) z);
    }

    public static void printMatrix(int m, int n, Integer z) {
        System.out.println("Заполняем объектами Integer");
        printMatrix(m, n, (Object) z);
    }

    public static void printMatrix(int m, int n, Double z) {
        System.out.println("Заполняем объектами Double");
        printMatrix(m, n, (Object) z);
    }

    public static void printMatrix(int m, int n, Long z) {
        System.out.println("Заполняем объектами Long");
        printMatrix(m, n, (Object) z);
    }

    public static void printMatrix(int m, int n, Float z) {
        System.out.println("Заполняем объектами Float");
        printMatrix(m, n, (Object) z);
    }

    public static void printMatrix(int m, int n, Character z) {
        System.out.println("Заполняем объектами Character");
        printMatrix(m, n, (Object) z);
    }

    public static void printMatrix(int m, int n, Boolean z) {
        System.out.println("Заполняем объектами Boolean");
        printMatrix(m, n, (Object) z);
    }
}
