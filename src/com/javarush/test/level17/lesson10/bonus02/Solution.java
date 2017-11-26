package com.javarush.test.level17.lesson10.bonus02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        if (args[0].equals("-c")) {
            synchronized (allPeople) {
                for (int i = 0; i < args.length / 3; i++) {
                    if (args[i * 3 + 2].equals("м")) {
                        try {
                            Person person = Person.createMale(args[i * 3 + 1], simpleDateFormat.parse(args[i * 3 + 3]));
                            allPeople.add(person);
                            System.out.print(allPeople.indexOf(person) + " ");
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    } else if (args[i * 3 + 2].equals("ж")) {
                        try {
                            Person person = Person.createFemale(args[i * 3 + 1], simpleDateFormat.parse(args[i * 3 + 3]));
                            allPeople.add(person);
                            System.out.print(allPeople.indexOf(person) + " ");
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                }
                System.out.println();
            }
        } else if (args[0].equals("-u")) {
            synchronized (allPeople) {
                for (int i = 0; i < args.length / 4; i++) {
                    allPeople.get(Integer.parseInt(args[i * 4 + 1])).setName(args[i * 4 + 2]);
                    if (args[i*4+3].equals("м")) {
                        allPeople.get(Integer.parseInt(args[i * 4 + 1])).setSex(Sex.MALE);
                    } else if (args[i*4+3].equals("ж")) {
                        allPeople.get(Integer.parseInt(args[i * 4 + 1])).setSex(Sex.FEMALE);
                    }
                    try {
                        allPeople.get(Integer.parseInt(args[i * 4 + 1])).setBirthDay(simpleDateFormat.parse(args[i*4+4]));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else if (args[0].equals("-d")) {
            synchronized (allPeople) {
                for (int i = 1; i < args.length; i++) {
                    allPeople.get(Integer.parseInt(args[i])).setName(null);
                    allPeople.get(Integer.parseInt(args[i])).setSex(null);
                    allPeople.get(Integer.parseInt(args[i])).setBirthDay(null);
                }
            }
        } else if (args[0].equals("-i")) {
            synchronized (allPeople) {
                SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                for (int i = 1; i < args.length; i++) {
                    System.out.print(allPeople.get(Integer.parseInt(args[i])).getName() + " ");
                    if (allPeople.get(Integer.parseInt(args[i])).getSex().equals(Sex.MALE)) {
                        System.out.print("м" + " ");
                    } else if (allPeople.get(Integer.parseInt(args[i])).getSex().equals(Sex.FEMALE)) {
                        System.out.print("ж" + " ");
                    }
                    System.out.print(simpleDateFormat1.format(allPeople.get(Integer.parseInt(args[i])).getBirthDay()));
                    System.out.println();
                }
            }
        }
    }
}
