package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File file = new File(reader.readLine());
        File file2 = new File(reader.readLine());
        reader.close();
        FileInputStream fis = new FileInputStream(file);
        byte[] arr = new byte[fis.available()];
        fis.read(arr);
        fis.close();
        String[] words = new String(arr).split(" ");
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String tmp = words[i];
            if (tmp.contains("\n")) {
                tmp = tmp.substring(0, tmp.length() - 1);
            }
            boolean isNumber = true;
            boolean firstDot = true;
            for (int j = 0; j < tmp.length(); j++) {
                int c = tmp.charAt(j);
                if (j != 0 && c == '-') {
                    isNumber = false;
                    break;
                } else if (!((c >= 48 && c <= 57) || c == 45)) {
                    if (c == 46 && firstDot && j < tmp.length() - 1 && j > 0) {
                        firstDot = false;
                    } else {
                        isNumber = false;
                        break;
                    }
                }
            }
            if (isNumber) {
                list.add(words[i]);
            }
        }
        FileOutputStream fos = new FileOutputStream(file2);
        for (String s :
                list) {
            fos.write(s.getBytes());
            fos.write(' ');
        }
        fos.close();
    }
}
