package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();
        FileInputStream fis = new FileInputStream(file1);
        byte[] f1 = new byte[fis.available()];
        fis.read(f1);
        fis.close();
        fis = new FileInputStream(file2);
        byte[] f2 = new byte[fis.available()];
        fis.read(f2);
        fis.close();
        FileOutputStream fos = new FileOutputStream(file1);
        fos.write(f2);
        fos.write(f1);
        fos.close();
    }
}
