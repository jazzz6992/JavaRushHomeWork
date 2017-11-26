package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by vsevolodvisnevskij on 18.10.16.
 */
public class Singleton {
    private static final Singleton singleton = new Singleton();
    public static Singleton getInstance() {
        return singleton;
    }

    private Singleton() {
    }
}
