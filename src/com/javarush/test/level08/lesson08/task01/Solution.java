package com.javarush.test.level08.lesson08.task01;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/* 20 слов на букву «Л»
Создать множество строк (Set<String>), занести в него 20 слов на букву «Л».
*/

public class Solution {
    public static HashSet<String> createSet() {
        HashSet<String> set = new HashSet<>();
        set.add("Люба");
        set.add("Лето");
        set.add("Ливень");
        set.add("Лен");
        set.add("Лена");
        set.add("Ляля");
        set.add("Липецк");
        set.add("Лексус");
        set.add("Линия");
        set.add("Люкс");
        set.add("Линекс");
        set.add("Люминисцент");
        set.add("Лотерея");
        set.add("Ликвид");
        set.add("Ликвадация");
        set.add("Люстра");
        set.add("Листопад");
        set.add("Лимон");
        set.add("Лесник");
        set.add("Лотос");
        return set;
    }
}
