package com.javarush.test.level14.lesson06.home01;

/**
 * Created by vsevolodvisnevskij on 17.10.16.
 */
public class MoldovanHen extends Hen {

    int getCountOfEggsPerMonth() {
        return 25;
    }

    String getDescription() {
        StringBuilder sb = new StringBuilder();
        String s = sb.append(super.getDescription()).append(" Моя страна - " + Country.MOLDOVA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.").toString();
        return s;
    }
}
