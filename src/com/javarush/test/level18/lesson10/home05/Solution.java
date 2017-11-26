package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/


import java.io.*;
import java.math.BigDecimal;
//import java.util.InputMismatchException;
//import java.util.Locale;
//import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String f1 = reader.readLine();
        String f2 = reader.readLine();
        reader.close();
        reader = new BufferedReader(new FileReader(f1));
        String file1 = reader.readLine();
//        Scanner scanner = new Scanner(file1).useLocale(Locale.ENGLISH);
//        while (scanner.hasNext()) {
//            try {
//                double d = scanner.nextDouble();
//                int i = (int) Math.round(d);
//                sb.append(i + " ");
//            } catch (InputMismatchException ex) {
//                break;
//            }
//
//        }
//        FileWriter fileWriter = new FileWriter(f2);
//        fileWriter.write(sb.toString());
//
//        scanner.close();
//        fileWriter.close();
//        reader.close();
        String[] file1Arr = file1.split(" ");
        double[] doubleArr = new double[file1Arr.length];
        int[] intArr = new int[file1Arr.length];
        for (int i = 0; i < file1Arr.length; i++) {
            doubleArr[i] = Double.parseDouble(file1Arr[i]);
        }
        FileOutputStream fos = new FileOutputStream(f2);
        for (int i = 0; i < doubleArr.length; i++) {
            if (doubleArr[i] > 0) {
                intArr[i] = (int) new BigDecimal(doubleArr[i]).setScale(0, BigDecimal.ROUND_HALF_UP).doubleValue();
            } else {
                intArr[i] = (int) new BigDecimal(doubleArr[i]).setScale(0, BigDecimal.ROUND_HALF_DOWN).doubleValue();
            }
            String st = Integer.toString(intArr[i]);
            fos.write(st.getBytes());
            fos.write(32);
//            if (intArr[i] >= 0) {
//                fos.write(intArr[i] + 48);
//                fos.write(32);
//            } else {
//                fos.write(45);
//                fos.write(Math.abs(intArr[i]) + 48);
//                fos.write(32);
//            }
        }
        fos.close();
    }
}
