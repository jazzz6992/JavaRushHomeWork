package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        File file1 = new File(args[0]);
        File file2 = new File(args[1]);
        BufferedReader reader = new BufferedReader(new FileReader(file1));
        BufferedWriter writer = new BufferedWriter(new FileWriter(file2));
        String s;
        while ((s = reader.readLine()) != null) {
            String[] strings = s.split(" ");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < strings.length; i++) {
                for (int j = 0; j < strings[i].length(); j++) {
                    if (strings[i].charAt(j) >= 48 && strings[i].charAt(j) <= 57) {
                        sb.append(strings[i] + " ");
                        break;
                    }
                }
            }
            writer.write(sb.toString().substring(0, sb.toString().length() - 1));
            writer.write('\n');
        }
        reader.close();
        writer.close();
    }
}
