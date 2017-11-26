package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileIn = reader.readLine();
        String fileOut1 = reader.readLine();
        String fileOut2 = reader.readLine();
        FileInputStream fis = new FileInputStream(fileIn);
        FileOutputStream fos = new FileOutputStream(fileOut1);
        if (fis.available() % 2 == 0) {
            byte[] buf = new byte[fis.available()/2];
            fis.read(buf);
            fos.write(buf);
        } else {
            byte[] buf = new byte[fis.available()/2 + 1];
            fis.read(buf);
            fos.write(buf);
        }
        fos.flush();
        fos = new FileOutputStream(fileOut2);
        byte[] buf = new byte[fis.available()];
        fis.read(buf);
        fos.write(buf);
        fis.close();
        fos.close();
        reader.close();
    }
}
