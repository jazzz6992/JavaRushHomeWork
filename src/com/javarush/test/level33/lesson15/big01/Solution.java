package com.javarush.test.level33.lesson15.big01;

import com.javarush.test.level33.lesson15.big01.strategies.*;

import java.util.*;

/**
 * Created by vsevolodvisnevskij on 24.04.17.
 */
public class Solution {
    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        Set<Long> keys = new HashSet<>();
        for (String s :
                strings) {
            keys.add(shortener.getId(s));
        }
        return keys;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        Set<String> strings = new HashSet<>();
        for (Long l :
                keys) {
            strings.add(shortener.getString(l));
        }
        return strings;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        Helper.printMessage(strategy.getClass().getSimpleName());
        Set<String> randomSet = new HashSet<>();
        for (long i = 0; i < elementsNumber; i++) {
            randomSet.add(Helper.generateRandomString());
        }
        Shortener shortener = new Shortener(strategy);
        long start = new Date().getTime();
        Set<Long> testIDs = getIds(shortener, randomSet);
        long finish = new Date().getTime();
        Helper.printMessage(String.valueOf(finish - start));
        start = new Date().getTime();
        Set<String> generatedSet = getStrings(shortener, testIDs);
        finish = new Date().getTime();
        Helper.printMessage(String.valueOf(finish - start));
        if (generatedSet.equals(randomSet)) {
            Helper.printMessage("Тест пройден.");
        } else {
            Helper.printMessage("Тест не пройден.");
        }
    }

    public static void main(String[] args) {
        testStrategy(new HashMapStorageStrategy(), 10000);
        testStrategy(new OurHashMapStorageStrategy(), 10000);
//        testStrategy(new FileStorageStrategy(), 10000);
        testStrategy(new OurHashBiMapStorageStrategy(), 10000);
        testStrategy(new HashBiMapStorageStrategy(), 10000);

    }
}
