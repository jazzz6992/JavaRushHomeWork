package com.javarush.test.level20.lesson10.bonus02;

/* Алгоритмы-прямоугольники
1. Дан двумерный массив N*N, который содержит несколько прямоугольников.
2. Различные прямоугольники не соприкасаются и не накладываются.
3. Внутри прямоугольник весь заполнен 1.
4. В массиве:
4.1) a[i, j] = 1, если элемент (i, j) принадлежит какому-либо прямоугольнику
4.2) a[i, j] = 0, в противном случае
5. getRectangleCount должен возвращать количество прямоугольников.
6. Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a = new byte[][]{
                {1, 1, 0, 0, 1, 1},
                {1, 1, 0, 0, 1, 1},
                {1, 1, 0, 0, 0, 0},
                {1, 1, 0, 1, 0, 0}
        };
        int count = getRectangleCount(a);
        System.out.println("count = " + count + ". Должно быть 2");

    }

    public static int getRectangleCount(byte[][] a) {
        int counter = 0;
        byte[][] arr = new byte[a.length][];
        for (int i = 0; i < a.length; i++) {
            arr[i] = new byte[a[i].length];
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                arr[i][j] = a[i][j];
            }
        }
        int i = 0;
        int j = 0;
        while (i < arr.length) {
            if (j < arr[i].length) {
                if (arr[i][j] == 0) {
                    j++;
                } else {
                    int start = j;
                    int finish = j;
                    for (int k = j + 1; k < arr[i].length; k++) {
                        if (arr[i][k] == 1) {
                            finish = k;
                        } else {
                            break;
                        }
                    }
                    boolean isOk = true;
                    for (int k = i; k < arr.length; k++) {
                        for (int l = start; l <= finish; l++) {
                            if (arr[k][l] == 1) {
                                arr[k][l] = 0;
                            } else {
                                isOk = false;
                            }
                        }
                        if (!isOk) {
                            counter++;
                            break;
                        }
                        if (k == arr.length - 1) {
                            counter++;
                            break;
                        }
                    }
                }
            } else {
                i++;
                j = 0;
            }
        }
        return counter;
    }

}
