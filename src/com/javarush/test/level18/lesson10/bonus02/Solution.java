package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();
        if (args[0].equals("-c")) {
            String name;
            if (args.length > 4) {
                StringBuilder sb = new StringBuilder();
                sb.append(args[1]);
                for (int i = 2; i < args.length - 2; i++) {
                    sb.append(" " + args[i]);
                }
                name = sb.toString();
            } else {
                name = args[1];
            }
            name = addSpaces(30, name);
            if (name.length() > 30) {
                name = name.substring(0, 30);
            }
            String price = args[args.length - 2];
            price = addSpaces(8, price);
            String quantity = args[args.length - 1];
            quantity = addSpaces(4, quantity);
            FileInputStream fis = new FileInputStream(file);
            int aval = fis.available();
            byte[] id = new byte[aval];
            fis.read(id, 0, aval);
            String s = new String(id);
            s = s.substring(0, s.length() - 2);
            int st = s.lastIndexOf('\n') + 1;
            int fn = s.lastIndexOf('\n') + 9;
            String idS = s.substring(st, fn);
            Scanner scanner = new Scanner(idS);
            int idI = scanner.nextInt();
            idI++;
            String resultId = idI + "";
            resultId = addSpaces(8, resultId);
            fis.close();
            StringBuilder sb = new StringBuilder();
            String result = sb.append(resultId).append(name).append(price).append(quantity).append('\n').toString();
            FileOutputStream fileOutputStream = new FileOutputStream(file, true);
            fileOutputStream.write(result.getBytes());
            fileOutputStream.close();

        }
    }

    public static String addSpaces(int n, String s) {
        if (s.length() < n) {
            StringBuilder sb = new StringBuilder();
            sb.append(s);
            for (int i = s.length(); i < n; i++) {
                sb.append(" ");
            }
            s = sb.toString();
        }
        return s;
    }
}
