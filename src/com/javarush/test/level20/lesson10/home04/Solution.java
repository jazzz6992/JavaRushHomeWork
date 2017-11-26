package com.javarush.test.level20.lesson10.home04;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* Исправить ошибку
После десериализации объекта класса Solution обнаружили, что данных в словаре [m] нет :(
Исправить 1 ошибку.
Метод main в тестировании не участвует.
*/
public class Solution implements Serializable {

    public static void main(String args[]) throws Exception {
        FileOutputStream fileOutput = new FileOutputStream("/Users/vsevolodvisnevskij/IdeaProjects/JavaRushHomeWork/JavaRushHomeWork/my.test.part1");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);

        Solution solution = new Solution();
        outputStream.writeObject(solution);
        System.out.println(solution.size());
        for (Map.Entry<String, String> pair :
                solution.m.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }

        fileOutput.close();
        outputStream.close();

        //loading
        FileInputStream fiStream = new FileInputStream("/Users/vsevolodvisnevskij/IdeaProjects/JavaRushHomeWork/JavaRushHomeWork/my.test.part1");
        ObjectInputStream objectStream = new ObjectInputStream(fiStream);

        Solution loadedObject = (Solution) objectStream.readObject();

        fiStream.close();
        objectStream.close();

        //Attention!!
        System.out.println(loadedObject.size());
    }

    private Map<String, String> m = new HashMap<>();

    public Map<String, String> getMap() {
        return m;
    }

    public Solution() {
        m.put("Mickey", "Mouse");
        m.put("Mickey", "Mantle");
    }

    public int size() {
        return m.size();
    }
}
