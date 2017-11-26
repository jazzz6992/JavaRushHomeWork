package com.javarush.test.level31.lesson02.home02;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/* Находим все файлы
Реализовать логику метода getFileTree, который должен в директории root найти список всех файлов включая вложенные.
Используйте очередь, рекурсию не используйте.
Верните список всех путей к найденным файлам, путь к директориям возвращать не надо.
Путь должен быть абсолютный.
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> allFiles = new ArrayList<>();
        File rootDir = new File(root);
        Queue<File> dirQueue = new PriorityQueue<>();
        dirQueue.add(rootDir);
        while (dirQueue.size() > 0) {
            File[] files = dirQueue.remove().listFiles();
            for (File f : files) {
                if (f.isDirectory()) {
                    dirQueue.add(f);
                } else {
                    allFiles.add(f.getAbsolutePath());
                }
            }
        }
        return allFiles;
    }
}
