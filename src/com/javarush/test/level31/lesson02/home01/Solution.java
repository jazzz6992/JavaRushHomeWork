package com.javarush.test.level31.lesson02.home01;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* Проход по дереву файлов
1. На вход метода main подаются два параметра.
Первый - path - путь к директории, второй - resultFileAbsolutePath - имя файла, который будет содержать результат.
2. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
2.1. Если у файла длина в байтах больше 50, то удалить его.
2.2. Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:
2.2.1. отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке
2.2.2. переименовать resultFileAbsolutePath в 'res.txt'
2.2.3. в res.txt последовательно записать содержимое всех файлов из п. 2.2.1. Тела файлов разделять "\n"
2.3. Удалить директории без файлов (пустые).
Все файлы имеют расширение txt.
*/
public class Solution {
    public static void main(String[] args) {
        File root = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);
        if (root.isDirectory()) {
            ArrayList<File> fileNamesForSort = new ArrayList<>();
            listFilesToSort(root, fileNamesForSort);
            Collections.sort(fileNamesForSort, new Comparator<File>() {
                @Override
                public int compare(File o1, File o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(resultFileAbsolutePath, true);
                FileInputStream fileInputStream;
                for (File f : fileNamesForSort) {
                    fileInputStream = new FileInputStream(f);
                    int bufSize = fileInputStream.available();
                    byte[] buf = new byte[bufSize];
                    fileInputStream.read(buf);
                    fileInputStream.close();
                    fileOutputStream.write(buf);
                    fileOutputStream.write('\n');
                }
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            removeEmptyFolders(root);
            resultFileAbsolutePath.renameTo(new File(resultFileAbsolutePath.getParent() + "/AllFilesContent.txt"));
        }
    }

    public static void listFilesToSort(File file, ArrayList<File> arrayList) {
        if (file.isDirectory()) {
            File[] list = file.listFiles();
            for (File each : list) {
                listFilesToSort(each, arrayList);
            }
        } else {
            if (file.length() > 50) {
                file.delete();
            } else {
                arrayList.add(file);
            }
        }
    }

    public static void removeEmptyFolders(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File each : files) {
                removeEmptyFolders(each);
            }
            if (file.list().length == 0) {
                file.delete();
            }
        }
    }
}
