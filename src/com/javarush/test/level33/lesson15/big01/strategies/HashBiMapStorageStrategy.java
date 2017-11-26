package com.javarush.test.level33.lesson15.big01.strategies;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * Created by vsevolodvisnevskij on 24.04.17.
 */
public class HashBiMapStorageStrategy implements StorageStrategy {
   private HashBiMap<Long, String> data = HashBiMap.create();

    @Override
    public boolean containsKey(Long key) {
        return data.containsKey(key);
    }

    @Override
    public boolean containsValue(String value) {
        return data.containsValue(value);
    }

    @Override
    public void put(Long key, String value) {
        data.put(key, value);
    }

    @Override
    public Long getKey(String value) {
        BiMap<String, Long> reverse = data.inverse();
        return reverse.get(value);
    }

    @Override
    public String getValue(Long key) {
        return data.get(key);
    }
}
