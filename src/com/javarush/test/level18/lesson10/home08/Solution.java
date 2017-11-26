package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name;
        while (true) {
            name = reader.readLine();
            if (name.equals("exit")) {
                break;
            } else {
                ReadThread readThread = new ReadThread(name);
                readThread.start();
            }

        }
        reader.close();
//        Thread.sleep(2000);
//        for (Map.Entry<String, Integer> pair :
//             resultMap.entrySet()) {
//            System.out.println(pair.getKey() + " " + pair.getValue());
//        }
    }

    public static class ReadThread extends Thread {
        String fileName;
        public ReadThread(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public void run() {
            try {
                FileInputStream fis = new FileInputStream(fileName);
                Map<Integer, Integer> map = new HashMap<>();
                int max = 0;
                int maxKey = 0;
                while (fis.available() > 0) {
                    int symbol = fis.read();
                    if (map.containsKey(symbol)) {
                        map.put(symbol, map.get(symbol) + 1);
                    } else {
                        map.put(symbol, 1);
                    }
                }
                fis.close();
                for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
                    if (pair.getValue() > max) {
                        max = pair.getValue();
                        maxKey = pair.getKey();
                    }
                }
                resultMap.put(fileName, maxKey);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
