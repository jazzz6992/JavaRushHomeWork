package com.javarush.test.level26.lesson02.task01;

import java.util.Arrays;
import java.util.Comparator;

/* Почитать в инете про медиану выборки
Реализовать логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы
Вернуть отсортированный массив от минимального расстояния до максимального
Если удаленность одинаковая у нескольких чисел, то выводить их в порядке возрастания
*/
public class Solution {
    public static Integer[] sort(Integer[] array) {

        final double median;

        Arrays.sort(array);
        final int middle = array.length / 2;
        if (array.length % 2 == 1)
            median = array[middle];
        else
            median = (array[middle - 1] + array[middle]) / 2.0;

        Comparator<Integer> comparatorByMedian = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                double result = Math.abs(o1 - median) - Math.abs(o2 - median);
                if (result == 0) {
                    return o1 - o2;
                } else {
                    return result > 0 ? 1 : -1;
                }
            }
        };

        Arrays.sort(array, comparatorByMedian);

        return array;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        arr = sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
