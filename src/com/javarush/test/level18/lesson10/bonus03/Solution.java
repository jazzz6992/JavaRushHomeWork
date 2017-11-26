package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();
        int id;
        id = Integer.parseInt(args[1]);
        FileInputStream fis = new FileInputStream(file);
        byte[] buf = new byte[fis.available()];
        fis.read(buf);
        fis.close();
        int idxS = 0;
        byte[] tmpId = new byte[8];
        boolean found = false;
        while (idxS < buf.length) {
            for (int i = 0; i < tmpId.length; i++) {
                tmpId[i] = buf[idxS + i];
            }
            String toComp = new String(tmpId);
            toComp = toComp.substring(0, toComp.indexOf(" "));
            int idToCompare = Integer.parseInt(toComp);
            if (id == idToCompare) {
                found = true;
                break;
            } else {
                while (idxS < buf.length) {
                    if (buf[idxS] == '\n') {
                        idxS++;
                        break;
                    } else {
                        idxS++;
                    }
                }
            }
        }
        if (found) {
            if (args[0].equals("-u")) {
                StringBuilder sb = new StringBuilder();
                String name;
                String quantity = args[args.length - 1];
                String price = args[args.length - 2];
                if (args.length > 5) {
                    sb.append(args[2]);
                    for (int i = 3; i < args.length - 2; i++) {
                        sb.append(" ").append(args[i]);
                    }
                    name = sb.toString();
                } else {
                    name = args[2];
                }
                sb = new StringBuilder();
                name = addSpaces(name, 30);
                price = addSpaces(price, 8);
                quantity = addSpaces(quantity, 4);
                sb.append(name).append(price).append(quantity);
                String resultRaw = sb.toString();
                byte[] result = (resultRaw + '\n').getBytes();
                FileOutputStream fos = new FileOutputStream(file);
                int idxF = idxS;
                while (idxF < buf.length && buf[idxF] != '\n') {
                    idxF++;
                }
                idxF++;
                fos.write(buf, 0, idxS + 8);
                fos.write(result);
                if (idxF < buf.length) {
                    fos.write(buf, idxF, buf.length - idxF);
                }
                fos.close();
            } else if (args[0].equals("-d")) {
                int idxF = idxS;
                while (idxF < buf.length && buf[idxF] != '\n') {
                    idxF++;
                }
                idxF++;
                FileOutputStream fos = new FileOutputStream(file);
                fos.write(buf, 0, idxS);
                if (idxF < buf.length) {
                    fos.write(buf, idxF, buf.length - idxF);
                }
                fos.close();
            }
        }
    }

    public static String addSpaces(String s, int x) {
        String result;
        if (s.length() < x) {
            StringBuilder sb = new StringBuilder();
            sb.append(s);
            for (int i = 0, j = x - s.length(); i < j; i++) {
                sb.append(" ");
            }
            result = sb.toString();
            return result;
        } else if (s.length() > x) {
            result = s.substring(0, x);
            return result;
        } else {
            result = s;
            return result;
        }
    }
}