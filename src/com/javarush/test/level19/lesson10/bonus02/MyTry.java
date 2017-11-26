package com.javarush.test.level19.lesson10.bonus02;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by vsevolodvisnevskij on 03.11.16.
 */
public class MyTry {
    public static void main(String[] args) throws IOException {
        FileConsoleWriter fileConsoleWriter = new FileConsoleWriter(new File("/Users/vsevolodvisnevskij/IdeaProjects/JavaRushHomeWork/JavaRushHomeWork/my.test"));
        char[] c = {'a','s','d','f','g','h','j','k','l'};
        fileConsoleWriter.write(c);
        fileConsoleWriter.close();
    }
}
