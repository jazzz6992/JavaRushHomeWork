package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;


public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(args[0]);
        int allCount = 0;
        int spaceCount = 0;
        while (fis.available() > 0) {
            allCount++;
            int tmp = fis.read();
            if (tmp == 32) {
                spaceCount++;
            }
        }
//        System.out.println(allCount);
//        System.out.println(spaceCount);
        double range = (double) spaceCount / (double) allCount * 100;
//        range = new BigDecimal(range).setScale(2, RoundingMode.UP).doubleValue();
        System.out.println(String.format("%.2f", range));
        fis.close();
    }
}
