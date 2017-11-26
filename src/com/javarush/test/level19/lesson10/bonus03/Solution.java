package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File file = new File(reader.readLine());
        reader.close();
        FileInputStream fis = new FileInputStream(file);
        byte[] arr = new byte[fis.available()];
        fis.read(arr);
        fis.close();
        String body = new String(arr);
        String tegS = "<" + args[0];
        String tegF = "</" + args[0] + ">";
        int idxs;
        int idxf;
        int counter;

        while (body.contains(tegS)) {
            body = body.substring(body.indexOf(tegS));
            idxs = body.indexOf(tegS);
            idxf = body.indexOf(tegF);
            counter = 0;

            while (true) {
                counter++;
                idxs += tegS.length();
                if (body.substring(idxs, idxf).contains(tegS)) {
                    idxs += body.substring(idxs, idxf).indexOf(tegS);
                } else {
                    break;
                }
            }

            idxf += tegF.length();
            while (counter > 1) {
                idxf += body.substring(idxf).indexOf(tegF) + tegF.length();
                counter--;
            }

            System.out.println(body.substring(0, idxf));
            body = body.substring(tegS.length());

            while (body.indexOf(tegS) > body.indexOf(tegF)) {
                body = body.substring(body.indexOf(tegF) + tegF.length());
            }
        }
    }
}