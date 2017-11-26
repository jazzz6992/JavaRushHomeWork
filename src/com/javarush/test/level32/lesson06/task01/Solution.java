package com.javarush.test.level32.lesson06.task01;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

/* Генератор паролей
Реализуйте логику метода getPassword, который должен возвращать ByteArrayOutputStream, в котором будут байты пароля.
Требования к паролю:
1) 8 символов
2) только цифры и латинские буквы разного регистра
3) обязательно должны присутствовать цифры, и буквы разного регистра
Все сгенерированные пароли должны быть уникальные.
Пример правильного пароля:
wMh7SmNu
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        byte[] all = new byte[62];
        int x = 0;
        for (char i = '0'; i <= '9'; i++, x++) {
            all[x] = (byte) i;
        }
        for (char i = 'A'; i <= 'Z'; i++, x++) {
            all[x] = (byte) i;
        }
        for (char i = 'a'; i <= 'z'; i++, x++) {
            all[x] = (byte) i;
        }
        byte[] res = new byte[8];
        Random random = new Random();
        boolean isOk = false;
        while (!isOk) {
            boolean isThereNumbers = false;
            boolean isThereLowerCase = false;
            boolean isThereUpperCase = false;
            for (int i = 0; i < res.length; i++) {
                int rand = random.nextInt(61);
                res[i] = all[rand];
                if (res[i] >= '0' && res[i] <= '9') {
                    isThereNumbers = true;
                } else if (res[i] >= 'A' && res[i] <= 'Z') {
                    isThereUpperCase = true;
                } else if (res[i] >= 'a' && res[i] <= 'z') {
                    isThereLowerCase = true;
                }
                if (isThereNumbers && isThereUpperCase && isThereLowerCase) {
                    isOk = true;
                }
            }
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            baos.write(res);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return baos;
    }
}
