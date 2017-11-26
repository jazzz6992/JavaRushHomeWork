package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        ArrayList<String> list = new ArrayList<>();
//        ArrayList<String> listVal = new ArrayList<>();
//        try {
//            String url = reader.readLine();
//            String quote = url.substring(url.indexOf("?") + 1);
//            String substr;
//            String param;
//            String value;
//            boolean isOk = true;
//            while (isOk) {
//                int firstAnd = quote.indexOf("&");
//                if (firstAnd == -1) {
//                    isOk = false;
//                    substr = quote;
//                    if (substr.contains("=")) {
//                        param = substr.substring(0, substr.indexOf('='));
//                        list.add(param);
//                        if (param.equals("obj")) {
//                            value = substr.substring(substr.indexOf('=') + 1);
//                            listVal.add(value);
//                        }
//                    } else {
//                        param = substr;
//                        list.add(param);
//                    }
//                    break;
//                }
//                substr = quote.substring(0, firstAnd);
//                if (substr.contains("=")) {
//                    param = substr.substring(0, substr.indexOf('='));
//                    list.add(param);
//                    if (param.equals("obj")) {
//                        value = substr.substring(substr.indexOf('=') + 1);
//                        listVal.add(value);
//                    }
//                } else {
//                    param = substr;
//                    list.add(param);
//                }
//                quote = quote.substring(firstAnd + 1);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        for (int i = 0; i < list.size(); i++) {
//            if (i == list.size() - 1) {
//                System.out.print(list.get(i));
//                System.out.println();
//            } else System.out.print(list.get(i) + " ");
//        }
//
//        for (String value : listVal) {
//            try {
//                if (value.contains(".")) {
//                    alert(Double.parseDouble(value));
//                } else {
//                    alert(Integer.parseInt(value));
//                }
//            } catch (NumberFormatException e) {
//                alert(value);
//            }
//        }
//        reader.close();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> pList = new ArrayList<>();
        ArrayList<String> vList = new ArrayList<>();
        URL url = new URL(reader.readLine());
        reader.close();
        String query = url.getQuery();
        String[] param = query.split("&");
        for (int i = 0; i < param.length; i++) {
            if (param[i].contains("=")) {
                pList.add(param[i].substring(0, param[i].indexOf("=")));
                if (param[i].startsWith("obj=")) {
                    vList.add(param[i].substring(param[i].indexOf("=") + 1));
                }
            } else {
                pList.add(param[i]);
            }
        }

        for (String p : pList) {
            System.out.print(p + " ");
        }
        System.out.println();
        for (String v : vList) {
            try {
                if (v.contains(".")) {
                    alert(Double.parseDouble(v));
                } else {
                    alert(Integer.parseInt(v));
                }
            } catch (NumberFormatException ex) {
                alert(v);
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
