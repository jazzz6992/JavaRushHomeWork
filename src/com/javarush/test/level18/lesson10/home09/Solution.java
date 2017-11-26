package com.javarush.test.level18.lesson10.home09;

/* Файлы и исключения
Читайте с консоли имена файлов
Если файла не существует (передано неправильное имя файла), то
перехватить исключение FileNotFoundException, вывести в консоль переданное неправильное имя файла и завершить работу программы.
Закрыть потоки. Не использовать try-with-resources
Не используйте System.exit();
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String name;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            name = reader.readLine();
            File file = new File(name);
           if (!file.exists()) {
               try {
                   throw new FileNotFoundException();
               } catch (FileNotFoundException ex) {
                   System.out.println(name);
                   break;
               }
           }

        }
        reader.close();
    }
}
