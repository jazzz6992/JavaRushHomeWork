package com.javarush.test.level19.lesson03.task04;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by vsevolodvisnevskij on 31.10.16.
 */
public class TryPer {
    public static void main(String[] args) throws IOException {
        File file = new File("/Users/vsevolodvisnevskij/IdeaProjects/JavaRushHomeWork/JavaRushHomeWork/my.test");
        PersonScanner ps = new Solution.PersonScannerAdapter(new Scanner(file));
        Person person = ps.read();
        System.out.println(person);
    }
}