package com.javarush.test.level20.lesson02.task05;

import java.io.*;

/* И еще раз о синхронизации
Разберитесь почему не работает метод main()
Реализуйте логику записи в файл и чтения из файла для класса Object
Метод load должен инициализировать объект данными из файла
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(java.lang.String[] args) {
        try {
            File your_file_name = new File("/Users/vsevolodvisnevskij/IdeaProjects/JavaRushHomeWork/JavaRushHomeWork/my.test.part1");
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Object object = new Object();
            object.string1 = new String();   //string #1
            object.string2 = new String();   //string #2
            object.save(outputStream);
            outputStream.flush();
            System.out.println(object.string1.number);
            System.out.println(object.string2.number);

            Object loadedObject = new Object();
            loadedObject.string1 = new String(); //string #3
            loadedObject.string2 = new String(); //string #4
            System.out.println(loadedObject.string1.number);
            System.out.println(loadedObject.string2.number);
            System.out.println("***************************");


            loadedObject.load(inputStream);
            System.out.println(loadedObject.string1.number);
            System.out.println(loadedObject.string2.number);
            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }


    public static class Object {
        public String string1;
        public String string2;

        public void save(OutputStream outputStream) throws Exception {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
            if (string1 != null) {
                writer.write(string1.number + "\n");
            }
            if (string2 != null) {
                writer.write(string2.number + "\n");
            }
            writer.close();
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            string1.number = Integer.parseInt(reader.readLine());
            string2.number = Integer.parseInt(reader.readLine());
            reader.close();
        }
    }

    public static int countStrings;

    public static class String {
        private int number;

        public String() {
            number = ++countStrings;
        }

        public void print() {
            System.out.println("string #" + number);
        }
    }
}
