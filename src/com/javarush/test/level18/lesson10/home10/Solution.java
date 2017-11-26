package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis;
        FileOutputStream fos;
        String s;
        ArrayList<String> list = new ArrayList<>();
        while (!(s = reader.readLine()).equals("end")) {
            list.add(s);
        }
        reader.close();
        if (list.size() > 0) {
            String ourFileName = list.get(0).substring(0, list.get(0).lastIndexOf(".part"));
            File file = new File(ourFileName);
            file.createNewFile();
            fos = new FileOutputStream(file);
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < list.size() - 1 - i; j++) {
                    String s1 = list.get(j);
                    String s2 = list.get(j + 1);
                    String tmp1 = s1.substring(s1.lastIndexOf(".") + 5);
                    String tmp2 = s2.substring(s2.lastIndexOf(".") + 5);
                    int i1 = Integer.parseInt(tmp1);
                    int i2 = Integer.parseInt(tmp2);
                    if (i1 > i2) {
                        String tmp = list.get(j);
                        list.set(j, list.get(j + 1));
                        list.set(j + 1, tmp);
                    }
                }
            }
            for (int j = 0; j < list.size(); j++) {
                fis = new FileInputStream(list.get(j));
                while (fis.available() > 0) {
                    int size = fis.available();
                    byte[] buf = new byte[size];
                    fis.read(buf);
                    fos.write(buf);

                }
                fis.close();
            }
            fos.close();
        }
    }
}