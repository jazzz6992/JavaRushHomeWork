package com.javarush.test.level19.lesson10.bonus01;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
оригинальный   редактированный    общий
file1:         file2:             результат:(lines)

строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка4                           REMOVED строка4
строка5        строка5            SAME строка5
               строка0            ADDED строка0
строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
               строка5            ADDED строка5
строка4        строка4            SAME строка4
строка5                           REMOVED строка5
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File file1 = new File(reader.readLine());
        File file2 = new File(reader.readLine());
        reader.close();
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        BufferedReader reader1 = new BufferedReader(new FileReader(file1));
        String s;
        while ((s = reader1.readLine()) != null) {
            list1.add(s);
        }
        reader1.close();
        BufferedReader reader2 = new BufferedReader(new FileReader(file2));
        while ((s = reader2.readLine()) != null) {
            list2.add(s);
        }
        reader2.close();

        while (true) {
            if (list1.size() > 0 && list2.size() > 0) {
                if (list1.size() <= list2.size()) {
                    if (list1.get(0).equals(list2.get(0))) {
                        lines.add(new LineItem(Type.SAME, list1.get(0)));
                        list1.remove(0);
                        list2.remove(0);
                    } else if (list1.get(0).equals(list2.get(1))) {
                        lines.add(new LineItem(Type.ADDED, list2.get(0)));
                        list2.remove(0);
                    } else {
                        lines.add(new LineItem(Type.REMOVED, list1.get(0)));
                        list1.remove(0);
                    }
                } else {
                    if (list1.get(0).equals(list2.get(0))) {
                        lines.add(new LineItem(Type.SAME, list1.get(0)));
                        list1.remove(0);
                        list2.remove(0);
                    } else if (list1.get(1).equals(list2.get(0))) {
                        lines.add(new LineItem(Type.REMOVED, list1.get(0)));
                        list1.remove(0);
                    } else {
                        lines.add(new LineItem(Type.ADDED, list2.get(0)));
                    }
                }
            } else {
                if (list1.size() > 0) {
                    lines.add(new LineItem(Type.REMOVED, list1.get(0)));
                    list1.remove(0);
                } else if (list2.size() > 0) {
                    lines.add(new LineItem(Type.ADDED, list2.get(0)));
                    list2.remove(0);
                } else {
                    break;
                }
            }
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
