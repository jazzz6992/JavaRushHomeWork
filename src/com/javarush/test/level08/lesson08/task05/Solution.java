package com.javarush.test.level08.lesson08.task05;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
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

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {
        HashMap<String, Integer> dup = new HashMap<>();
        for (Map.Entry<String, String> pair : map.entrySet()) {
            if (!dup.containsKey(pair.getValue())) {
                dup.put(pair.getValue(), 1);
            } else {
                dup.put(pair.getValue(), dup.get(pair.getValue()) + 1);
            }
        }
        for (Map.Entry<String, Integer> pair : dup.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
            if (pair.getValue() > 0) {
                removeItemFromMapByValue(map, pair.getKey());
            }
        }
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {
        HashMap<String, String> map = createMap();
        removeTheFirstNameDuplicates(map);
//        for (Map.Entry<String, String> pair : map.entrySet()) {
//            System.out.println(pair.getKey() + " " + pair.getValue());
//        }
    }
}