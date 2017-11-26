package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Pugachev", "Alex");
        map.put("Brilenko", "Alex");
        map.put("Voronin", "Alex");
        map.put("Vishnevskaya", "Alena");
        map.put("Nikitina", "Nastya");
        map.put("Chirkova", "Nastya");
        map.put("Romeo", "Anton");
        map.put("Shalyakin", "Anton");
        map.put("Gorgol", "Artsem");
        map.put("Maksimenko", "Vladimir");
        return map;

    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        int i = 0;
        for (Map.Entry<String, String> pair : map.entrySet()) {
            if (pair.getValue().equals(name)) {
                i++;
            }
        }
        return i;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        int i = 0;
        if (map.containsKey(lastName)) {
            i++;
        }
        return i;
    }
}
