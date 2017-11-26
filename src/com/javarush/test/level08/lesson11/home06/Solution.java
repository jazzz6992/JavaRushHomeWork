package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        Human grandfather1 = new Human("Ivan", true, 85, new ArrayList<Human>());
        Human grandfather2 = new Human("Viktor", true, 80, new ArrayList<Human>());
        Human grandmother1 = new Human("Lubov", false, 78, new ArrayList<Human>());
        Human grandmother2 =  new Human("L'udmila", false, 73, new ArrayList<Human>());
        Human father = new Human("Youri", true, 54, new ArrayList<Human>());
        Human mother = new Human("Nataliya", false, 51, new ArrayList<Human>());
        Human son = new Human("Seva", true, 28, new ArrayList<Human>());
        Human daughter1 = new Human("Nastya", false, 28, new ArrayList<Human>());
        Human daughter2 = new Human("Kristina", false, 25, new ArrayList<Human>());
        father.children.add(son);
        father.children.add(daughter1);
        father.children.add(daughter2);
        mother.children.add(son);
        mother.children.add(daughter1);
        mother.children.add(daughter2);
        grandfather1.children.add(father);
        grandmother1.children.add(father);
        grandfather2.children.add(mother);
        grandmother2.children.add(mother);
        System.out.println(grandfather1);
        System.out.println(grandfather2);
        System.out.println(grandmother1);
        System.out.println(grandmother2);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(son);
        System.out.println(daughter1);
        System.out.println(daughter2);
    }

    public static class Human
    {
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children;

        public Human(String name, boolean sex, int age, ArrayList<Human> children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
