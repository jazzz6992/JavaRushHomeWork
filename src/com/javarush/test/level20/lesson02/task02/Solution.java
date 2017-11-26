package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = new File("/Users/vsevolodvisnevskij/IdeaProjects/JavaRushHomeWork/JavaRushHomeWork/my.test.part1");
            if (!your_file_name.exists()) {
                your_file_name.createNewFile();
            }
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            User user1 = new User();
            user1.setFirstName("Seva");
            user1.setLastName("Vish");
            user1.setBirthDate(new Date(1987, 11, 24));
            user1.setMale(true);
            user1.setCountry(User.Country.RUSSIA);
            User user2 = new User();
            user2.setFirstName("Alex");
            user2.setLastName("Vishn");
            user2.setBirthDate(new Date(1989, 8, 13));
            user2.setMale(false);
            user2.setCountry(User.Country.OTHER);
            javaRush.users.add(user1);
            javaRush.users.add(user2);
            javaRush.save(outputStream);
            outputStream.flush();
            outputStream.close();
            System.out.println(javaRush);

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            System.out.println(loadedObject);

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

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
            int x = users.size();
            writer.write(x + "\n");
            for (int i = 0; i < x; i++) {
                User tmp = users.get(i);
                writer.write(tmp.getFirstName() + "\n");
                writer.write(tmp.getLastName() + "\n");
                writer.write(tmp.getBirthDate().getTime() + "\n");
                if (tmp.isMale()) {
                    writer.write("true\n");
                } else {
                    writer.write("false\n");
                }
                writer.write(tmp.getCountry().getDisplayedName()+ "\n");
            }
            writer.close();
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            int x = Integer.parseInt(reader.readLine());
            for (int i = 0; i < x; i++) {
                User tmp = new User();
                tmp.setFirstName(reader.readLine());
                tmp.setLastName(reader.readLine());
                tmp.setBirthDate(new Date(Long.parseLong(reader.readLine())));
                if (reader.readLine().equals("true")) {
                    tmp.setMale(true);
                } else {
                    tmp.setMale(false);
                }
                String c = reader.readLine();
                if (c.equals("Russia")) {
                    tmp.setCountry(User.Country.RUSSIA);
                } else if (c.equals("Ukraine")) {
                    tmp.setCountry(User.Country.UKRAINE);
                } else {
                    tmp.setCountry(User.Country.OTHER);
                }
                users.add(tmp);
            }
            reader.close();
        }

//        @Override
//        public String toString() {
//            String res = "";
//            for (User user :
//                    users) {
//                res += user.getFirstName() + " ";
//                res += user.getLastName() + " ";
//                res += user.getBirthDate().getTime() + " ";
//                res += user.isMale() + " ";
//                res += user.getCountry() + "\n";
//            }
//            return res;
//        }
    }
}
