package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();
//        reader = new BufferedReader(new FileReader(file2));
//        FileWriter fileWriter = new FileWriter(file1);
//        ArrayList<String> list = new ArrayList<>();
//        String s;
//        while ((s = reader.readLine()) != null) {
//            fileWriter.write(s);
//        }
//        reader.close();
//        reader = new BufferedReader(new FileReader(file3));
//        while ((s = reader.readLine()) != null) {
//            fileWriter.write(s);
//        }
//        reader.close();
//        fileWriter.close();
        FileInputStream fis = new FileInputStream(file2);
        FileOutputStream fos = new FileOutputStream(file1);
        while (fis.available() > 0) {
            fos.write(fis.read());
        }
        fis.close();
        fis = new FileInputStream(file3);
        while (fis.available() > 0) {
            fos.write(fis.read());
        }
        reader.close();
        fis.close();
        fos.close();
    }
}
