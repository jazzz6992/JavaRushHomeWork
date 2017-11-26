package com.javarush.test.level18.lesson10.home07;

/* Поиск данных внутри файла
Считать с консоли имя файла
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int)
Закрыть потоки. Не использовать try-with-resources

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity

где id - int
productName - название товара, может содержать пробелы, String
price - цена, double
quantity - количество, int

Информация по каждому товару хранится в отдельной строке
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        BufferedReader reader1 = new BufferedReader(new FileReader(fileName));
        String raw;
        while ((raw = reader1.readLine()) != null) {
            if (raw.startsWith(args[0] + " ")) {
//    System.out.println(raw.substring(raw.indexOf(" ") + 1));
                System.out.println(raw);
                break;
            }
//            String stringId = raw.substring(0, raw.indexOf(" "));
//            int id = Integer.parseInt(stringId);
//            if (Integer.parseInt(args[0]) == id) {
//                int end = raw.length() - 1;
//                int quantity = Integer.parseInt(raw.substring(raw.lastIndexOf(" ") + 1));
//                raw = raw.substring(raw.indexOf(" ") + 1, raw.lastIndexOf(" "));
//                double price = Double.parseDouble(raw.substring(raw.lastIndexOf(" ")));
//                String name = raw.substring(0, raw.lastIndexOf(" "));
//                System.out.println(id + " " + name + " " + price + " " + quantity);
//                break;
//            }
        }
        reader.close();
    }
}
