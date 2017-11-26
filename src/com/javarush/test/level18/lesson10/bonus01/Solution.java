package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        String arg = args[0];
        String fileIn = args[1];
        String fileOut = args[2];
        FileInputStream fis = new FileInputStream(fileIn);
        FileOutputStream fos = new FileOutputStream(fileOut);
        if (arg.equals("-e")) {
            String key = "key";
            int index = 0;
            while (fis.available() > 0) {
                int data = fis.read() + key.charAt(index % key.length());
                fos.write(data);
                index++;
            }
        } else if (arg.equals("-d")) {
            String key = "key";
            int index = 0;
            while (fis.available() > 0) {
                int data = fis.read() - key.charAt(index % key.length());
                fos.write(data);
                index++;
            }
        }
        fis.close();
        fos.close();
    }

}
