package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

import java.util.List;

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        String name;
        int age;
        String race;
        boolean gender;
        Human[] parents;
        List<Human> kids;

        public Human(String name, int age, String race, boolean gender, List<Human> kids) {
            this.name = name;
            this.age = age;
            this.race = race;
            this.gender = gender;
            this.parents = new Human[2];
            this.kids = kids;
        }

        public Human(String name) {

            this.name = name;
        }

        public Human(String name, int age, String race, boolean gender) {
            this.name = name;
            this.age = age;
            this.race = race;
            this.gender = gender;
        }

        public Human(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Human(int age, String race, boolean gender) {
            this.age = age;
            this.race = race;
            this.gender = gender;
        }

        public Human(String name, int age, boolean gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        public Human(String name, Human[] parents, List<Human> kids) {
            this.name = name;
            this.parents = parents;
            this.kids = kids;
        }

        public Human(int age, String race, Human[] parents, List<Human> kids) {
            this.age = age;
            this.race = race;
            this.parents = parents;
            this.kids = kids;
        }

        public Human(int age) {
            this.age = age;
        }

        public Human(Human[] parents) {
            this.parents = new Human[2];
        }
    }
}
