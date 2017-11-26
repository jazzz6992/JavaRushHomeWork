package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution {
    public static HashMap<String, Date> createMap() {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));
        map.put("Lukyanenko", new Date("FEBRUARY 23 1988"));
        map.put("Bondarev", new Date("JANUARY 21 1962"));
        map.put("Ten'ko", new Date("JANUARY 18 1988"));
        map.put("Romanyuk", new Date("MARCH 21 1988"));
        map.put("Beloded", new Date("APRIL 20 1988"));
        map.put("Kosareva", new Date("APRIL 10 1988"));
        map.put("Belyakova", new Date("JUNE 1 1943"));
        map.put("Efremova", new Date("JULY 9 1987"));
        map.put("Luzgina", new Date("JULY 15 1989"));
        return map;


    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Date> pair = iterator.next();
            Date date = pair.getValue();
            if (date.getMonth() >= 5 && date.getMonth() <= 7) {
                iterator.remove();
            }
        }
    }
}
