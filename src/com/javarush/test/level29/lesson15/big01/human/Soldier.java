package com.javarush.test.level29.lesson15.big01.human;

/**
 * Created by vsevolodvisnevskij on 28.01.17.
 */
public class Soldier extends Human {

    public void fight() {
    }

    public Soldier(String name, int age) {
        super(name, age);
    }

    public void live() {
        fight();
    }
}
